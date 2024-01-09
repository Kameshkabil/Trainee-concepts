package com.example.dtoslearning.controller;

import com.example.dtoslearning.dto.PostDto;
import com.example.dtoslearning.model.Posts;
import com.example.dtoslearning.model.User;
import com.example.dtoslearning.service.PostsService;
import com.example.dtoslearning.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api")
public class PostsController {

    @Autowired
    PostsService postsService;
    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Posts> createPost(@RequestBody PostDto postDto){
        User user = userService.findById(postDto.getUserId());

        if(user==null){
            return ResponseEntity.notFound().build();
        }

        Posts posts = new Posts();
        posts.setUser(user);
        posts.setContent(postDto.getContent());

        postsService.savePost(posts);
        return ResponseEntity.ok(posts);
    }


    @GetMapping("/count/{id}")
    public ResponseEntity<String> getPostCountForUser(@PathVariable("id") int id){
        User user = userService.findById(id);
        if (user==null){
            return ResponseEntity.notFound().build();
        }
        long postCount = postsService.countPostsByUser(user);
        return ResponseEntity.ok("{Available Post : "+postCount+"}");
    }
}

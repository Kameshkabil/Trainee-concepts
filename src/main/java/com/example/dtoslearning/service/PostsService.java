package com.example.dtoslearning.service;


import com.example.dtoslearning.model.Posts;
import com.example.dtoslearning.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class PostsService {
    @Autowired
    EntityManager entityManager;

    @Transactional
    public void savePost(Posts posts){
        entityManager.persist(posts);
    }

    public long countPostsByUser(User user) {
        String jpql = "SELECT COUNT(p.id) FROM Posts p WHERE p.user = :user";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("user", user);
        return (long) query.getSingleResult();
    }
}

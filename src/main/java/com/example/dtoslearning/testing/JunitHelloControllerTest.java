package com.example.dtoslearning.testing;

import com.example.dtoslearning.controller.JnitHelloController;
//import org.junit.Test;
import com.example.dtoslearning.controller.ProductController;
import com.example.dtoslearning.model.Product;
import com.example.dtoslearning.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityManager;
import jdk.dynalink.linker.support.Guards;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**********************************************************************************************/
//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.web.servlet.MockMvc;
import

        static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Static import

import

        static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import

        static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@RunWith(SpringRunner.class)
//@WebMvcTest(ProductController.class)

//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc

//@WebMvcTest(JnitHelloController.class)

@RunWith(SpringRunner.class)
@WebMvcTest(JnitHelloController.class)
public class JunitHelloControllerTest {

//    @Autowired
//    MockMvc mockMvc;

//    @Test
//    public void shouldReturnHello()throws Exception{
////       mockMvc.perform((RequestBuilder) get("/api/hello"))
////               .andExpect(status().isOk());
//               //.andExpect(content().string("Hello, World"));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/hello"))
//                .andExpect(status().isOk())
//                .andExpect(content().string("Hello, World"));
//    }





//    @MockBean
//    ProductService productService;
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @Autowired
//     private MockMvc mvc;

//    @Before
//    public void setup(){
//        mvc = MockMvcBuilders.standaloneSetup(new ProductController()).build();
//        objectMapper = new ObjectMapper();
//    }
//    @Test
//    public void test_CreateNewProductsData() throws Exception {
//        Product product = new Product(15L, "shoes", "Desc of shoes.", "foot wear", "nike");
//
//        mvc.perform(post("/api/create-products").contentType(MediaType.APPLICATION_JSON)
//                        .content()
                       // .body(RequestEntity.post("/api/create-products").contentType(MediaType.APPLICATION_JSON)
                        //        .body(objectMapper.writeValueAsString(product)))).andExpect(status().isCreated()).andDo(print());
//                .andExpect(status().isCreated())
//                .andDo(print());
   // }
//        mvc.perform(MockMvcRequestBuilders
//                .post("/api/create-products")
//                .content(asJsonString(new Product(30L,"shoes","description of shoe.","foot wear","NIKE")))
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())
//                .andExpect(MockMvcResultMatchers.jsonPath("$.productId").exists());
//    }
//
//    public static String asJsonString(final Object obj){
//        try{
//            return new ObjectMapper().writeValueAsString(obj);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
//    }

    @Autowired
    private MockMvc mockMvc;

 @Test
 public void testHelloWorldEndpoint() throws Exception{
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, World"));
 }


}
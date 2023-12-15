//package com.example.dtoslearning.repository;
//
//import com.example.dtoslearning.dto.UserDto;
//import com.example.dtoslearning.model.User;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.TypedQuery;
//import jakarta.transaction.Transactional;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
////public interface UserRepository extends JpaRepository<User , Long> {
////
////    User findByEmail(String email);
////}
//
//@Repository
//public class UserRepository {
//    @Autowired
//    private EntityManager entityManager;
//
//    @Transactional
//    public void createNewUser(User user){
//        entityManager.persist(user);
//    }
//
//    public List<User> getAllUsersInformation(){
//        String jpql = "SELECT u FROM User u";
//        TypedQuery<User> query = entityManager.createQuery(jpql,User.class);
//        return query.getResultList();
//    }
//
//
//    public User findById(Integer id){
//        return entityManager.find(User.class ,id);
//    }
//
//
//    @Transactional
//    public void deleteUserById(Integer id){
//        User user = entityManager.find(User.class,id);
//        entityManager.remove(user);
//    }
//}

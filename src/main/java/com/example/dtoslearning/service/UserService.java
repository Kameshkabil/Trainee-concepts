package com.example.dtoslearning.service;

import com.example.dtoslearning.dto.UserDto;
import com.example.dtoslearning.model.User;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@Service
public class UserService {
    @Autowired
    private EntityManager entityManager;

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public List getHistory(long userId){
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        AuditQuery queryHistoryOfUser = reader.createQuery()
                .forRevisionsOfEntity(User.class, true, true)
                .add(AuditEntity.property("userId").eq(userId));
        return queryHistoryOfUser.getResultList();

    }
//    public void createUserAccount(User user){
//        User userExisting = userRepository.findByEmail(user.getEmail());
//        if(userExisting!=null){
//            System.out.println("email already exists"+user.getEmail());
//            throw new IllegalArgumentException();
//        }
//        userRepository.save(user);
//    }

//    public List<UserDto> getAllUsers(){
//        return userRepository.findAll()
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//    }

//    private UserDto convertEntityToDto(User user){
//        UserDto userDto = new UserDto();
//        userDto.setUserId(user.getUserId());
//        userDto.setFirstName(user.getFirstName());
//        userDto.setLastName(user.getLastName());
//        userDto.setEmail(user.getEmail());
//        return userDto;
//    }


    @Transactional
    public void createNewUser(User user){
        entityManager.persist(user);
    }

    public List<UserDto> getAllUsersInformation(){
        String jpql = "SELECT u FROM User u";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
        return query.getResultList()
                .stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }


    public User findById(Integer id){
        return entityManager.find(User.class ,id);
    }


    @Transactional
    public void deleteUserById(Integer id){
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    private UserDto convertEntityToDto(User user){
        UserDto userDto = new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        return userDto;
    }


    public long countUsers(){
        String jpql = "SELECT COUNT(u.userId) FROM User u";
        Query query = entityManager.createQuery(jpql);
        return (long) query.getSingleResult();
    }

}

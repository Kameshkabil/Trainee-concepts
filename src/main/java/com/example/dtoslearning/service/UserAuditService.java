//package com.example.dtoslearning.service;
//
//
//import com.example.dtoslearning.model.User;
//import com.example.dtoslearning.model.UserAudit;
//import com.example.dtoslearning.repository.UserAuditRepo;
//import jakarta.persistence.EntityManager;
//import jakarta.transaction.Transactional;
//import org.hibernate.Session;
//import org.hibernate.envers.AuditReader;
//import org.hibernate.envers.AuditReaderFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//@Transactional
//public class UserAuditService {
//    @Autowired
//    UserAuditRepo userAuditRepo;
//
//    public UserAudit createUserAudit(UserAudit userAudit){
//        return userAuditRepo.save(userAudit);
//    }
//
//    public UserAudit getUserAuditById(Long id){
//        return userAuditRepo.findById(id).or;
//    }
//}
////
////    @Autowired
////    EntityManager entityManager;
////
////    private UserAudit findById(Long id){
////        AuditReader reader = AuditReaderFactory.get((Session) entityManager);
////      return reader.find(UserAudit.class,id,1);
////
////    }
////}

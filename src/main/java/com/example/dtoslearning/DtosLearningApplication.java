package com.example.dtoslearning;

import com.example.dtoslearning.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.Date;

@SpringBootApplication
@EnableTransactionManagement
@EnableScheduling
@EnableFeignClients
@EnableCaching
@ComponentScan(basePackages = {"com.example.dtoslearning"})
public class DtosLearningApplication {

	@Autowired
	UserService userService;

	private static Logger LOG =  LoggerFactory.getLogger(DtosLearningApplication.class);
	public static void main(String[] args) {

		LOG.info("\n 1.STARTING : Spring boot application starting");
		SpringApplication.run(DtosLearningApplication.class, args);
		LOG.info("\n 3.STOPPED : Spring boot application stopped");


//		System.out.println(new Date(System.currentTimeMillis()));
//		System.out.println(new Date(System.currentTimeMillis()+3600*1000));
		System.out.println(new Date(System.currentTimeMillis()));
	}

//	@Override
//	public void run(String... args) throws Exception {
//		LOG.info("2.EXECUTING : command line runner");
//
//		for (int i = 1; i <= 5; i++) {
//			LOG.info("Count = {}", i);
//		}
//
//
//	}

}

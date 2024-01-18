package com.example.dtoslearning.spring_retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class CheckStatusService {
    @Retryable(value = RuntimeException.class, maxAttempts = 3, backoff = @Backoff(3000))
    public String checkStatus(String trackingNumber){
        System.out.println("calling another service to get status!!");
        throw new RuntimeException("service not available!!");
    }

    @Recover
    public String recover() {
        return "Please try after some time...";
    }
}

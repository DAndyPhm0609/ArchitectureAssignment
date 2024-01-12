package com.example.sripepayment;

import com.stripe.Stripe;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SripePaymentApplication {

    @PostConstruct
    public void setup() {
        Stripe.apiKey = "sk_test_51OXdhLDdLrb4k5IPkPQTN9A4RJne85PktPaxCrnb2MHeYgjH1qKRICy2oyDS7XQsRLoebnny66aox2eOHKSw6HH900UULY47Za";
    }

    public static void main(String[] args) {
        SpringApplication.run(SripePaymentApplication.class, args);
    }

}

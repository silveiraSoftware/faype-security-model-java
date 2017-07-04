package com.faype.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by wmfsystem on 7/3/17.
 */
@SpringBootApplication
@EnableAutoConfiguration
public class Application {

    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}

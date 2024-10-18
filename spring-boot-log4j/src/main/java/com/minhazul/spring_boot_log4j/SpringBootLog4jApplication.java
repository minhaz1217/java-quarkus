package com.minhazul.spring_boot_log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLog4jApplication {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(SpringApplication.class);
        logger.info("Hello World!");

        SpringApplication.run(SpringBootLog4jApplication.class, args);
    }

}

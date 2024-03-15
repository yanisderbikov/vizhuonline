package com.vizhu.vizhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.vizhu.vizhu.repo")
public class VizhuApplication {
    public static void main(String[] args) {
        SpringApplication.run(VizhuApplication.class, args);
    }

}

package co.edu.ue.practice4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.ue.practice4.controller", "co.edu.ue.practice4.services",
        "co.edu.ue.practice4.model", "co.edu.ue.practice4.repositories", "co.edu.ue"})
public class Practice4Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice4Application.class, args);
    }

}

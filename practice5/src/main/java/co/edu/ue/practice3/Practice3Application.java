package co.edu.ue.practice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.ue.practice3.controller", "co.edu.ue.practice3.services",
        "co.edu.ue.practice3.model", "co.edu.ue.practice3.repositories", "co.edu.ue"})
public class Practice3Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice3Application.class, args);
    }

}

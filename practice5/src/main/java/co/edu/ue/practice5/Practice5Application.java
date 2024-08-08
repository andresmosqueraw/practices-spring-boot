package co.edu.ue.practice5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.ue.practice5.controller", "co.edu.ue.practice5.services",
        "co.edu.ue.practice5.model", "co.edu.ue.practice5.repositories", "co.edu.ue"})
public class Practice5Application {

    public static void main(String[] args) {
        SpringApplication.run(Practice5Application.class, args);
    }

}

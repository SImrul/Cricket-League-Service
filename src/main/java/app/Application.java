package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/* @ComponentScan only scans packages included, so if the controllers are in different path specify them here */
@SpringBootApplication
@ComponentScan("controller")
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

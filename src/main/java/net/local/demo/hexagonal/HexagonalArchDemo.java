package net.local.demo.hexagonal;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HexagonalArchDemo {
    public static void main(String[] args) {
        new SpringApplicationBuilder(HexagonalArchDemo.class).run(args);
    }
}
package com.example.demo.configuration;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dao.ToDoRepo;
import com.example.demo.model.ToDo;

@Configuration
public class ToDoConfig {

    @Bean
    CommandLineRunner commandLineRunner(ToDoRepo repo) {
        return args -> {
            ToDo fstMsg = new ToDo(1, "first todo message", false);
            ToDo sndMsg = new ToDo(2, "second todo message", false);

            repo.saveAll(List.of(fstMsg, sndMsg));
        };
    }
}
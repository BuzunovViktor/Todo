package main;

import main.entity.ToDoEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import main.repository.ToDoRepository;

import java.util.stream.Stream;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        new SpringApplication(Main.class).run(args);
    }

    @Bean
    CommandLineRunner init(ToDoRepository toDoRepository) {
        return args -> {
            Stream.of("Купить молоко", "Вынести мусор", "Купить Google", "Не забыть замяукать кота", "И так далее").forEach(name -> {
                ToDoEntity toDoEntity = new ToDoEntity();
                toDoEntity.setName(name);
                toDoEntity.setDescription(name);
                toDoRepository.save(toDoEntity);
            });
            toDoRepository.findAll().forEach(System.out::println);
        };
    }
}

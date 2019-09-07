package main.controller;

import main.repository.ToDoRepository;
import main.entity.ToDoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ToDoController {

    @Autowired
    private final ToDoRepository toDoRepository;

    public ToDoController(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    @GetMapping("/todos")
    public List<ToDoEntity> getUsers() {
        return (List<ToDoEntity>) toDoRepository.findAll();
    }

    @PostMapping("/todos")
    void addUser(@RequestBody ToDoEntity toDoEntity) {
        toDoRepository.save(toDoEntity);
    }

}

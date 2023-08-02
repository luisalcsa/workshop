package com.workshop.WorkshopMongo.resources;

import com.workshop.WorkshopMongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResources {

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "maria", "maria@gmail.com");
        User jose = new User("2", "jose", "jose@gmail.com");
        List <User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, jose));
        return ResponseEntity.ok().body(list);
    }
}

package com.workshop.WorkshopMongo.resources;

import com.workshop.WorkshopMongo.domain.Post;
import com.workshop.WorkshopMongo.domain.User;
import com.workshop.WorkshopMongo.dto.UserDto;
import com.workshop.WorkshopMongo.service.PostService;
import com.workshop.WorkshopMongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostsResources {

    @Autowired
    private PostService postServiceService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postServiceService.findById(id);
        return ResponseEntity.ok().body(post);
    }

}

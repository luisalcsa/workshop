package com.workshop.WorkshopMongo.service;

import com.workshop.WorkshopMongo.domain.Post;
import com.workshop.WorkshopMongo.domain.User;
import com.workshop.WorkshopMongo.dto.UserDto;
import com.workshop.WorkshopMongo.repository.PostRepository;
import com.workshop.WorkshopMongo.repository.UserRepository;
import com.workshop.WorkshopMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        return post.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return postRepository.searchTitle(text);
    }

}

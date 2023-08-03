package com.workshop.WorkshopMongo.service;

import com.workshop.WorkshopMongo.domain.User;
import com.workshop.WorkshopMongo.dto.UserDto;
import com.workshop.WorkshopMongo.repository.UserRepository;
import com.workshop.WorkshopMongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(String id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User save(User obj){
        return userRepository.save(obj);
    }

    public void delete(String id){
        findById(id);
        userRepository.deleteById(id);
    }

    public User update(User obj) {
        User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return userRepository.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }

    public User fromDTO(UserDto objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }

}


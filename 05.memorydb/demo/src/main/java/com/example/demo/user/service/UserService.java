package com.example.demo.user.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


// Controller(receives http request)
// <-> Service (handles business logic: get/save data from/to DB, process, then return to controller)
// <-> Repository(DB)
@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired // tells spring container to inject bean here
    private UserRepository userRepository;

    public UserEntity save(UserEntity user){
        //Save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

}

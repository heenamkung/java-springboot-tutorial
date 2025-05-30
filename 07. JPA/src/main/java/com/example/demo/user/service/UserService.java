package com.example.demo.user.service;

import com.example.demo.user.db.UserRepository;
import com.example.demo.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // injects userRepository
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserEntity save(UserEntity user){
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public void delete(Long id){
        userRepository.delete(id);
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

}

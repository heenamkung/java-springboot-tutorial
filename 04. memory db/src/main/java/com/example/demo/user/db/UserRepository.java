package com.example.demo.user.db;

import com.example.demo.db.SimpleDataRepository;
import com.example.demo.user.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {
}

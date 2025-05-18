package com.example.demo.user.model;

import com.example.demo.entity.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity {
    private String name;
    private int score;
}

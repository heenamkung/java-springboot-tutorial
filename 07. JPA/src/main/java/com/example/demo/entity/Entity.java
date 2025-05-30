package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity implements PrimaryKey {
    private Long id;
}

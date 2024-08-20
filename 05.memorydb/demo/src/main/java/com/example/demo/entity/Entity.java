package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Entity implements PrimaryKey {

    private Long id;
}

package com.example.demo.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {
    //CRUD

    //CREATE - if not there, insert. if there, update. hence same as UPDATE
    T save(T data);

    //READ
    Optional<T> findById(ID id);

    //UPDATE - same as CREATE

    //DELETE
    void delete(ID id);

    List<T> findAll();
}

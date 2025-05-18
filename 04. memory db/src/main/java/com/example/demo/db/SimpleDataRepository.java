package com.example.demo.db;

import com.example.demo.entity.Entity;

import java.util.*;
import java.util.stream.Collectors;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T,ID> {

    private List<T> dataList = new ArrayList<T>();

    private static long index = 0;

    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };

    //CRUD
    //create
    @Override
    public T save(T data) {
        if(Objects.isNull(data)){
            throw new RuntimeException("Data is null");
        }

        //does it exist in db?
        var prevData = dataList.stream()
                .filter(it->{
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if(prevData.isPresent()){
            dataList.remove(prevData.get()); // without get(), prevData = Optional<T> which is not correct datatype in List<T>
            dataList.add(data);
        }else{
            index++;
            data.setId(index);
            dataList.add(data);
        }

        return data;
    }

    //read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it->
                    it.getId().equals(id)
                )
                .findFirst();
    }

    //delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter((it -> {
                    return (it.getId().equals(id));
                }))
                .findFirst();

        if(deleteEntity.isPresent()){
            dataList.remove(deleteEntity.get());
        }
    }

    @Override
    public List<T> findAll() {
        return dataList
                .stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }
}

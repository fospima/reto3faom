package com.example.reto3faom.repository;


import com.example.reto3faom.model.Motorbike;
import com.example.reto3faom.repository.CrudRepository.MotorbikeCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MotorbikeRepository {

    @Autowired
    private MotorbikeCrudRepository motorbikeCrudRepository;
    public List<Motorbike> getAll(){
        return (List<Motorbike>) motorbikeCrudRepository.findAll();
    }
    public Optional<Motorbike> getMotorbikes(int id){
        return motorbikeCrudRepository.findById(id);
    }
    public Motorbike save(Motorbike m){
        return motorbikeCrudRepository.save(m);
    }
    public void delete(Motorbike m){
        motorbikeCrudRepository.delete(m);
    }
}

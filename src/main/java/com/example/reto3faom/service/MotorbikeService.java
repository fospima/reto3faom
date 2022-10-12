package com.example.reto3faom.service;


import com.example.reto3faom.model.Motorbike;
import com.example.reto3faom.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {
    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll(){
        return motorbikeRepository.getAll();
    }
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }

    public Motorbike save(Motorbike m){
        if(m.getId()==null){
            return motorbikeRepository.save(m);
        }else{
            Optional<Motorbike> e = motorbikeRepository.getMotorbike(m.getId());
            if(e.isPresent()){
                return m;
            }else{
                return motorbikeRepository.save(m);
            }
        }

    }
    public Motorbike update(Motorbike m){
        if(m.getId()!=null){
            Optional<Motorbike> x = motorbikeRepository.getMotorbike(m.getId());
            if(x.isPresent()){
                if (m.getId() != null) {
                    x.get().setId(m.getId());
                }
                if (m.getName() != null) {
                    x.get().setName(m.getName());
                }
                if (m.getBrand() != null) {
                    x.get().setBrand(m.getBrand());
                }
                if(m.getDescription()!=null) {
                    x.get().setDescription(m.getDescription());
                }
                if (m.getYear() != null) {
                    x.get().setYear(m.getYear());
                }
                if(m.getCategory()!=null) {
                    x.get().setCategory(m.getCategory());
                }
                motorbikeRepository.save(x.get());
                return x.get();

            }else{
                return m;
            }

        }else{
            return m;

        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Motorbike>m= motorbikeRepository.getMotorbike(id);
        if(m.isPresent()){
            motorbikeRepository.delete(m.get());
            flag=true;
        }

        return flag;
    }
}

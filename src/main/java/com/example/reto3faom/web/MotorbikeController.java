package com.example.reto3faom.web;


import com.example.reto3faom.model.Motorbike;
import com.example.reto3faom.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Motorbike")
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("/all")
    public List<Motorbike> getAll(){
        return motorbikeService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Motorbike> getMotorbike(@PathVariable("id") int motorbikeId){
        return motorbikeService.getMotorbike(motorbikeId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike m){
        return motorbikeService.save(m);
    }
    @PutMapping("/update")
    //@ResponseStatus(HttpStatus.OK)
    public Motorbike update(@RequestBody Motorbike motorbike){
        return motorbikeService.update(motorbike);
    }
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") int motorbikeId){
        return motorbikeService.delete(motorbikeId);
    }
}

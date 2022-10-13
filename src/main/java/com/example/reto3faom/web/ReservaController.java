package com.example.reto3faom.web;


import com.example.reto3faom.model.Reserva;
import com.example.reto3faom.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/all")
    public List<Reserva> getAll(){
        return reservaService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reserva> getReserva(@PathVariable("id") int reservaId){
        return reservaService.getReserva(reservaId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva r){
        return reservaService.save(r);
    }
    @PutMapping("/update")
    public Reserva update(@RequestBody Reserva reserva){
        return reservaService.update(reserva);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int reservaId){
        return reservaService.delete(reservaId);
    }
}

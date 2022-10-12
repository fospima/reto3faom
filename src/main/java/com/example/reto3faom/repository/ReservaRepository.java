package com.example.reto3faom.repository;




import com.example.reto3faom.model.Reserva;
import com.example.reto3faom.repository.CrudRepository.ReservaCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;
    public List<Reserva> getAll(){
        return (List<Reserva>) reservaCrudRepository.findAll();
    }
    public Optional<Reserva> getReserva(int id){
        return reservaCrudRepository.findById(id);
    }
    public Reserva save(Reserva r){
        return reservaCrudRepository.save(r);
    }
    public void delete(Reserva r){
        reservaCrudRepository.delete(r);
    }
}

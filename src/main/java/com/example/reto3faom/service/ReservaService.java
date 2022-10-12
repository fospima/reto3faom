package com.example.reto3faom.service;


import com.example.reto3faom.model.Reserva;
import com.example.reto3faom.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAll(){
        return reservaRepository.getAll();
    }
    public Optional<Reserva> getReserva(int id){
        return reservaRepository.getReserva(id);
    }

    public Reserva save(Reserva r) {

        String  created = "created";
        if (r.getIdReservation() == null) {
            r.setStatus(created);
            return reservaRepository.save(r);
        } else {
            Optional<Reserva> e = reservaRepository.getReserva(r.getIdReservation());

            if (e.isPresent()) {
                return r;
            }else{
                return reservaRepository.save(r);
            }
        }

    }
    public Reserva update(Reserva r){
        if(r.getIdReservation()!=null){
            Optional<Reserva> q = reservaRepository.getReserva(r.getIdReservation());
            if(q.isPresent()){
                if(r.getIdReservation()!=null) {
                    q.get().setIdReservation(r.getIdReservation());
                }
                if(r.getStartDate()!=null) {
                    q.get().setStartDate(r.getStartDate());
                }
                if(r.getDevolutionDate()!=null) {
                    q.get().setDevolutionDate(r.getDevolutionDate());
                }
                reservaRepository.save(q.get());
                return q.get();
            }else{
                return r;
            }
        }else{
            return r;
        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reserva>p= reservaRepository.getReserva(id);
        if(p.isPresent()){
            reservaRepository.delete(p.get());
            flag=true;
        }
        return flag;

    }

}

package com.example.reto3faom.repository.CrudRepository;


import com.example.reto3faom.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}

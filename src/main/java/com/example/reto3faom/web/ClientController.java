package com.example.reto3faom.web;

import com.example.reto3faom.model.Client;
import com.example.reto3faom.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int clientId){
        return clientService.getClient(clientId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client c){
        return clientService.save(c);
    }
    @PutMapping("/update")
    //@ResponseStatus(HttpStatus.OK)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }
    @DeleteMapping("/{id}")
    //@ResponseStatus(HttpStatus.OK)
    public boolean delete(@PathVariable("id") int clientId){
        return clientService.delete(clientId);
    }

}

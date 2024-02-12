package com.lexosis.bazaar.controller;

import com.lexosis.bazaar.model.Client;
import com.lexosis.bazaar.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private IClientService clientService;

    @GetMapping("/clients")
    public ResponseEntity<List<Client>> getAllClient(){
        return clientService.getAllClient();
    }

    @PostMapping("/clients/created")
    public ResponseEntity saveClient(@RequestBody Client client){
        return clientService.saveClient(client);
    }


    @DeleteMapping("/clients/delete/{id}")
    public ResponseEntity deleteClient(@PathVariable Long id){
        return clientService.deleteClient(id);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> findClient(@PathVariable Long id){
        return clientService.findClient(id);
    }

    @PutMapping("/clients/edit")
    public ResponseEntity editClient(@RequestBody Client client){
        return clientService.editClient(client);
    }
}

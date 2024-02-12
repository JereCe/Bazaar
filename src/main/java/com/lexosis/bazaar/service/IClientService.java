package com.lexosis.bazaar.service;

import com.lexosis.bazaar.model.Client;
import com.lexosis.bazaar.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IClientService {

    public ResponseEntity<List<Client>> getAllClient();

    public ResponseEntity saveClient(Client client);

    public ResponseEntity deleteClient(Long id);


    public ResponseEntity editClient(Client client);


    public ResponseEntity<Client> findClient(Long id);

}

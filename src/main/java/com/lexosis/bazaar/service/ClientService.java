package com.lexosis.bazaar.service;

import com.lexosis.bazaar.model.Client;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements IClientService {
    @Override
    public ResponseEntity<List<Client>> getAllClient() {
        return null;
    }

    @Override
    public ResponseEntity saveClient(Client client) {
        return null;
    }

    @Override
    public ResponseEntity deleteClient(Long id) {
        return null;
    }

    @Override
    public ResponseEntity editClient(Client client) {
        return null;
    }


    @Override
    public ResponseEntity findClient(Long id) {
        return null;
    }
}

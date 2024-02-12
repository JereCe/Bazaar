package com.lexosis.bazaar.service;

import com.lexosis.bazaar.model.Sale;
import com.lexosis.bazaar.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class SaleService implements  ISaleService{

    @Autowired
    private ISaleRepository saleRepository;
    @Override
    public ResponseEntity<List<Sale>> getAllSale() {
        try {
            List<Sale> saleList = saleRepository.findAll();
            return ResponseEntity.ok(saleList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity saveSale(Sale sale) {
        try {
            saleRepository.save(sale);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity deleteSale(Long id) {
        try {
            saleRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity editSale(Sale sale) {
        try {
            this.saveSale(sale);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity <Sale> findSale(Long id) {
        try {
            Sale sale = saleRepository.findById(id).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST,"sale not found"));
            return ResponseEntity.ok(sale);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }
}

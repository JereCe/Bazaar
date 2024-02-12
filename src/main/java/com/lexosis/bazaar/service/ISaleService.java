package com.lexosis.bazaar.service;


import com.lexosis.bazaar.model.Sale;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISaleService {

    public ResponseEntity<List<Sale>> getAllSale();

    public ResponseEntity saveSale(Sale sale);

    public ResponseEntity deleteSale(Long saleCode);


    public ResponseEntity editSale(Sale sale);


    public ResponseEntity <Sale> findSale(Long saleCode);
}

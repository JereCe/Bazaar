package com.lexosis.bazaar.controller;

import com.lexosis.bazaar.model.Sale;
import com.lexosis.bazaar.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SaleController {
    @Autowired
    private ISaleService saleService;

    @GetMapping("/sales")
    public ResponseEntity <List<Sale>> getAllSales(){
        return saleService.getAllSale();
    }

    @PostMapping("/sales/create")
    public ResponseEntity saveSale(@RequestBody Sale sale){
        return saleService.saveSale(sale);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Sale> findSale(@PathVariable Long saleCode){
        return saleService.findSale(saleCode);
    }

    @DeleteMapping("/sales/delete/{codigoVenta}")
    public ResponseEntity deleteSale(@PathVariable Long saleCode){
        return saleService.deleteSale(saleCode);
    }

    @PutMapping("/sales/edit")
    public ResponseEntity editSale(@RequestBody Sale sale){
        return saleService.editSale(sale);
    }



}

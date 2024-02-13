package com.lexosis.bazaar.controller;

import com.lexosis.bazaar.dto.ClientSaleProductDTO;
import com.lexosis.bazaar.dto.SalesOfDayDTO;
import com.lexosis.bazaar.model.Product;
import com.lexosis.bazaar.model.Sale;
import com.lexosis.bazaar.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @GetMapping("/sales/{saleCode}")
    public ResponseEntity<Sale> findSale(@PathVariable Long saleCode){
        return saleService.findSale(saleCode);
    }

    @DeleteMapping("/sales/delete/{saleCode}")
    public ResponseEntity deleteSale(@PathVariable Long saleCode){
        return saleService.deleteSale(saleCode);
    }

    @PutMapping("/sales/edit")
    public ResponseEntity editSale(@RequestBody Sale sale){
        return saleService.editSale(sale);
    }

    @GetMapping("/sales/products/{saleCode}")
    public ResponseEntity<List<Product>>getProductsInSale(@PathVariable Long saleCode){
        return saleService.getProductsInSale(saleCode);

    }

    @GetMapping("/sales/{saleDate}")
    public ResponseEntity<SalesOfDayDTO>getDailySalesReport(@PathVariable LocalDate saleDate){
        return saleService.getDailySalesReport(saleDate);
    }

    @GetMapping("/sales/biggestSale")
    public ResponseEntity<ClientSaleProductDTO> getSaleWithHighestTotal(){
        return saleService.getSaleWithHighestTotal();
    }





}

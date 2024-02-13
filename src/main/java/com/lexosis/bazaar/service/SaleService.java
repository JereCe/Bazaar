package com.lexosis.bazaar.service;

import com.lexosis.bazaar.dto.SalesOfDayDTO;
import com.lexosis.bazaar.model.Product;
import com.lexosis.bazaar.model.Sale;
import com.lexosis.bazaar.repository.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements  ISaleService{

    @Autowired
    private ISaleRepository saleRepository;
    @Autowired
    private IProductService productService;

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

            List<Product> products = sale.getProductList();
            for(Product p : products){
                Product ptemp = productService.findProduct(p.getProductCode()).getBody();
                sale.setTotal(sale.getTotal()+ptemp.getPrice());
                productService.decreaseStockProduct(ptemp, 1.0);
            }

            saleRepository.save(sale);



            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity deleteSale(Long saleCode) {
        try {
            saleRepository.deleteById(saleCode);
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
    public ResponseEntity <Sale> findSale(Long saleCode) {
        try {
            Sale sale = saleRepository.findById(saleCode).orElseThrow(()->new HttpClientErrorException(HttpStatus.BAD_REQUEST,"sale not found"));
            return ResponseEntity.ok(sale);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }
    }

    @Override
    public ResponseEntity<List<Product>> getProductsInSale(Long code) {
        try {
            List<Product> productList = saleRepository.getProductsInSale(code);
            return ResponseEntity.ok(productList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Override
    public ResponseEntity<SalesOfDayDTO> getDailySalesReport(LocalDate date) {
        try {
            List<Sale> sale = saleRepository.getDailySalesReport(date);
            SalesOfDayDTO saleDay = new SalesOfDayDTO();
            for(Sale s :sale){
                saleDay.setTotalSales(saleDay.getTotalSales()+s.getTotal());
                saleDay.setTotalSalesCount(saleDay.getTotalSalesCount()+1);
            }
            return ResponseEntity.ok(saleDay);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

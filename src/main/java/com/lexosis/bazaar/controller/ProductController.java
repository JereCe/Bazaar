package com.lexosis.bazaar.controller;

import com.lexosis.bazaar.model.Product;
import com.lexosis.bazaar.service.IProductService;
import com.lexosis.bazaar.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProduct(){
        return productService.getAllProduct();
    }

    @PostMapping("/products/create")
    public ResponseEntity saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/products/delete{productCode}")
    public ResponseEntity deleteProduct(Long productCode){
        return productService.deleteProduct(productCode);
    }
    @GetMapping("/products/{productCode}")
    public ResponseEntity<Product> findProduct(@PathVariable Long productCode){
        return productService.findProduct(productCode);
    }

    @PutMapping("/products/edit")
    public ResponseEntity editProduct(@RequestBody Product product){
        return productService.editProduct(product);
    }





}

package com.lexosis.bazaar.service;

import com.lexosis.bazaar.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IProductService {

    public ResponseEntity<List<Product>> getAllProduct();

    public ResponseEntity saveProduct(Product product);

    public ResponseEntity deleteProduct(Long id);


    public ResponseEntity editProduct(Product product);


    public ResponseEntity<Product> findProduct(Long id);
}

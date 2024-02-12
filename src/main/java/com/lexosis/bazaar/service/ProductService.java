package com.lexosis.bazaar.service;

import com.lexosis.bazaar.model.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class ProductService  implements IProductService{


    @Override
    public ResponseEntity<List<Product>> getAllProduct() {
        return null;
    }

    @Override
    public ResponseEntity saveProduct(Product product) {
        return null;
    }

    @Override
    public ResponseEntity deleteProduct(Long id) {
        return null;
    }

    @Override
    public ResponseEntity editProduct(Product product) {
        return null;
    }

    @Override
    public ResponseEntity findProduct(Long id) {
        return null;
    }
}

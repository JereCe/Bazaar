package com.lexosis.bazaar.repository;


import com.lexosis.bazaar.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p   WHERE p.inventory < 5")
    List<Product> isStockLow();



}

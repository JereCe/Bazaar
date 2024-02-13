package com.lexosis.bazaar.repository;

import com.lexosis.bazaar.model.Product;
import com.lexosis.bazaar.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale,Long> {

    @Query("SELECT s.productList FROM Sale s   WHERE s.saleCode = :code" )
    List<Product> getProductsInSale(Long code);

    @Query("SELECT s FROM Sale s   WHERE s.dateOfSale = :date" )
    List<Sale> getDailySalesReport(LocalDate date);


}

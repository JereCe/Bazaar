package com.lexosis.bazaar.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long saleCode;
    private LocalDate dateOfSale;
    private double total;
    @ManyToMany
    private List<Product> productList;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;


}

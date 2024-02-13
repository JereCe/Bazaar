package com.lexosis.bazaar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class ClientSaleProductDTO {

    private Long saleCode;
    private double total;
    private int quantityProduct;
    private String clientName;
    private String clientLastName;


}

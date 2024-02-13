package com.lexosis.bazaar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class SalesOfDayDTO {
    private double totalSales;

    private int totalSalesCount;
}

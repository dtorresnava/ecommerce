package com.inditex.ecommerce.domain.model;

import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class Price {
    private Long id;
    private Brand brand;
    private Date startDate;
    private Date endDate;
    private Product product;
    private Integer priority;
    private BigDecimal amount;
    private String currency;
    private Integer priceList;
}

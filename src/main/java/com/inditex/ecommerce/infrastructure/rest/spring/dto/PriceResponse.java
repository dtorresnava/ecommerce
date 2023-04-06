package com.inditex.ecommerce.infrastructure.rest.spring.dto;

import java.math.BigDecimal;
import java.util.Date;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse {
  private Long productId;
  private Long brandId;
  private Date startDate;
  private Date endDate;
  private Integer priceList;
  private BigDecimal amount;
}

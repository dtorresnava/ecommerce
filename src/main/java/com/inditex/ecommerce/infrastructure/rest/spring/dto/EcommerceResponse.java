package com.inditex.ecommerce.infrastructure.rest.spring.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@SuperBuilder
public class EcommerceResponse<R> {

  private String result;
  private String message;
  private List<R> payload;
}

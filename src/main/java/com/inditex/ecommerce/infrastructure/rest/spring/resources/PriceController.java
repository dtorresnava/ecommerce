package com.inditex.ecommerce.infrastructure.rest.spring.resources;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.application.service.PriceServiceImpl;
import com.inditex.ecommerce.infrastructure.rest.spring.dto.PriceAbstractResponse;
import com.inditex.ecommerce.infrastructure.rest.spring.mapper.PriceMapper;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/price")
@RestController
@AllArgsConstructor
public class PriceController {

  private final PriceServiceImpl service;
  private final PriceMapper priceMapper;

  @GetMapping("/all")
  public ResponseEntity<PriceAbstractResponse> getAllPrices() {
    try {
      List<Price> priceDTOList = service.getAllProductPrice();
      return getPriceAbstractResponseResponseEntity(priceDTOList);

    } catch (Exception e) {
      return new ResponseEntity<>(
          PriceAbstractResponse.builder().result("01").message(e.getMessage()).build(),
          HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping()
  public ResponseEntity<PriceAbstractResponse> getAllPricesWithFilter(
      @RequestParam String date, @RequestParam String productId, @RequestParam String brandId) {
    try {
      List<Price> priceDTOList =
          service.getProductWithFilter(date, Long.valueOf(productId), Long.valueOf(brandId));
      return getPriceAbstractResponseResponseEntity(priceDTOList);

    } catch (Exception e) {
      return new ResponseEntity<>(
          PriceAbstractResponse.builder().result("01").message(e.getMessage()).build(),
          HttpStatus.BAD_REQUEST);
    }
  }

  private ResponseEntity<PriceAbstractResponse> getPriceAbstractResponseResponseEntity(
      List<Price> priceDTOList) {

    if (priceDTOList.isEmpty()) {
      return new ResponseEntity<>(
          PriceAbstractResponse.builder()
              .result("00")
              .message("No price info")
              .payload(Collections.emptyList())
              .build(),
          HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(
          PriceAbstractResponse.builder()
              .result("01")
              .message("Find price data")
              .payload(
                  priceDTOList.stream()
                      .map(priceMapper::priceToPriceResponse)
                      .collect(Collectors.toList()))
              .build(),
          HttpStatus.OK);
    }
  }
}

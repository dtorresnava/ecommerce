package com.inditex.ecommerce.application.service;

import com.inditex.ecommerce.domain.service.PriceService;
import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.repository.PriceRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;

  @Override
  public List<Price> getAllProductPrice() {
    return priceRepository.getAllProductPrice();
  }

  @Override
  public List<Price> getProductWithFilter(
      String date, Long productId, Long brandId) throws ParseException {
    Date dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
    List<Price> priceList = priceRepository.getProductWithFilter(dateFormat, productId, brandId);

    Optional<Price> priceOptional= priceList.stream().max(Comparator.comparing(Price::getPriority));
    if (priceOptional.isEmpty()) {
      return Collections.emptyList();
    }
    return priceOptional.stream().collect(Collectors.toList());
  }
}

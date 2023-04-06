package com.inditex.ecommerce.domain.service;

import com.inditex.ecommerce.domain.model.Price;
import java.text.ParseException;
import java.util.List;

public interface PriceService {
    public List<Price> getAllProductPrice();
    List<Price> getProductWithFilter(String date, Long aLong, Long aLong1) throws ParseException;
}

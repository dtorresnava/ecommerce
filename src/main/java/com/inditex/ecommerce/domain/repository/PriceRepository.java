package com.inditex.ecommerce.domain.repository;

import com.inditex.ecommerce.domain.model.Price;

import java.util.Date;
import java.util.List;

public interface PriceRepository {
    List<Price> getProductWithFilter(Date date, Long productId, Long brandId);

    List<Price> getAllProductPrice();
}

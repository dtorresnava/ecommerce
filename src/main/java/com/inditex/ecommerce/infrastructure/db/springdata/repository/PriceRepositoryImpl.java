package com.inditex.ecommerce.infrastructure.db.springdata.repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.inditex.ecommerce.domain.repository.PriceRepository;
import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.infrastructure.db.springdata.dbo.PriceEntity;
import com.inditex.ecommerce.infrastructure.db.springdata.mapper.PriceEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PriceRepositoryImpl implements PriceRepository {

  private final PriceEntityRepository priceEntityRepository;
  private final PriceEntityMapper priceMapper;

  @Override
  public List<Price> getProductWithFilter(Date date, Long productId, Long brandId) {
    List<PriceEntity> priceEntityList = priceEntityRepository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
            brandId, productId, date, date);
    return priceEntityList.stream().map(priceMapper::priceToPriceDTO).collect(Collectors.toList());
  }

  @Override
  public List<Price> getAllProductPrice() {
    List<PriceEntity> priceEntityList = priceEntityRepository.findAll();
    return priceEntityList.stream().map(priceMapper::priceToPriceDTO).collect(Collectors.toList());
  }
}

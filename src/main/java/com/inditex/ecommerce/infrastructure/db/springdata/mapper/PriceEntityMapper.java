package com.inditex.ecommerce.infrastructure.db.springdata.mapper;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.infrastructure.db.springdata.dbo.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {
  Price priceToPriceDTO(PriceEntity priceEntityList);

}

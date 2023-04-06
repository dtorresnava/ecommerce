package com.inditex.ecommerce.infrastructure.rest.spring.mapper;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.infrastructure.rest.spring.dto.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    @Mapping(target = "productId", source = "product.id")
    @Mapping(target = "brandId", source = "brand.id")
    PriceResponse priceToPriceResponse(Price price);
}

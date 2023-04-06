package com.inditex.ecommerce.infrastructure.config.spring;

import com.inditex.ecommerce.domain.repository.PriceRepository;
import com.inditex.ecommerce.application.service.PriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EcommerceApplicationServiceConfig {

  @Bean
  public PriceServiceImpl priceService(PriceRepository priceRepository) {
    return new PriceServiceImpl(priceRepository);
  }
}
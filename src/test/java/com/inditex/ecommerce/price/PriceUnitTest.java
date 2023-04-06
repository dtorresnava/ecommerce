package com.inditex.ecommerce.price;

import com.inditex.ecommerce.domain.model.Price;
import com.inditex.ecommerce.domain.repository.PriceRepository;
import com.inditex.ecommerce.application.service.PriceServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PriceUnitTest {

    PriceServiceImpl priceService;
    @Mock
    private PriceRepository priceRepository;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        priceService = new PriceServiceImpl(priceRepository);
    }

    @Test
    void getAllProductPriceTest() {

        List<Price> priceList = new ArrayList<>();
        Mockito.when(priceRepository.getAllProductPrice()).thenReturn(priceList);
        List<Price> priceResultList = priceService.getAllProductPrice();
        Assertions.assertEquals(priceList, priceResultList);
    }
}

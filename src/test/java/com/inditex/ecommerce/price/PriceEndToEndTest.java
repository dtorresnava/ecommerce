package com.inditex.ecommerce.price;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.inditex.ecommerce.infrastructure.rest.spring.dto.PriceAbstractResponse;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest(
    classes = com.inditex.ecommerce.infrastructure.config.spring.EcommerceApplication.class)
class PriceEndToEndTest {

  private static final String DATE_PARAM = "date";
  private static final String BRAND_ID_PARAM = "brandId";
  private static final String PRODUCT_ID_PARAM = "productId";

  @Autowired private MockMvc mockMvc;
  @Autowired private ObjectMapper objectMapper;

  @Test
  void getAllProductPriceTest() throws Exception {
    MvcResult result =
        mockMvc
            .perform(MockMvcRequestBuilders.get("/price/all"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    PriceAbstractResponse price =
        objectMapper.readValue(
            result.getResponse().getContentAsString(), PriceAbstractResponse.class);
    Assertions.assertFalse(price.getPayload().isEmpty());
  }

  @Test
  void getAllPricesWithFilterErrorTest() throws Exception {
    MvcResult result =
        mockMvc
            .perform(MockMvcRequestBuilders.get("/price"))
            .andExpect(MockMvcResultMatchers.status().is4xxClientError())
            .andReturn();
    Assertions.assertEquals(400, result.getResponse().getStatus(), "Bad request");
  }

  @Test
  void getAllPricesWithFilterEmptyResultTest() throws Exception {
    MvcResult result =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/price")
                    .param(DATE_PARAM, "2020-06-10 10:00:00")
                    .param(BRAND_ID_PARAM, "1")
                    .param(PRODUCT_ID_PARAM, "35455"))
            .andExpect(MockMvcResultMatchers.status().isNotFound())
            .andReturn();
    PriceAbstractResponse priceResponse =
        objectMapper.readValue(
            result.getResponse().getContentAsString(), PriceAbstractResponse.class);
    Assertions.assertTrue(priceResponse.getPayload().isEmpty());
    Assertions.assertEquals("No price info", priceResponse.getMessage());
  }

  /**
   * Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ZARA)
   *
   * @throws Exception
   */
  @Test
  void getAllPricesWithFilterTestCase1() throws Exception {
    // String date, @RequestParam String productId, @RequestParam String brandId
    MvcResult resultTest =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/price")
                    .param(DATE_PARAM, "2020-06-14 10:00:00")
                    .param(BRAND_ID_PARAM, "1")
                    .param(PRODUCT_ID_PARAM, "35455"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    Assertions.assertEquals(200, resultTest.getResponse().getStatus(), "Result test 1 found");
    PriceAbstractResponse priceResponse =
        objectMapper.readValue(
            resultTest.getResponse().getContentAsString(), PriceAbstractResponse.class);
    Assertions.assertEquals(1, priceResponse.getPayload().size());
    Assertions.assertEquals(new BigDecimal("35.50"), priceResponse.getPayload().get(0).getAmount());
  }

  /**
   * Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ZARA)
   *
   * @throws Exception
   */
  @Test
  void getAllPricesWithFilterTestCase2() throws Exception {
    MvcResult resultTest2 =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/price")
                    .param(DATE_PARAM, "2020-06-14 16:00:00")
                    .param(BRAND_ID_PARAM, "1")
                    .param(PRODUCT_ID_PARAM, "35455"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    Assertions.assertEquals(200, resultTest2.getResponse().getStatus(), "Result test 2 found");
    PriceAbstractResponse priceResponse2 =
        objectMapper.readValue(
            resultTest2.getResponse().getContentAsString(), PriceAbstractResponse.class);
    Assertions.assertEquals(1, priceResponse2.getPayload().size());
    Assertions.assertEquals(
        new BigDecimal("25.45"), priceResponse2.getPayload().get(0).getAmount());
  }

  /**
   * Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ZARA)
   *
   * @throws Exception
   */
  @Test
  void getAllPricesWithFilterTestCase3() throws Exception {
    MvcResult resultTest2 =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/price")
                    .param(DATE_PARAM, "2020-06-14 21:00:00")
                    .param(BRAND_ID_PARAM, "1")
                    .param(PRODUCT_ID_PARAM, "35455"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    Assertions.assertEquals(200, resultTest2.getResponse().getStatus(), "Result test 2 found");
    PriceAbstractResponse priceResponse2 =
        objectMapper.readValue(
            resultTest2.getResponse().getContentAsString(), PriceAbstractResponse.class);
    Assertions.assertEquals(1, priceResponse2.getPayload().size());
    Assertions.assertEquals(
        new BigDecimal("35.50"), priceResponse2.getPayload().get(0).getAmount());
  }

  /**
   * Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ZARA)
   *
   * @throws Exception
   */
  @Test
  void getAllPricesWithFilterTestCase4() throws Exception {
    MvcResult resultTest2 =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/price")
                    .param(DATE_PARAM, "2020-06-15 10:00:00")
                    .param(BRAND_ID_PARAM, "1")
                    .param(PRODUCT_ID_PARAM, "35455"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    Assertions.assertEquals(200, resultTest2.getResponse().getStatus(), "Result test 2 found");
    PriceAbstractResponse priceResponse2 =
        objectMapper.readValue(
            resultTest2.getResponse().getContentAsString(), PriceAbstractResponse.class);
    Assertions.assertEquals(1, priceResponse2.getPayload().size());
    Assertions.assertEquals(
        new BigDecimal("30.50"), priceResponse2.getPayload().get(0).getAmount());
  }

  /**
   * Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ZARA)
   *
   * @throws Exception
   */
  @Test
  void getAllPricesWithFilterTestCase5() throws Exception {
    MvcResult resultTest2 =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/price")
                    .param(DATE_PARAM, "2020-06-16 21:00:00")
                    .param(BRAND_ID_PARAM, "1")
                    .param(PRODUCT_ID_PARAM, "35455"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    Assertions.assertEquals(200, resultTest2.getResponse().getStatus(), "Result test 2 found");
    PriceAbstractResponse priceResponse2 =
        objectMapper.readValue(
            resultTest2.getResponse().getContentAsString(), PriceAbstractResponse.class);
    Assertions.assertEquals(1, priceResponse2.getPayload().size());
    Assertions.assertEquals(
        new BigDecimal("38.95"), priceResponse2.getPayload().get(0).getAmount());
  }
}

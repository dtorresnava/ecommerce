package com.inditex.ecommerce;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.inditex.ecommerce.infrastructure.config.spring.EcommerceApplication.class)
class EcommerceApplicationTests {

	@Test
	void contextLoads() {
		assertTrue(true);
	}

}

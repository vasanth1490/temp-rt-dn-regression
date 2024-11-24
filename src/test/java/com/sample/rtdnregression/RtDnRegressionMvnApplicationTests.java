package com.sample.rtdnregression;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.rtdnregression.services.ValidationService;

@SpringBootTest
class RtDnRegressionMvnApplicationTests {

	@Autowired
	private ValidationService validationService;

	@Test
	void regressionTesting() {
		validationService.validation();
		assertTrue(true);
	}

}

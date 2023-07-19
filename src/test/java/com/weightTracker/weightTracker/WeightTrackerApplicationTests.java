package com.weightTracker.weightTracker;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootTest
class WeightTrackerApplicationTests {
	private static final Logger log = LoggerFactory.getLogger(WeightTrackerApplication.class);

	@Test
	void contextLoads() {
		log.info("Starting contextLoads test...");
		// Your test code here...
		log.info("Finished contextLoads test");
	}

}



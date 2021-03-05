package com.tutorial.coches;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableAutoConfiguration(exclude=FlywayAutoConfiguration.class)
class CochesApplicationTests {

	@Test
	void contextLoads() {
	}

}

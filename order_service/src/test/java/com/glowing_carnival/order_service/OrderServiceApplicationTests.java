package com.glowing_carnival.order_service;


import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;

// WIP
// Error finding restAssured 
// timelaps: 1:30:55


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.testcontainers.containers.MySQLContainer;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderServiceApplicationTests {

	@ServiceConnection
	static MySQLContainer mySQLContainer = new MySQLContainer<>("mysql:8.3.0");
	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		// RestAssured.baseURI = "http://localhost";
		// RestAssured.port = port
	}

	static {
		mySQLContainer.start();
	}

	@Test
	void shouldSubmitOrder() {
		String submitOrderJson = """
				{
					"skuCode": "iphone_15",
					"price": 1000,
					"quantity": 1
				}
				""";
		
		var responseBodyString = RestAssured.given()
				.contentType("application/json")
				.body(submitOrderJson)
				.when()
				.post("/api/order")
				.log().all()
				.statusCode(201)
				.extract()
				.body().asString();
		
		MatcherAssert.assertThat(responseBodyString, Matchers.is("Order Placed Successfully"))
	}

}


//
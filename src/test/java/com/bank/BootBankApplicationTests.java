package com.bank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BootBankApplicationTests {
	
	@Inject
	private TestRestTemplate restTemplate;

	@Test
	public void request_home() {
		String body = restTemplate.getForObject("/", String.class);
		assertThat(body).contains("Banking Products");
	}

	@Test
	public void request_detail() {
		String body = restTemplate.getForObject("/products/1/details", String.class);
		assertThat(body).contains("1.05");
	}
	
	@Test
	public void request_list_as_json_and_convert_to_list() {
		String body = restTemplate.getForObject("/products.json", String.class);
		GsonJsonParser parser = new GsonJsonParser();
		List<Object> products = parser.parseList(body);
		assertThat(products.size()).isEqualTo(4);
	}
	
	@Test
	public void request_product_as_json_and_convert_to_list() {
		String body = restTemplate.getForObject("/products/{id}/details.json", String.class, 1);
		GsonJsonParser parser = new GsonJsonParser();
		List<Object> products = parser.parseList("[" + body + "]");
		assertThat(products.size()).isEqualTo(1);
	}	
}
package com.soon;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
		//value = "value=test",
		properties = {"property.value=propertyTest"},
		classes = {SoonApiApplication.class},
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SoonApiApplicationTests {

	//@Value("${value}")
	//private String value;

	@Value("${property.value}")
	private String propertyValue;

	@Test
	public void contextLoads() {
		//Assert.assertThat(value, Matchers.is("test"));
		Assert.assertThat(propertyValue, Matchers.is("propertyTest"));
	}
}


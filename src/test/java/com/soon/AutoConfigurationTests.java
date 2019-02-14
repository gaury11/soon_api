package com.soon;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoConfigurationTests {

    @Value("${property.test.name}")
    private String propertyTestName;

    @Value("${propertyTest}")
    private String propertyTest;

    @Value("${noKey:default value}")
    private String defaultValue;

    @Value("${propertyTestList}")
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}'.split(',')}")
    private List<String> propertyTestList;

    @Test
    public void testValue(){
        Assert.assertThat(propertyTestName, Matchers.is("property depth test"));
        Assert.assertThat(propertyTest, Matchers.is("test"));
        Assert.assertThat(defaultValue, Matchers.is("default value"));

        Assert.assertThat(propertyTestArray[0], Matchers.is("a"));
        Assert.assertThat(propertyTestList.get(1), Matchers.is("b"));
    }
}

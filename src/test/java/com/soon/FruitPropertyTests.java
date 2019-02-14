package com.soon;

import com.soon.demo.FruitProperty;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FruitPropertyTests {

    @Autowired
    FruitProperty fruitProperty;

    @Test
    public void test(){
        List<Map> fruitData = fruitProperty.getList();

        Assert.assertThat(fruitData.get(0).get("name"), Matchers.is("banana"));
        Assert.assertThat(fruitData.get(0).get("color"), Matchers.is("yellow"));

        Assert.assertThat(fruitData.get(1).get("name"), Matchers.is("apple"));
        Assert.assertThat(fruitData.get(1).get("color"), Matchers.is("red"));

        Assert.assertThat(fruitData.get(2).get("name"), Matchers.is("water melon"));
        Assert.assertThat(fruitData.get(2).get("color"), Matchers.is("green"));
    }
}

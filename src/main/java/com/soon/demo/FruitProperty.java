package com.soon.demo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty {
    // @ConfigurationProperties 사용하려면 해당 클래스를 @Component로 선언해야 함 그래야 의존성 주입이 가능함
    // 접두사가 fruit인 프로퍼티키값을 읽어와서 필드값에 매핑함
    private List<Map> list;
}

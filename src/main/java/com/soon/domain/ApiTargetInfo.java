package com.soon.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;


@Entity
@Table(name="CS_API_TARGET_INFO")
@Getter
@NoArgsConstructor
public class ApiTargetInfo implements Serializable {

    /*
        주의 :
        - Entity 클래스를 생성할 때, 무분별한 Setter 메소드 생성 주의
        - 자바빈 규약상 getter/setter를 무작정 생성하면, 해당 클래스의 인스턴스 값들이 언제 어디서 변해야하는지 코드상으로 명확히 구분할수가 없어, 차후 기능변경시 정말 복잡해짐
        - 해당 필드의 값 변경이 필요하면 명확히 그 목적과 의도를 나타낼 수 있는 메소드를 추가함
        - Setter 메소드 없이 사용방법 = @Builder
     */

    /*
        CREATE TABLE CS_API_TARGET_INFO (
            id bigint(20) NOT NULL AUTO_INCREMENT
            , target_name varchar(50) NOT NULL
            , target_url varchar(50) NOT NULL
            , reg_date datetime NOT NULL
            , PRIMARY KEY (id)
        ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
        ;
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String targetName;

    @Column
    private String targetUrl;

    @Column
    private LocalDateTime regDate;

    @Builder
    public ApiTargetInfo(String targetName, String targetUrl, LocalDateTime regDate){
        this.targetName = targetName;
        this.targetUrl = targetUrl;
        this.regDate = regDate;
    }

    public void setRegDateNow(){
        this.regDate = LocalDateTime.now();
    }

    public void update(ApiTargetInfo apiTargetInfo){
        this.targetName = apiTargetInfo.getTargetName();
        this.targetUrl = apiTargetInfo.getTargetUrl();
    }
}

package com.soon.domain;

import com.soon.domain.enums.TimelineType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "ESC_TIMELINE")
@Getter
@NoArgsConstructor
public class Timeline implements Serializable {

    /*
        CREATE TABLE ESC_TIMELINE (
            ID bigint(20) NOT NULL AUTO_INCREMENT
            , TYPE varchar(10) NOT NULL
            , TITLE varchar(50) NOT NULL
            , CONTENT varchar(50) NOT NULL
            , REG_ID varchar(50)
            , REG_DATE datetime NOT NULL
            , PRIMARY KEY (ID)
        ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8
        ;
    */

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    // Enum 타입 매핑용 어노테이션. 자바 enum형과 데이터베이스 데이터 변환을 지원함 (실제로 자바 enum형이지만 데이터베이스의 String형으로 변환하여 저장하겠다고 선언)
    /*
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private TimelineType timelineType;
    */
    @Column(name = "TYPE")
    private String timelineType;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    /*
    @Column
    @OneToOne(fetch = FetchType.LAZY)
    private
    */

    @Column(name = "REG_ID")
    private String regId;

    // LocalDateTime : 자바8에 추가된 기능 JodaDateTime 의종성을 포함할 필요 없음
    @Column(name = "REG_DATE")
    private LocalDateTime regDate;

    @Builder
    public Timeline(String timelineType, String title, String content,
                String regId, LocalDateTime regDate){
        this.timelineType = timelineType;
        this.title = title;
        this.content = content;
        this.regId = regId;
        this.regDate = regDate;
    }
}

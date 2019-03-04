package com.soon.domain.enums;

import java.awt.print.Pageable;

public enum TimelineType {
    NOTICE("notice"),
    EVENT("event"),
    FREE("free"),
    TEST("test");

    private String value;

    TimelineType(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}

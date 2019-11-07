package com.itn.mapper.model.enums;

import java.util.HashMap;
import java.util.Map;

public enum MappingItemStatus {
    MAPPED("mapped"),
    UNMAPPED("unmapped"),
    OTHER("other");

    private String value;
    private static Map map = new HashMap<>();

    private MappingItemStatus(String value) {
        this.value = value;
    }

    static {
        for (MappingItemStatus pageType : MappingItemStatus.values()) {
            map.put(pageType.value, pageType);
        }
    }

    public String getValue() {
        return value;
    }
}

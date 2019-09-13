package com.itn.mapper.model;

import lombok.Data;

@Data
public class LineItemDefinition {
    private int id;
    private int tenantId;
    private String fieldName;
    private String fieldType;
    private int idx;
    private int size;
    private int statusId;
    private char lineSeparator;
}

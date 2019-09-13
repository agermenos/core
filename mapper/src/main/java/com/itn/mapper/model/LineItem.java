package com.itn.mapper.model;

import lombok.Data;

import java.util.Date;

@Data
public class LineItem {
    private int id;
    private int tenantId;
    private Date datetime;
    private String content;
    private int status;
}

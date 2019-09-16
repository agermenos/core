package com.itn.mapper.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
public class LineItem {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="tentant_id")
    private int tenantId;
    @Column(name="date")
    private Date datetime;
    @Column(name="line_item")
    private String content;
    @Column(name="status")
    private int status;
}

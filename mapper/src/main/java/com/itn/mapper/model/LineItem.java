package com.itn.mapper.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity(name = "line_items")
public class LineItem {
    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column(name="tenant_id")
    private int tenantId;
    @Column(name="date")
    private Date datetime;
    @Column(name="line_item")
    private String content;
    @Column(name="status")
    private int status;
    @Column(name="invoice_id")
    private String invoiceId;
    @PrePersist
    public void preUpdate(){
        if (datetime==null) datetime=new Date();
    }
}

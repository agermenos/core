package com.itn.mapper.model;

import javafx.scene.shape.Line;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
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

    public LineItem(){
        super();
    }

    @Builder
    public LineItem(int tenantId, String content, int status, String invoiceId) {
        this.tenantId = tenantId;
        this.content = content;
        this.status = status;
        this.invoiceId = invoiceId;
    }

    @PrePersist
    public void preUpdate(){
        if (datetime==null) datetime=new Date();
    }
}

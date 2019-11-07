package com.itn.mapper.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="invoiceitems")
@IdClass(InvoiceId.class)
public class InvoiceItems {
    @Id
    @Column(name = "ItemID")
    Integer itemId;
    @Id
    @Column(name="DistributorID")
    Integer distributorId;
    @Column (name = "ManufacturerNo")
    String manufacturerNo;
    @Column(name = "ProductNo")
    String productNo;
    @Column (name = "Description")
    String description;
    @Column (name = "Pack")
    String pack;
    @Column (name = "UnitOfMeasure")
    String unitOfMeasure;
    @Column (name="BrandName")
    String brandName;
}

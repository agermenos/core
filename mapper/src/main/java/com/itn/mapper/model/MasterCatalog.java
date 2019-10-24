package com.itn.mapper.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="mastercatalogs")
public class MasterCatalog {
    @Id
    @GeneratedValue
    @Column(name="MasterID")
    Long masterId;
    @Column(name = "ProductNo")
    String productNo;
    @Column(name = "ProductName")
    String productName;
    @Column(name = "Description")
    String description;
    @Column(name = "DistributorID")
    Integer distributorId;
    @Column(name = "BreakLevel")
    Integer breakLevel;
    @Column(name = "Pack")
    String pack;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CategoryID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Category category;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "BrandID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Brand brand;
    @Column(name = "ManufacturerNo")
    String manufacturerNo;
    @Column(name = "UPC")
    String upc;
    @Column(name = "GTIN")
    String gtin;
    @Column(name = "Modified")
    Date modified;
    @Column(name = "Created")
    Date created;
}

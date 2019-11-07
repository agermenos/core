package com.itn.mapper.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Builder
@Table(name="mastercatalogs")
public class MasterCatalogItem implements Serializable {
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
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DistributorID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Distributor distributor;
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

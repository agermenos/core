package com.itn.mapper.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="brands")
@Builder
public class Brand {
    @Id
    @GeneratedValue
    @Column(name="BrandID")
    Integer brandId;
    @Column(name="BrandName")
    String brandName;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ManufacturerID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Manufacturer manufacturer;
}

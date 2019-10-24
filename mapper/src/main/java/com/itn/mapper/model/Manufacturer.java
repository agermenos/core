package com.itn.mapper.model;

import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="mastercatalogs")
public class Manufacturer {
    @Id
    @Column (name = "ManufacturerID")
    Integer manufacturerId;
    @Column (name = "ManufacturerName")
    String manufacturerName;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DistributorID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Distributor distributor;
}

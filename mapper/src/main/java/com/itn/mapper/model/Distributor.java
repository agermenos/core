package com.itn.mapper.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="distributor")
@Builder
public class Distributor {
    @Id
    @GeneratedValue
    @Column(name="DistributorID")
    Integer distributorId;
    @Column(name="DistributorName")
    String distributorName;
    @Column(name="DistributorCode")
    String distributorCode;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DistributorTypeID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    DistributoryType distributoryType;
}

package com.itn.mapper.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="distributortype")
public class DistributoryType {
    @Id
    @GeneratedValue
    @Column(name="DistributorTypeID")
    Integer distributorTypeId;
    @Column(name="DistributorType")
    String distributorType;
}

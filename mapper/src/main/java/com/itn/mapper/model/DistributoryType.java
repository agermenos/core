package com.itn.mapper.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="distributortype")
@Builder
public class DistributoryType {
    @Id
    @GeneratedValue
    @Column(name="DistributorTypeID")
    Integer distributorTypeId;
    @Column(name="DistributorType")
    String distributorType;
}

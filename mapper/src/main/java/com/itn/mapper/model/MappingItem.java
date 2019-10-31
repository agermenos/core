package com.itn.mapper.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="mappingitems")
@IdClass(MappingItemId.class)
public class MappingItem {
    @Id
    @Column (name="MappingID")
    Integer mappingId;
    @Id
    @Column (name = "DistributorID")
    Integer distributorId;
    @Column (name="ProductNo")
    String productNo;
    @Column (name="Description")
    String description;
    @Column (name="ProductNoRef")
    String productNoRef;
    @Column (name="DescriptionRef")
    String descriptionRef;
    @Column (name = "Status")
    String status;
}

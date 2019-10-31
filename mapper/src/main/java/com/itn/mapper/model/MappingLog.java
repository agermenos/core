package com.itn.mapper.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="mappinglog")
public class MappingLog {
    @Id
    @Column(name="MappingLogID")
    Integer mappingLogId;
    
}

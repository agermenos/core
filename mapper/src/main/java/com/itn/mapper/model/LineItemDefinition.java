package com.itn.mapper.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity (name = "line_item_definition")
public class LineItemDefinition {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    @Column(name="tenant_id")
    private Integer tenantId;
    @Column(name="field_name")
    private String fieldName;
    @Column(name="field_type_id")
    private String fieldType;
    @Column(name="idx")
    private int idx;
    @Column(name="size")
    private Integer size;
}

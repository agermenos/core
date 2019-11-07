package com.itn.mapper.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Data
@Entity
@Table(name="category")
@Builder
public class Category {
    @Id
    @Column(name="CategoryID")
    @GeneratedValue
    String categoryId;
    @Column(name="CategoryName")
    String categoryName;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ParentID", referencedColumnName = "CategoryID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    Category parent;
}

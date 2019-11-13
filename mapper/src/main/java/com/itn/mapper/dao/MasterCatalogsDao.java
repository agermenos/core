package com.itn.mapper.dao;

import com.itn.mapper.model.MasterCatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MasterCatalogsDao extends JpaRepository<MasterCatalogItem, Long> {
}

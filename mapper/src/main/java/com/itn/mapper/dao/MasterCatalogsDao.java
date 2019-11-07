package com.itn.mapper.dao;

import com.itn.mapper.model.MasterCatalogItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterCatalogsDao extends JpaRepository<MasterCatalogItem, Long> {
    List<MasterCatalogItem> saveAll(List<MasterCatalogItem> items);
}

package com.itn.mapper.dao;

import com.itn.mapper.model.MappingItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MappingItemsDao extends JpaRepository<MappingItem, Long> {
}

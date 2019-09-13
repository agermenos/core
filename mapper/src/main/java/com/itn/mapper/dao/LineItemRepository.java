package com.itn.mapper.dao;

import com.itn.mapper.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LineItemRepository extends JpaRepository<LineItem, Integer> {
    List<LineItem> findAllByTenantIdAndDatetimeAndStatus(Integer tenantId, Date date, Integer status);
}

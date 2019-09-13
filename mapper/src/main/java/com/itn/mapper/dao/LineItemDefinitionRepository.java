package com.itn.mapper.dao;

import com.itn.mapper.model.LineItemDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineItemDefinitionRepository extends JpaRepository<LineItemDefinition, Integer> {
   List<LineItemDefinition> findAllByTenantIdAAndStatusIdOrderByIdx(Integer tenantId, Integer statusId);
}

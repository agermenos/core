package com.itn.mapper.dao;

import com.itn.mapper.model.LineItemDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineItemDefinitionRepository extends JpaRepository<LineItemDefinition, Integer> {
   List<LineItemDefinition> findAllByTenantIdOrderByIdx(Integer tenantId);
}

package com.itn.mapper.dao;

import com.itn.mapper.model.MasterCatalog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MasterCatalogsDao extends JpaRepository<MasterCatalog, Long> {

}

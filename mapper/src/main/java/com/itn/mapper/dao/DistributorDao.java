package com.itn.mapper.dao;

import com.itn.mapper.model.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributorDao extends JpaRepository<Distributor, Long> {
}

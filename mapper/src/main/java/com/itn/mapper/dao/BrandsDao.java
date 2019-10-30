package com.itn.mapper.dao;

import com.itn.mapper.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandsDao  extends JpaRepository<Brand, Long> {
}

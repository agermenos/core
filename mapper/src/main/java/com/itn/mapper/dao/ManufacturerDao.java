package com.itn.mapper.dao;

import com.itn.mapper.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerDao  extends JpaRepository<Manufacturer, Long> {
}

package com.itn.mapper.dao;

import com.itn.mapper.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao  extends JpaRepository<Category, Long> {
}

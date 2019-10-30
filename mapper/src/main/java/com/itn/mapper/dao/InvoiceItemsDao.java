package com.itn.mapper.dao;

import com.itn.mapper.model.InvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceItemsDao extends JpaRepository<InvoiceItems, Long> {
}

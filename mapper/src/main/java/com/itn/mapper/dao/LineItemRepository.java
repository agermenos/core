package com.itn.mapper.dao;

import com.itn.mapper.model.LineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LineItemRepository extends JpaRepository<LineItem, Integer> {
    List<LineItem> findAllByInvoiceId(String invoiceId);
}

package com.itn.mapper.service;

import com.itn.mapper.dao.InvoiceItemsDao;
import com.itn.mapper.model.InvoiceItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("invoiceItemsService")
public class InvoiceItemsService {
    @Autowired
    InvoiceItemsDao invoiceItemsDao;

    public List<InvoiceItems> addInvoiceItems(List<InvoiceItems> invoiceItems) {
        invoiceItemsDao.saveAll(invoiceItems);
        return invoiceItems;
    }

    public InvoiceItems updateInvoiceItem(InvoiceItems invoiceItems){
        invoiceItemsDao.save(invoiceItems);
        return invoiceItems;
    }

    public List<InvoiceItems> getInvoiceItems(Date date){
         //TODO: Implement once DB has invoice date
        return null;
    }

    public void deleteInvoiceItems(InvoiceItems invoiceItems) {
        invoiceItemsDao.delete(invoiceItems);
    }
}

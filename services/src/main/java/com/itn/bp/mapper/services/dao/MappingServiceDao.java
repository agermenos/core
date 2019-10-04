package com.itn.bp.mapper.services.dao;

import com.itn.bp.mapper.services.model.InvoiceItem;
import com.itn.bp.mssqlutility.dao.MsSqlUtilityBaseDao;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class MappingServiceDao extends MsSqlUtilityBaseDao {
    public InvoiceItem getInvoiceItems(Date startDate, Date endDate, int tenantId){
        return new InvoiceItem();
    }
}

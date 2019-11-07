package com.itn.mapper.service;

import com.itn.mapper.dao.MappingItemsDao;
import com.itn.mapper.model.InvoiceItems;
import com.itn.mapper.model.MappingItem;
import com.itn.mapper.model.enums.MappingItemStatus;
import com.itn.mapper.model.MasterCatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mappingItemsService")
public class MappingItemsService {
    @Autowired
    MappingItemsDao mappingItemsDao;

    public void mapItem(InvoiceItems item, MasterCatalogItem mcItem){
        MappingItem mappingItem = MappingItem.builder()
                .productNo(item.getProductNo())
                .distributorId(item.getDistributorId())
                .description(item.getDescription())
                .productNoRef(mcItem.getProductNo())
                .descriptionRef(mcItem.getDescription())
                .status(MappingItemStatus.MAPPED.getValue())
                .build();
        mappingItemsDao.save(mappingItem);
    }

    public void mapItem(InvoiceItems item){
        MappingItem mappingItem = MappingItem.builder()
                .productNo(item.getProductNo())
                .distributorId(item.getDistributorId())
                .description(item.getDescription())
                .productNoRef(null)
                .descriptionRef(null)
                .build();
        mappingItemsDao.save(mappingItem);
    }


}

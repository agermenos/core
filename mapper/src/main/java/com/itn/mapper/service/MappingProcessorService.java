package com.itn.mapper.service;

import com.itn.mapper.model.InvoiceItems;
import com.itn.mapper.model.MasterCatalogItem;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service("mappingProcessorService")
public class MappingProcessorService {
    final MasterCatalogService masterCatalogService;
    final InvoiceItemsService invoiceItemsService;

    public MappingProcessorService(MasterCatalogService masterCatalogService, InvoiceItemsService invoiceItemsService) {
        this.masterCatalogService = masterCatalogService;
        this.invoiceItemsService = invoiceItemsService;
    }

    public void processMappings(Set<InvoiceItems> items){
        items.forEach(item -> {
            if (!searchItem(item).isPresent()) {

            }
        });
    }

    private Optional<MasterCatalogItem> searchItem(InvoiceItems item) {
        return null;
    }
}

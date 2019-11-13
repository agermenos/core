package com.itn.mapper.service;

import com.itn.mapper.dao.MasterCatalogsDao;
import com.itn.mapper.model.MasterCatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("mapperCatalogService")
public class MasterCatalogService {
    @Autowired
    MasterCatalogsDao masterCatalogsDao;

    public List<MasterCatalogItem> addProducts(List<MasterCatalogItem> items) {
        items.forEach(item -> masterCatalogsDao.save(item));
        return items;
    }

    public MasterCatalogItem addProduct(MasterCatalogItem item) {
        return masterCatalogsDao.save(item);
    }

    public MasterCatalogItem updateProduct(MasterCatalogItem item) {
        return masterCatalogsDao.save(item);
    }

    public void deleteProduct(MasterCatalogItem item) {
        masterCatalogsDao.delete(item);
    }
}

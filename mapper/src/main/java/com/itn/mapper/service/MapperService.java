package com.itn.mapper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("mapperService")
public class MapperService {
    @Autowired
    private InvoiceService invoiceService;



}

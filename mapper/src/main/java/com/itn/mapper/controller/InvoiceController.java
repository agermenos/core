package com.itn.mapper.controller;

import com.itn.mapper.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/mapper/invoice")
public class InvoiceController {
    @Autowired
    InvoiceService invoiceService;
//    @Autowired
//    private BPSecurity bpSecurity;

    @GetMapping(value = "/{tenantId}/{invoiceId}")
    public ResponseEntity<Object> getInvoices(@PathVariable("tenantId") Integer tenantId, @PathVariable("invoiceId") String invoiceId){
        List<Map<String, String>> returnValues=invoiceService.getInvoiceByInvoiceId(tenantId, invoiceId);
        return new ResponseEntity<>(returnValues, HttpStatus.OK);
    }
}

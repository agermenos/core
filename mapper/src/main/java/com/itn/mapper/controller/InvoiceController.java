package com.itn.mapper.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/mapper/invoice")
public class InvoiceController {
//    @Autowired
//    private BPSecurity bpSecurity;

    @GetMapping(value = "/{tenantId}/{invoiceId}")
    public ResponseEntity<Object> getInvoices(@PathVariable("tenantId") Integer tenantId, @PathVariable("invoiceId") String invoiceId){
        return null;
    }
}

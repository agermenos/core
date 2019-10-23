package com.itn.bp.mapper.services.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapper/invoice")
public class MappingServiceController {
    @GetMapping(value = "/{tenantId}/{invoiceId}")
    public ResponseEntity<Object> getInvoices(@PathVariable("tenantId") Integer tenantId,
                                              @PathVariable("invoiceId") String invoiceId){
       return null;
    }
}

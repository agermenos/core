package com.itn.mapper.service;

import com.itn.mapper.dao.LineItemDefinitionRepository;
import com.itn.mapper.dao.LineItemRepository;
import com.itn.mapper.model.LineItem;
import com.itn.mapper.model.LineItemDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.stream.Collectors;

@Service("invoiceService")
public class InvoiceService {

    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    LineItemDefinitionRepository lineItemDefinitionRepository;

    public List<Map<String, String>> getInvoiceByInvoiceId(int tenantId, String invoiceId) {
        List<LineItemDefinition> lineItemDefinitions = lineItemDefinitionRepository.findAllByTenantIdOrderByIdx(tenantId);
        List<LineItem> lineItems = lineItemRepository.findAllByInvoiceId(invoiceId);
        return lineItems.parallelStream().map(lineItem -> {
            String[] strLineItems = lineItem.getContent().split("\\|");
            Map<String, String> jsonMap = new HashMap<>();
            int index =0;
            for (String field:strLineItems) {
                if (index<lineItemDefinitions.size()) {
                    LineItemDefinition definition = lineItemDefinitions.get(index++);
                    jsonMap.put(definition.getFieldName(), field);
                }
                else break;
            }
            return jsonMap;
        }).collect(Collectors.toList());
    }
}

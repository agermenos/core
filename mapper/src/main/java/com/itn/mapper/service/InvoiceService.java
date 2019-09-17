package com.itn.mapper.service;

import com.itn.mapper.dao.LineItemDefinitionRepository;
import com.itn.mapper.dao.LineItemRepository;
import com.itn.mapper.model.LineItem;
import com.itn.mapper.model.LineItemDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.json.JSONObject;
import java.util.*;
import java.util.stream.Collectors;

@Service("invoiceService")
public class InvoiceService {

    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    LineItemDefinitionRepository lineItemDefinitionRepository;

    public List<JSONObject> getInvoiceByInvoiceId(int tenantId, String invoiceId) {
        List<LineItemDefinition> lineItemDefinitions = lineItemDefinitionRepository.findAllByTenantIdOrderByIdx(tenantId);
        List<LineItem> lineItems = lineItemRepository.findAllByInvoiceId(invoiceId);
        return lineItems.parallelStream().map(lineItem -> {
            String[] strLineItems = lineItem.getContent().split("\\|");
            Map<String, String> jsonMap = new HashMap<>();
            int index =0;
            for (String field:strLineItems) {
                LineItemDefinition definition = lineItemDefinitions.get(index++);
                jsonMap.put(definition.getFieldName(), field);
            }
            return new JSONObject(jsonMap);
        }).collect(Collectors.toList());
    }
}

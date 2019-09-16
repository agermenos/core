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

    private static final Integer STATUS_LIVE = 1;
    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    LineItemDefinitionRepository lineItemDefinitionRepository;

    public List<JSONObject> getInvoiceByTenantAndDate(Integer tenantId, Date date) {
        List<LineItemDefinition> lineItemDefinitions = lineItemDefinitionRepository.findAllByTenantIdAAndStatusIdOrderByIdx(tenantId, STATUS_LIVE);
        List<LineItem> lineItems = lineItemRepository.findAllByTenantIdAndDatetimeAndStatus(tenantId, date, STATUS_LIVE);
        return lineItems.parallelStream().map(lineItem -> {
            String strLineItem = lineItem.getContent();
            Map<String, String> jsonMap = new HashMap<>();
            lineItemDefinitions.forEach(definition ->
                jsonMap.put(definition.getFieldName(), strLineItem.substring(definition.getSize())));
            JSONObject returnObject = new JSONObject(jsonMap);
            return returnObject;
        }).collect(Collectors.toList());
    }
}

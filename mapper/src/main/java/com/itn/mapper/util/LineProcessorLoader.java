package com.itn.mapper.util;

import com.itn.mapper.dao.LineItemDefinitionRepository;
import com.itn.mapper.dao.LineItemRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class LineProcessorLoader {
    @Autowired
    LineItemRepository lineItemRepository;
    @Autowired
    LineItemDefinitionRepository lineItemDefinitionRepository;
}

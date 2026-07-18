package com.service;

import com.domain.Rule;
import com.dto.RuleDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RuleService {

    @Transactional
    public void createRule(RuleDTO ruleDTO) {
        Rule rule = new Rule(ruleDTO.name, ruleDTO.description);
        rule.persist();
    }
}

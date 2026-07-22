package com.service;

import com.domain.Rule;
import com.dto.RuleDTO;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class RuleService {

    @Transactional
    public Rule createRule(String name, String description) {
        Rule rule = new Rule(name, description);
        rule.persist();
        return rule;
    }

    @Transactional
    public void deleteRule(Long id) {
        Rule.deleteById(id);
    }

    @Transactional
    public void updateRule(Long id, RuleDTO ruleDTO) {
        Rule rule = Rule.findById(id);
        rule.setName(ruleDTO.getText());
        rule.setDescription(ruleDTO.getDescription());
        rule.persist();
    }
}

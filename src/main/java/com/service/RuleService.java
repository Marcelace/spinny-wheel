package com.service;

import com.domain.Rule;
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
}

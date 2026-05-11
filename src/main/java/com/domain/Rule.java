package com.domain;

public class Rule {
    public String name;
    public String description;

    public Rule(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

package com.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Rule extends PanacheEntity {
    private String name;
    private String description;

    public Rule(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Rule() {
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

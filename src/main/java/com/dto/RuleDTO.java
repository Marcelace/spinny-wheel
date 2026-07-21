package com.dto;

public class RuleDTO {
    public Long id;
    public String text;
    public String description;

    public RuleDTO(Long id, String text, String description) {
        this.id = id;
        this.text = text;
        this.description = description;
    }
}

package com.dto;

public class RuleDTO {
    private Long id;
    private String text;
    private String description;

    public RuleDTO(Long id, String text, String description) {
        this.id = id;
        this.text = text;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getDescription() {
        return description;
    }
}

package ru.egartech.workplace.dto;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WidgetDTO {
    private Long id;
    private String code;
    private String name;
    private String component;
}

package ru.egartech.workplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class TemplateDTO {
        private Long id;
        private String code;
        private String name;
        private String component;
}

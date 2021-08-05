package ru.egartech.workplace.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TemplateDTO {
        private Long id;
        private String code;
        private String name;
        private String component;
}

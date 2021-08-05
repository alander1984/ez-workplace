package ru.egartech.workplace.converter;

import ru.egartech.workplace.domain.Template;
import ru.egartech.workplace.dto.TemplateDTO;

public class TemplateConverter {

    public static TemplateDTO toDTO(Template t) {
        return TemplateDTO.builder()
                .id(t.getId())
                .code(t.getCode())
                .name(t.getName())
                .component(t.getComponent())
                .build();
    }

    public static Template toDomain(TemplateDTO t) {
        return Template.builder()
                .id(t.getId())
                .code(t.getCode())
                .name(t.getName())
                .component(t.getComponent())
                .build();
    }


}

package ru.egartech.workplace.converter;

import ru.egartech.workplace.domain.WidgetProperty;
import ru.egartech.workplace.dto.WidgetPropertyDTO;

public class WidgetPropertyConverter {

    public static WidgetPropertyDTO toDTO(WidgetProperty w) {
        return WidgetPropertyDTO.builder()
                .id(w.getId())
                .param(w.getParam())
                .name(w.getName())
                .widgetId(w.getWidgetId())
                .build();
    }

    public static WidgetProperty toDomain(WidgetPropertyDTO w) {
        return WidgetProperty.builder()
                .id(w.getId())
                .param(w.getParam())
                .name(w.getName())
                .widgetId(w.getWidgetId())
                .build();
    }

}

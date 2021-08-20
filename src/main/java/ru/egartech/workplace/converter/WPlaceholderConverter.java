package ru.egartech.workplace.converter;

import ru.egartech.workplace.domain.WPlaceholder;
import ru.egartech.workplace.dto.WPlaceholderDTO;

public class WPlaceholderConverter {

    public static WPlaceholderDTO toDTO(WPlaceholder w) {
        return WPlaceholderDTO.builder()
                .id(w.getId())
                .workspaceId(w.getWorkspaceId())
                .widgetId(w.getWidgetId())
                .code(w.getCode())
                .build();
    }

    public static WPlaceholder toDomain(WPlaceholderDTO w) {
        return WPlaceholder.builder()
                .id(w.getId())
                .workspaceId(w.getWorkspaceId())
                .widgetId(w.getWidgetId())
                .code(w.getCode())
                .build();
    }

}

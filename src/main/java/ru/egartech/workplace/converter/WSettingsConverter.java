package ru.egartech.workplace.converter;

import ru.egartech.workplace.domain.WSettings;
import ru.egartech.workplace.dto.WSettingsDTO;

public class WSettingsConverter {

    public static WSettingsDTO toDTO(WSettings w) {
        return WSettingsDTO.builder()
                .id(w.getId())
                .wPlaceholderId(w.getWPlaceholderId())
                .propertyId(w.getPropertyId())
                .value(w.getValue())
                .build();
    }

    public static WSettings toDomain(WSettingsDTO w) {
        return WSettings.builder()
                .id(w.getId())
                .wPlaceholderId(w.getWPlaceholderId())
                .propertyId(w.getPropertyId())
                .value(w.getValue())
                .build();
    }

}

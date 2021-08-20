package ru.egartech.workplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WSettingsDTO {

    private long id;
    private long wPlaceholderId;
    private long propertyId;
    private String value;

}

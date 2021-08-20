package ru.egartech.workplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WPlaceholderDTO {

    private long id;
    private long workspaceId;
    private long widgetId;
    private String code;

}

package ru.egartech.workplace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class WidgetPropertyDTO {

    private Long id;
    private String param;
    private String name;
    private long widgetId;

}

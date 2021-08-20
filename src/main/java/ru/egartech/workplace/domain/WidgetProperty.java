package ru.egartech.workplace.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(value="WIDGET_PROPERTIES")
public class WidgetProperty {

    @Id
    private Long id;
    @Column("PARAM")
    private String param;
    @Column("NAME")
    private String name;
    @Column("WIDGET_ID")
    private long widgetId;

}

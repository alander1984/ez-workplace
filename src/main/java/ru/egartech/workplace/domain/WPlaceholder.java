package ru.egartech.workplace.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(value="WPLACEHOLDERS")
public class WPlaceholder {

    @Id
    private long id;
    @Column("WORKSPACE_ID")
    private long workspaceId;
    @Column("WIDGET_ID")
    private long widgetId;
    @Column("CODE")
    private String code;

}

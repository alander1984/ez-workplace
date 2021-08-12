package ru.egartech.workplace.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(value="WORKSPACES")
public class Workspace {

    @Id
    private long id;
    @Column("NAME")
    private String name;
    @Column("TEMPLATE_ID")
    private long templateId;

}

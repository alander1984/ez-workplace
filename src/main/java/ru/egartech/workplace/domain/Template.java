package ru.egartech.workplace.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(value = "TEMPLATES")
public class Template {

    @Id
    private Long id;
    @Column("CODE")
    private String code;
    @Column("NAME")
    private String name;
    @Column("COMPONENT")
    private String component;

}

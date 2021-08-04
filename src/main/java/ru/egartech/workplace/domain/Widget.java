package ru.egartech.workplace.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table(value="WIDGETS")
public class Widget {

    @Id
    private Long id;
    @Column("CODE")
    private String code;
    @Column("NAME")
    private String name;
    @Column("COMPONENT")
    private String component;
}

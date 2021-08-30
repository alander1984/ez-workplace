package ru.egartech.workplace.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(value = "TEMPLATE_PLACEHOLDERS")
public class TemplatePlaceholder {

    @Id
    private Long id;
    @Column("TEMPLATE_ID")
    private long template_id;
    @Column("CODE")
    private String code;

}

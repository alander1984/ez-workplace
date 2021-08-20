package ru.egartech.workplace.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(value="WSETTINGS")
public class WSettings {

    @Id
    private long id;
    @Column("WPLACEHOLDER_ID")
    private long wPlaceholderId;
    @Column("PROPERTY_ID")
    private long propertyId;
    @Column("VALUE")
    private String value;

}

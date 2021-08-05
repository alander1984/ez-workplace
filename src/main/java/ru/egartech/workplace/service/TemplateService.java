package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.dto.TemplateDTO;

public interface TemplateService {

    Page<TemplateDTO> getAll(Pageable page);
    TemplateDTO getById(long id);
    void save(TemplateDTO t);
    void delete(TemplateDTO t);
    void update(TemplateDTO t);

}

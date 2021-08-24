package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.dto.TemplateDTO;

import java.util.Optional;

public interface TemplateService {

    Page<TemplateDTO> getAll(Pageable page);
    Optional<TemplateDTO> getById(long id);
    TemplateDTO save(TemplateDTO t);
    void delete(long id);
    void update(TemplateDTO t);

}

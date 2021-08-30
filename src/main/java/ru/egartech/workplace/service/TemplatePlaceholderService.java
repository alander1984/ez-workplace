package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.domain.TemplatePlaceholder;

import java.util.List;

public interface TemplatePlaceholderService {

    public Page<TemplatePlaceholder> getAll(Pageable page);
    public TemplatePlaceholder[] getByTemplateId(long id);

}

package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.domain.TemplatePlaceholder;
import ru.egartech.workplace.repo.TemplatePlaceholderRepository;

import java.util.List;

@Service
public class TemplatePlaceholderServiceImpl implements TemplatePlaceholderService {

    private final TemplatePlaceholderRepository templatePlaceholderRepository;

    TemplatePlaceholderServiceImpl (TemplatePlaceholderRepository templatePlaceholderRepository) { this.templatePlaceholderRepository = templatePlaceholderRepository; }

    @Override
    public Page<TemplatePlaceholder> getAll(Pageable page) {
        return templatePlaceholderRepository.findAll(page);
    }

    @Override
    public TemplatePlaceholder[] getByTemplateId(long id) {
        Pageable paging = PageRequest.of(0,10);
        return getAll(paging).stream().filter(e -> e.getTemplate_id() == id).toArray(TemplatePlaceholder[]::new);
    }
}

package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.TemplateConverter;
import ru.egartech.workplace.dto.TemplateDTO;
import ru.egartech.workplace.repo.TemplateRepository;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    TemplateServiceImpl(TemplateRepository templateRepository) { this.templateRepository = templateRepository; }

    @Override
    public Page<TemplateDTO> getAll(Pageable page) {
        return templateRepository.findAll(page).map(TemplateConverter::toDTO);
    }

    @Override
    public TemplateDTO getById(long id) {
        return TemplateConverter.toDTO(templateRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public void save(TemplateDTO t) {
        if (t != null)
            templateRepository.save(TemplateConverter.toDomain(t));
    }

    @Override
    public void delete(TemplateDTO t) {
        templateRepository.delete(TemplateConverter.toDomain(t));
    }

    @Override
    public void update(TemplateDTO t) {
        TemplateDTO template = getById(t.getId());

        template.setCode(t.getCode());
        template.setName(t.getName());
        template.setComponent(t.getComponent());
    }

}

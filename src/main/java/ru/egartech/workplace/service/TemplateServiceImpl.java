package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.TemplateConverter;
import ru.egartech.workplace.dto.TemplateDTO;
import ru.egartech.workplace.repo.TemplateRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class TemplateServiceImpl implements TemplateService {

    private final TemplateRepository templateRepository;

    TemplateServiceImpl(TemplateRepository templateRepository) { this.templateRepository = templateRepository; }

    @Override
    public Page<TemplateDTO> getAll(Pageable page) {
        return templateRepository.findAll(page).map(TemplateConverter::toDTO);
    }

    @Override
    public Optional<TemplateDTO> getById(long id) {
            return Optional.of(TemplateConverter.toDTO(templateRepository.findById(id)
                    .orElseThrow(EntityNotFoundException::new)));
    }

    @Override
    public void save(TemplateDTO t) {
        if (t != null) {
            templateRepository.save(TemplateConverter.toDomain(t));
        }
    }

    @Override
    public void delete(long id) {
        templateRepository.deleteById(id);
    }

    @Override
    public void update(TemplateDTO t) {
        if (getById(t.getId()).isPresent()) {
            TemplateDTO template = getById(t.getId()).get();
            template.setCode(t.getCode());
            template.setName(t.getName());
            template.setComponent(t.getComponent());
            save(template);
        }
    }

}

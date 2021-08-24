package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.WidgetPropertyConverter;
import ru.egartech.workplace.dto.WidgetPropertyDTO;
import ru.egartech.workplace.repo.WidgetPropertyRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class WidgetPropertyServiceImpl implements WidgetPropertyService{

    private final WidgetPropertyRepository widgetPropertyRepository;

    WidgetPropertyServiceImpl (WidgetPropertyRepository widgetPropertyRepository) { this.widgetPropertyRepository = widgetPropertyRepository; }

    @Override
    public Page<WidgetPropertyDTO> getAll(Pageable page) {
        return widgetPropertyRepository.findAll(page).map(WidgetPropertyConverter::toDTO);
    }

    @Override
    public Optional<WidgetPropertyDTO> getById(long id) {
        return Optional.of(WidgetPropertyConverter.toDTO(widgetPropertyRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new)));
    }

    @Override
    public void delete(long id) {
        widgetPropertyRepository.deleteById(id);
    }

    @Override
    public WidgetPropertyDTO save(WidgetPropertyDTO w) {
        if (w != null) {
            WidgetPropertyConverter.toDTO(widgetPropertyRepository.save(WidgetPropertyConverter.toDomain(w)));
        }
        return null;
    }

    @Override
    public void update(WidgetPropertyDTO w) {
        if (getById(w.getId()).isPresent()) {
            WidgetPropertyDTO property = getById(w.getId()).get();
            property.setParam(w.getParam());
            property.setName(w.getName());
            property.setWidgetId(w.getWidgetId());
            save(property);
        }
    }
}

package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.WSettingsConverter;
import ru.egartech.workplace.dto.WSettingsDTO;
import ru.egartech.workplace.repo.WSettingsRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class WSettingsServiceImpl implements WSettingsService{

    private final WSettingsRepository wSettingsRepository;

    WSettingsServiceImpl (WSettingsRepository wSettingsRepository) { this.wSettingsRepository = wSettingsRepository; }

    @Override
    public Page<WSettingsDTO> getAll(Pageable page) {
        return wSettingsRepository.findAll(page).map(WSettingsConverter::toDTO);
    }

    @Override
    public Optional<WSettingsDTO> getById(long id) {
        return Optional.of(WSettingsConverter.toDTO(wSettingsRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new)));
    }

    @Override
    public void delete(long id) {
        wSettingsRepository.deleteById(id);
    }

    @Override
    public void save(WSettingsDTO w) {
        if (w != null) {
            wSettingsRepository.save(WSettingsConverter.toDomain(w));
        }
    }

    @Override
    public void update(WSettingsDTO w) {
        if (getById(w.getId()).isPresent()) {
            WSettingsDTO settings = getById(w.getId()).get();
            settings.setPropertyId(w.getPropertyId());
            settings.setPropertyId(w.getPropertyId());
            settings.setValue(w.getValue());
            save(settings);
        }
    }

}

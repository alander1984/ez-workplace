package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.WPlaceholderConverter;
import ru.egartech.workplace.dto.WPlaceholderDTO;
import ru.egartech.workplace.repo.WPlaceholderRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class WPlaceholderServiceImpl implements WPlaceholderService {

    private final WPlaceholderRepository wPlaceholderRepository;

    WPlaceholderServiceImpl (WPlaceholderRepository wPlaceholderRepository) { this.wPlaceholderRepository = wPlaceholderRepository; }

    @Override
    public Page<WPlaceholderDTO> getAll(Pageable page) {
        return wPlaceholderRepository.findAll(page).map(WPlaceholderConverter::toDTO);
    }

    @Override
    public Optional<WPlaceholderDTO> getById(long id) {
        return Optional.of(WPlaceholderConverter.toDTO(wPlaceholderRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new)));
    }

    @Override
    public void delete(long id) {
        wPlaceholderRepository.deleteById(id);
    }

    @Override
    public void save(WPlaceholderDTO w) {
        if (w != null) {
            wPlaceholderRepository.save(WPlaceholderConverter.toDomain(w));
        }
    }

    @Override
    public void update(WPlaceholderDTO w) {
        if (getById(w.getId()).isPresent()) {
            WPlaceholderDTO wplaceholder = getById(w.getId()).get();
            wplaceholder.setWorkspaceId(w.getWorkspaceId());
            wplaceholder.setWidgetId(w.getWidgetId());
            wplaceholder.setCode(w.getCode());
            save(wplaceholder);
        }
    }
}

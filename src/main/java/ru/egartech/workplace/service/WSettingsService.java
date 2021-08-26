package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.dto.WSettingsDTO;

import java.util.Optional;

public interface WSettingsService {

    Page<WSettingsDTO> getAll(Pageable page);
    Optional<WSettingsDTO> getById(long id);
    WSettingsDTO save(WSettingsDTO w);
    void delete(long id);
    WSettingsDTO update(WSettingsDTO w);

}

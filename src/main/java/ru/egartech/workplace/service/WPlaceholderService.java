package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.dto.WPlaceholderDTO;

import java.util.Optional;

public interface WPlaceholderService {

    Page<WPlaceholderDTO> getAll(Pageable page);
    Optional<WPlaceholderDTO> getById(long id);
    WPlaceholderDTO save(WPlaceholderDTO w);
    void delete(long id);
    WPlaceholderDTO update(WPlaceholderDTO w);

}

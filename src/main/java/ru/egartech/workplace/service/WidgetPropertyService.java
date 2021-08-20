package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.dto.WidgetPropertyDTO;

import java.util.Optional;

public interface WidgetPropertyService {

    Page<WidgetPropertyDTO> getAll(Pageable page);
    Optional<WidgetPropertyDTO> getById(long id);
    void save(WidgetPropertyDTO w);
    void delete(long id);
    void update(WidgetPropertyDTO w);

}

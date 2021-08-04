package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ru.egartech.workplace.dto.WidgetDTO;

public interface WidgetService {
	Page<WidgetDTO> getAll(Pageable page);

}

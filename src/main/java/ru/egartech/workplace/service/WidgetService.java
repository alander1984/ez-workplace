package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.dto.WidgetDTO;

import java.util.Optional;

public interface WidgetService {

	Page<WidgetDTO> getAll(Pageable page);
	Optional<WidgetDTO> getById(long id);
	WidgetDTO save(WidgetDTO w);
	void delete(long id);
	void update(WidgetDTO w);

}

package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.WidgetConverter;
import ru.egartech.workplace.dto.WidgetDTO;
import ru.egartech.workplace.repo.WidgetRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class WidgetServiceImpl implements WidgetService {

	private final WidgetRepository widgetRepository;
	
	WidgetServiceImpl(WidgetRepository widgetRepository) {
		this.widgetRepository = widgetRepository;
	}
	
	@Override
	public Page<WidgetDTO> getAll(Pageable page) {
		return widgetRepository.findAll(page).map(WidgetConverter::toDTO);
	}

	@Override
	public Optional<WidgetDTO> getById(long id) {
		return Optional.of(WidgetConverter.toDTO(widgetRepository.findById(id)
				.orElseThrow(EntityNotFoundException::new)));
	}

	@Override
	public void delete(long id) {
		widgetRepository.deleteById(id);
	}

	@Override
	public WidgetDTO save(WidgetDTO w) {
		if (w != null) {
			WidgetConverter.toDTO(widgetRepository.save(WidgetConverter.toDomain(w)));
		}
		return null;
	}

	@Override
	public void update(WidgetDTO w) {
		if (getById(w.getId()).isPresent()) {
			WidgetDTO widget = getById(w.getId()).get();
			widget.setCode(w.getCode());
			widget.setName(w.getName());
			widget.setComponent(w.getComponent());
			save(widget);
		}
	}

}

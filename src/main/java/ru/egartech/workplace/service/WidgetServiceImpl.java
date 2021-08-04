package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ru.egartech.workplace.converter.WidgetConverter;
import ru.egartech.workplace.dto.WidgetDTO;
import ru.egartech.workplace.repo.WidgetRepository;

@Service
public class WidgetServiceImpl implements WidgetService {

	private final WidgetRepository widgetRepostory;
	
	WidgetServiceImpl(WidgetRepository widgetRepostory) {
		this.widgetRepostory = widgetRepostory;
	}
	
	@Override
	public Page<WidgetDTO> getAll(Pageable page) {
		return widgetRepostory.findAll(page).map(WidgetConverter::toDTO);
	}

}

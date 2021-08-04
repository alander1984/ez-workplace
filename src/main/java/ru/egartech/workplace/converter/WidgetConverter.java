package ru.egartech.workplace.converter;

import ru.egartech.workplace.domain.Widget;
import ru.egartech.workplace.dto.WidgetDTO;

public class WidgetConverter {
	
	public static WidgetDTO toDTO(Widget w) {
		return WidgetDTO.builder()
				.id(w.getId())
				.code(w.getCode())
				.name(w.getName())
				.component(w.getComponent())
				.build();
	}
	
	public static Widget toDomain(WidgetDTO w) {
		return Widget.builder()
				.id(w.getId())
				.code(w.getCode())
				.name(w.getName())
				.component(w.getComponent())
				.build();		
	}

}

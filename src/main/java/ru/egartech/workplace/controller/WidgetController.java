package ru.egartech.workplace.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.egartech.workplace.dto.WidgetDTO;
import ru.egartech.workplace.service.WidgetService;

@RequestMapping("/widget")
@Controller
public class WidgetController {
	
	private final WidgetService widgetService;
	
	WidgetController(WidgetService widgetService) {
		this.widgetService=widgetService;
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<WidgetDTO>> getAll(
    		@RequestParam(value = "size", defaultValue = "100") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {
		 Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(widgetService.getAll(paging));
    }
}

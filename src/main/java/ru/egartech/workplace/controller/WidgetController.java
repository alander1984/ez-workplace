package ru.egartech.workplace.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.egartech.workplace.dto.WidgetDTO;
import ru.egartech.workplace.service.WidgetService;

@RequestMapping(value = "/widget", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class WidgetController {
	
	private final WidgetService widgetService;
	
	WidgetController(WidgetService widgetService) {
		this.widgetService=widgetService;
	}
	
	@GetMapping
    public ResponseEntity<Page<WidgetDTO>> getAll(
    		@RequestParam(value = "size", defaultValue = "100") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {
		 Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(widgetService.getAll(paging));
    }

	@GetMapping("/{id}")
	public ResponseEntity<WidgetDTO> getById (@PathVariable long id) {
		return ResponseEntity.ok(widgetService.getById(id).get());
	}

	@PostMapping
	public ResponseEntity<WidgetDTO> save(@RequestBody WidgetDTO w) {
		return ResponseEntity.ok(widgetService.save(w));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable long id) {
		WidgetDTO oldWidget = widgetService.getById(id).get();
		widgetService.delete(id);
		return ResponseEntity.ok("Deleted workspace: " + oldWidget);
	}

	@PutMapping
	public ResponseEntity<WidgetDTO> update(@RequestBody WidgetDTO w) {
		return ResponseEntity.ok(widgetService.update(w));
	}

}

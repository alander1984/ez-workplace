package ru.egartech.workplace.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.egartech.workplace.dto.WidgetPropertyDTO;
import ru.egartech.workplace.service.WidgetPropertyServiceImpl;

@Controller
@RequestMapping(value = "/widgetproperty", produces = MediaType.APPLICATION_JSON_VALUE)
public class WidgetPropertyController {

    private final WidgetPropertyServiceImpl widgetPropertyService;

    WidgetPropertyController (WidgetPropertyServiceImpl widgetPropertyService) { this.widgetPropertyService = widgetPropertyService; }

    @GetMapping
    public ResponseEntity<Page<WidgetPropertyDTO>> getAll(
            @RequestParam(value = "size", defaultValue = "100") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {

        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(widgetPropertyService.getAll(paging));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WidgetPropertyDTO> getById (@PathVariable long id) {
        return ResponseEntity.ok(widgetPropertyService.getById(id).get());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody WidgetPropertyDTO w) {
        WidgetPropertyDTO newProperty = widgetPropertyService.save(w);
        return ResponseEntity.ok("Added widget property: " + newProperty.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        WidgetPropertyDTO oldProperty = widgetPropertyService.getById(id).get();
        widgetPropertyService.delete(id);
        return ResponseEntity.ok("Deleted workspace: " + oldProperty);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody WidgetPropertyDTO w) {
        WidgetPropertyDTO oldProperty = widgetPropertyService.getById(w.getId()).get();
        widgetPropertyService.update(w);
        return ResponseEntity.ok("Updated workspace: " + oldProperty + " -> " + widgetPropertyService.getById(w.getId()));
    }

}

package ru.egartech.workplace.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.egartech.workplace.dto.TemplateDTO;
import ru.egartech.workplace.service.TemplateService;

@RequestMapping(value = "/template", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
public class TemplateController {

    private final TemplateService templateService;

    TemplateController(TemplateService templateService) { this.templateService = templateService; }

    @GetMapping(value = "/all")
    public ResponseEntity<Page<TemplateDTO>> getAll(
            @RequestParam(value = "size", defaultValue = "100") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {

        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(templateService.getAll(paging));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TemplateDTO> getById(@PathVariable long id) {
        return ResponseEntity.ok(templateService.getById(id).get());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TemplateDTO t) {
        templateService.save(t);
        return ResponseEntity.ok("Added template: " + t.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        TemplateDTO oldTemplate = templateService.getById(id).get();
        templateService.delete(id);
        return ResponseEntity.ok("Deleted template: " + oldTemplate);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody TemplateDTO t) {
        TemplateDTO oldTemplate = templateService.getById(t.getId()).get();
        templateService.update(t);
        return ResponseEntity.ok("Updated template: " + oldTemplate + " -> " + templateService.getById(t.getId()));
    }
}

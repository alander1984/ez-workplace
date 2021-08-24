package ru.egartech.workplace.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.egartech.workplace.dto.WPlaceholderDTO;
import ru.egartech.workplace.service.WPlaceholderServiceImpl;

@Controller
@RequestMapping(value = "/wplaceholder", produces = MediaType.APPLICATION_JSON_VALUE)
public class WPlaceholderController {

    private final WPlaceholderServiceImpl wPlaceholderService;

    WPlaceholderController (WPlaceholderServiceImpl wPlaceholderService) { this.wPlaceholderService = wPlaceholderService; }

    @GetMapping
    public ResponseEntity<Page<WPlaceholderDTO>> getAll(
            @RequestParam(value = "size", defaultValue = "100") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {

        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(wPlaceholderService.getAll(paging));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WPlaceholderDTO> getById (@PathVariable long id) {
        return ResponseEntity.ok(wPlaceholderService.getById(id).get());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody WPlaceholderDTO w) {
        WPlaceholderDTO newPlaceholder = wPlaceholderService.save(w);
        return ResponseEntity.ok("Added wplaceholder: " + newPlaceholder.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        WPlaceholderDTO oldWPlaceholder = wPlaceholderService.getById(id).get();
        wPlaceholderService.delete(id);
        return ResponseEntity.ok("Deleted workspace: " + oldWPlaceholder);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody WPlaceholderDTO w) {
        WPlaceholderDTO oldWPlaceholder = wPlaceholderService.getById(w.getId()).get();
        wPlaceholderService.update(w);
        return ResponseEntity.ok("Updated workspace: " + oldWPlaceholder + " -> " + wPlaceholderService.getById(w.getId()));
    }

}

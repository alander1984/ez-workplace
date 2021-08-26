package ru.egartech.workplace.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.egartech.workplace.dto.WSettingsDTO;
import ru.egartech.workplace.service.WSettingsServiceImpl;

@Controller
@RequestMapping(value = "/wsettings", produces = MediaType.APPLICATION_JSON_VALUE)
public class WSettingsController {

    private final WSettingsServiceImpl wSettingsService;

    WSettingsController (WSettingsServiceImpl wSettingsService) { this.wSettingsService = wSettingsService; }

    @GetMapping
    public ResponseEntity<Page<WSettingsDTO>> getAll(
            @RequestParam(value = "size", defaultValue = "100") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {

        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(wSettingsService.getAll(paging));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WSettingsDTO> getById (@PathVariable long id) {
        return ResponseEntity.ok(wSettingsService.getById(id).get());
    }

    @PostMapping
    public ResponseEntity<WSettingsDTO> save(@RequestBody WSettingsDTO w) {
        return ResponseEntity.ok(wSettingsService.save(w));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        WSettingsDTO oldSettings = wSettingsService.getById(id).get();
        wSettingsService.delete(id);
        return ResponseEntity.ok("Deleted workspace: " + oldSettings);
    }

    @PutMapping
    public ResponseEntity<WSettingsDTO> update(@RequestBody WSettingsDTO w) {
        return ResponseEntity.ok(wSettingsService.update(w));
    }

}

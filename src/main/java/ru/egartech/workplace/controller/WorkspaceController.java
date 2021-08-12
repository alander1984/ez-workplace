package ru.egartech.workplace.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.egartech.workplace.dto.WorkspaceDTO;
import ru.egartech.workplace.service.WorkspaceServiceImpl;

@Controller
@RequestMapping(value = "/workspace", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkspaceController {

    private final WorkspaceServiceImpl workspaceService;

    WorkspaceController (WorkspaceServiceImpl workspaceService) { this.workspaceService = workspaceService; }

    @GetMapping("/all")
    public ResponseEntity<Page<WorkspaceDTO>> getAll(
            @RequestParam(value = "size", defaultValue = "100") int size,
            @RequestParam(value = "page", defaultValue = "0") int page) {

        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(workspaceService.getAll(paging));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkspaceDTO> getById (@PathVariable long id) {
        return ResponseEntity.ok(workspaceService.getById(id).get());
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody WorkspaceDTO w) {
        workspaceService.save(w);
        return ResponseEntity.ok("Added workspace: " + w.toString());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        WorkspaceDTO oldWorkspace = workspaceService.getById(id).get();
        workspaceService.delete(id);
        return ResponseEntity.ok("Deleted workspace: " + oldWorkspace);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody WorkspaceDTO w) {
        WorkspaceDTO oldWorkspace = workspaceService.getById(w.getId()).get();
        workspaceService.update(w);
        return ResponseEntity.ok("Updated workspace: " + oldWorkspace + " -> " + workspaceService.getById(w.getId()));
    }
}

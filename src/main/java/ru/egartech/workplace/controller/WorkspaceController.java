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

    @GetMapping
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
    public ResponseEntity<WorkspaceDTO> save(@RequestBody WorkspaceDTO w) {
        return ResponseEntity.ok(workspaceService.save(w));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        WorkspaceDTO oldWorkspace = workspaceService.getById(id).get();
        workspaceService.delete(id);
        return ResponseEntity.ok("Deleted workspace: " + oldWorkspace);
    }

    @PutMapping
    public ResponseEntity<WorkspaceDTO> update(@RequestBody WorkspaceDTO w) {
        return ResponseEntity.ok(workspaceService.update(w));
    }
}

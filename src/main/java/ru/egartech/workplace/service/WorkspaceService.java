package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.egartech.workplace.dto.WorkspaceDTO;

import java.util.Optional;

public interface WorkspaceService {

    Page<WorkspaceDTO> getAll(Pageable page);
    Optional<WorkspaceDTO> getById(long id);
    void save(WorkspaceDTO w);
    void delete(long id);
    void update(WorkspaceDTO w);
}

package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.WorkspaceConverter;
import ru.egartech.workplace.dto.WorkspaceDTO;
import ru.egartech.workplace.repo.WorkspaceRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;

    WorkspaceServiceImpl (WorkspaceRepository workspaceRepository) { this.workspaceRepository = workspaceRepository; }

    @Override
    public Page<WorkspaceDTO> getAll(Pageable page) {
        return workspaceRepository.findAll(page).map(WorkspaceConverter::toDTO);
    }

    @Override
    public Optional<WorkspaceDTO> getById(long id) {
        return Optional.of(WorkspaceConverter.toDTO(workspaceRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new)));
    }

    @Override
    public void delete(long id) {
        workspaceRepository.deleteById(id);
    }

    @Override
    public void save(WorkspaceDTO w) {
        if (w != null) {
            workspaceRepository.save(WorkspaceConverter.toDomain(w));
        }
    }

    @Override
    public void update(WorkspaceDTO w) {
        if (getById(w.getId()).isPresent()) {
            WorkspaceDTO workspace = getById(w.getId()).get();
            workspace.setName(w.getName());
            workspace.setTemplateId(w.getTemplateId());
            save(workspace);
        }
    }
}

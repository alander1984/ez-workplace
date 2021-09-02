package ru.egartech.workplace.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.egartech.workplace.converter.WPlaceholderConverter;
import ru.egartech.workplace.converter.WorkspaceConverter;
import ru.egartech.workplace.domain.TemplatePlaceholder;
import ru.egartech.workplace.dto.TemplateDTO;
import ru.egartech.workplace.dto.WPlaceholderDTO;
import ru.egartech.workplace.dto.WorkspaceDTO;
import ru.egartech.workplace.repo.TemplatePlaceholderRepository;
import ru.egartech.workplace.repo.WPlaceholderRepository;
import ru.egartech.workplace.repo.WorkspaceRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.Optional;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    private final WorkspaceRepository workspaceRepository;
    private final WPlaceholderServiceImpl placeholderService;
    private final TemplatePlaceholderRepository templatePlaceholderRepository;

    WorkspaceServiceImpl(WorkspaceRepository workspaceRepository, WPlaceholderServiceImpl placeholderService, TemplatePlaceholderRepository templatePlaceholderRepository) {
        this.workspaceRepository = workspaceRepository;
        this.placeholderService = placeholderService;
        this.templatePlaceholderRepository = templatePlaceholderRepository;
    }

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
    public WorkspaceDTO save(WorkspaceDTO w) {
        if (w != null) {
            WorkspaceDTO newWorkplace = WorkspaceConverter.toDTO(workspaceRepository.save(WorkspaceConverter.toDomain(w)));
            for (TemplatePlaceholder templatePlaceholder : templatePlaceholderRepository.getByTemplateId(newWorkplace.getTemplateId())) {
                placeholderService.save(new WPlaceholderDTO(0L, newWorkplace.getId(), 0L, templatePlaceholder.getCode()));
            }
            return newWorkplace;
        }
        return null;
    }

    @Override
    public WorkspaceDTO update(WorkspaceDTO w) {
        if (getById(w.getId()).isPresent()) {
            WorkspaceDTO workspace = getById(w.getId()).get();
            workspace.setName(w.getName());
            workspace.setTemplateId(w.getTemplateId());
            return save(workspace);
        } else throw new EntityNotFoundException();
    }
}

package ru.egartech.workplace.converter;

import ru.egartech.workplace.domain.Widget;
import ru.egartech.workplace.domain.Workspace;
import ru.egartech.workplace.dto.WidgetDTO;
import ru.egartech.workplace.dto.WorkspaceDTO;

public class WorkspaceConverter {

    public static WorkspaceDTO toDTO(Workspace w) {
        return WorkspaceDTO.builder()
                .id(w.getId())
                .name(w.getName())
                .templateId(w.getTemplateId())
                .build();
    }

    public static Workspace toDomain(WorkspaceDTO w) {
        return Workspace.builder()
                .id(w.getId())
                .name(w.getName())
                .templateId(w.getTemplateId())
                .build();
    }

}

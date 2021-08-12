package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.Workspace;

@Repository
public interface WorkspaceRepository extends PagingAndSortingRepository<Workspace, Long> {
}

package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.TemplatePlaceholder;

@Repository
public interface TemplatePlaceholderRepository extends PagingAndSortingRepository<TemplatePlaceholder, Long> {
}

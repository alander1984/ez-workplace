package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.Template;

@Repository
public interface TemplateRepository extends PagingAndSortingRepository<Template, Long> {
}

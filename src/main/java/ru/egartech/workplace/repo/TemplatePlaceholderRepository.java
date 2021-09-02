package ru.egartech.workplace.repo;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.TemplatePlaceholder;

import java.util.Collection;

@Repository
public interface TemplatePlaceholderRepository extends PagingAndSortingRepository<TemplatePlaceholder, Long> {
    @Query("SELECT * FROM TEMPLATE_PLACEHOLDERS placeholder WHERE placeholder.TEMPLATE_ID = :id")
    Collection<TemplatePlaceholder> getByTemplateId(@Param("id") long id);
}

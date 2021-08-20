package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.WidgetProperty;

@Repository
public interface WidgetPropertyRepository extends PagingAndSortingRepository<WidgetProperty, Long> {
}

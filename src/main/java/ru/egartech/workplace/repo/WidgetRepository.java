package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.Widget;

@Repository
public interface WidgetRepository extends PagingAndSortingRepository<Widget, Long> {

}

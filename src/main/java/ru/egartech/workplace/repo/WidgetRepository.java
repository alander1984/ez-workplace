package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;

import ru.egartech.workplace.domain.Widget;

public interface WidgetRepository extends PagingAndSortingRepository<Widget, Long> {

}

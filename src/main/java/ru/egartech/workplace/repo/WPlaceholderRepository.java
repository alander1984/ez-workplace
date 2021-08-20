package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.WPlaceholder;

@Repository
public interface WPlaceholderRepository extends PagingAndSortingRepository<WPlaceholder, Long> {
}

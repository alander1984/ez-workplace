package ru.egartech.workplace.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.egartech.workplace.domain.WSettings;

@Repository
public interface WSettingsRepository extends PagingAndSortingRepository<WSettings, Long> {
}

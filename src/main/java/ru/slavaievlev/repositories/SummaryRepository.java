package ru.slavaievlev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.entities.Summary;

public interface SummaryRepository extends JpaRepository<Summary, Integer> {
    Summary getSummaryById(int id);
}

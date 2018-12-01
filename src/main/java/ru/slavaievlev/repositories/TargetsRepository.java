package ru.slavaievlev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.entities.Targets;

import java.util.List;

public interface TargetsRepository extends JpaRepository<Targets, Integer> {
    List<Targets> findBySummaryid(int summaryid);
}

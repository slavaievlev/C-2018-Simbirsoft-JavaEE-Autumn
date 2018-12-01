package ru.slavaievlev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.entities.Educations;

import java.util.List;

public interface EducationsRepository extends JpaRepository<Educations, Integer> {
    List<Educations> findBySummaryid(int summaryid);
}

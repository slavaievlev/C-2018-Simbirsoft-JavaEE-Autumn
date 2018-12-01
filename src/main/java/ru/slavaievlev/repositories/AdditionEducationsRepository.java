package ru.slavaievlev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.entities.Additioneducations;

import java.util.List;

public interface AdditionEducationsRepository extends JpaRepository<Additioneducations, Integer> {
    List<Additioneducations> findBySummaryid(int summaryid);
}

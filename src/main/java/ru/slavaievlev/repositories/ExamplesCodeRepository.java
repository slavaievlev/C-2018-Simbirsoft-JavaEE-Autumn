package ru.slavaievlev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.entities.Examplescode;

import java.util.List;

public interface ExamplesCodeRepository extends JpaRepository<Examplescode, Integer> {
}

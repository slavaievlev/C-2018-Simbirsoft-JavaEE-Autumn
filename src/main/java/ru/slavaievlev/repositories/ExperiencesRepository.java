package ru.slavaievlev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.entities.Experiences;

import java.util.List;

public interface ExperiencesRepository extends JpaRepository<Experiences, Integer> {
}

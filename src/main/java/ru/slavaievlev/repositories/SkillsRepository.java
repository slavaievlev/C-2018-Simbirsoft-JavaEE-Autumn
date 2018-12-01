package ru.slavaievlev.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.entities.Skills;

import java.util.List;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
}

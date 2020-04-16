package io.swagger.repository;

import io.swagger.model.DiabetesData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<DiabetesData, Integer> {
}

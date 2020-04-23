package io.swagger.repository;

import io.swagger.model.DiabetesData;
import io.swagger.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReadingRepository extends JpaRepository<Reading, Integer> {
}

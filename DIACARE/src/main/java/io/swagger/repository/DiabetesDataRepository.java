package io.swagger.repository;

import io.swagger.model.DiabetesData;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DiabetesDataRepository extends JpaRepository<DiabetesData, Integer> {

    @Query(value = "SELECT d from DiabetesData d where d.userId.userId = ?1 AND d.date <= ?2 AND d.date >= ?3")
    public List<DiabetesData> findByUserIdAndDateGreaterThanEqualAndDateLessThanEqual(Integer userId, Date today, Date dateOneWeekAgo);

}

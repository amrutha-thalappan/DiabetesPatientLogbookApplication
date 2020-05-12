package io.swagger.repository;

import io.swagger.model.ReadingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReadingDetailsRepository extends JpaRepository<ReadingDetails, Integer> {

    @Query(value = "SELECT r from ReadingDetails r where r.user.userId = ?1 AND r.date <= ?2 AND r.date >= ?3")
    List<ReadingDetails> findByUserIdAndDateGreaterThanEqualAndDateLessThanEqual(Integer userId, Date now, Date dateOneWeekAgo);

    ReadingDetails findByUserIdAndDate(Integer userId, Date now);

}

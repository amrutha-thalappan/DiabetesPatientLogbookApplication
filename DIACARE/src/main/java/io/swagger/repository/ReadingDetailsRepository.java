package io.swagger.repository;

import io.swagger.model.ReadingDetails;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReadingDetailsRepository extends
        JpaRepository<ReadingDetails, Integer> {

    public ReadingDetails findByUserIdAndDate(Integer userId, Date now);

    public List<ReadingDetails> findByUserOrderByDateDesc(User userId);

}

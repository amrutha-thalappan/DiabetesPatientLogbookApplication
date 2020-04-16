package io.swagger.repository;

import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserId(Integer userId);

    @Query(value = "Select MAX(u.userId) FROM User u")
    public Integer findOneByMaxUserId();
}

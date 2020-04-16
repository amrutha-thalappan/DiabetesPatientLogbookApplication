package io.swagger.repository;

import io.swagger.model.LoginCredentials;
import io.swagger.model.LoginDetails;
import io.swagger.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginDetails, Integer> {

    public LoginDetails findByUserNameAndPassword(String userName, String password);

}

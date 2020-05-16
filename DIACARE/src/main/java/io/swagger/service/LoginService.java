package io.swagger.service;

import io.swagger.model.LoggedInUser;
import io.swagger.model.LoginCredentials;
import io.swagger.model.LoginDetails;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    public void saveLoginDetails(LoginDetails loginDetails);
    public LoggedInUser verifyUser(LoginCredentials loginCredentials) throws Exception;

}

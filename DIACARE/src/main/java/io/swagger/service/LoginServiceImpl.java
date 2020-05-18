package io.swagger.service;

import io.swagger.model.LoggedInUser;
import io.swagger.model.LoginCredentials;
import io.swagger.model.LoginDetails;
import io.swagger.model.User;
import io.swagger.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserService userService;


    @Override
    public void saveLoginDetails(LoginDetails loginDetails)    {
        loginRepository.save(loginDetails);
    }

    @Override
    public LoggedInUser verifyUser(LoginCredentials loginCredentials) throws Exception {
        LoggedInUser loggedInUser = new LoggedInUser();
        User user = null;
        LoginDetails credentials = loginRepository.findByUserNameAndPassword(loginCredentials.getUsername(),loginCredentials.getPassword());
        loggedInUser.setUserId(credentials.getUserId().getUserId());
        loggedInUser.setUserName(credentials.getUserName());
        loggedInUser.setPassword(credentials.getPassword());
        if(credentials != null){
            user = userService.findByUserId(credentials.getUserId().getUserId());
            loggedInUser.setFirstName(user.getFirstName());
            loggedInUser.setLastName(user.getLastName());
            loggedInUser.setContactNumber(user.getContactNumber());
            loggedInUser.setEmail(user.getEmail());
        }else{
            return null;
        }
        return loggedInUser;
    }
}

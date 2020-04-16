package io.swagger.service;

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
    public void saveLoginDetails(LoginDetails loginDetails) {
        loginRepository.save(loginDetails);
    }

    @Override
    public User verifyUser(LoginCredentials loginCredentials) throws Exception {
        User user = null;
        LoginDetails credentials = loginRepository.findByUserNameAndPassword(loginCredentials.getUsername(),loginCredentials.getPassword());
        if(credentials != null){
            user = userService.findByUserId(credentials.getUserId().getUserId());
        }else{
            throw new Exception("User not exists");
        }
        return user;
    }

}

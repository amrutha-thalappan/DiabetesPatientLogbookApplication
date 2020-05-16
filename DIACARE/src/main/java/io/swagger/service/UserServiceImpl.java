/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.service;

import io.swagger.model.LoginDetails;
import io.swagger.model.User;
import io.swagger.model.UserDto;
import io.swagger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 *
 * @author
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Autowired
    public LoginService loginService;

    @Override
    public User findByUserId(Integer userId) {
        User user = null;
        System.out.println("service");
        user = userRepository.findByUserId(userId);
        return user;
    }

    @Override
    public List<User> findAllPerson() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(UserDto userDto) {
        User user = new User();
        Integer maxUserId = findMaxUserId();
        if(maxUserId == null) {
            maxUserId = 0;
        }
        user.setUserId(maxUserId+1);
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setContactNumber(userDto.getContactNumber());
        user.setEmail(userDto.getEmail());

        LoginDetails loginDetails = new LoginDetails();
        loginDetails.setUserId(user);
        loginDetails.setUserName(userDto.getUserName());
        loginDetails.setPassword(userDto.getPassword());

        try {
            userRepository.save(user);
            loginService.saveLoginDetails(loginDetails);
        }catch(Exception e){
            System.out.println("Save failed "+ e.getMessage());
        }
        return user;
    }

    @Override
    public Integer findMaxUserId() {
        return userRepository.findOneByMaxUserId();
    }


}

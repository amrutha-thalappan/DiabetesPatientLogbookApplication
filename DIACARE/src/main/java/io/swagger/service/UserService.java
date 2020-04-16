/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.swagger.service;

import io.swagger.model.User;
import io.swagger.model.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Rahul T V
 */
@Service
public interface UserService {

    public User findByUserId(Integer userId);

    public List<User> findAllPerson();
    public User saveUser(UserDto user);
    public Integer findMaxUserId();
}

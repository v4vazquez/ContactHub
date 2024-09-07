package com.techelevator.dao;

import com.techelevator.model.RegisterUserDto;
import com.techelevator.model.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    User getUserById(int id);
    int findIdByUsername(String username);
    User getUserByUsername(String username);
    User createUser(RegisterUserDto user);
}

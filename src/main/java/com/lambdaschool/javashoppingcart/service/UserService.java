package com.lambdaschool.javashoppingcart.service;

import com.lambdaschool.javashoppingcart.models.User;

import java.util.List;

public interface UserService {

    User save(User user);
    List<User> findAll();
    void delete(long id);
}

package com.spitsin.dao;

import com.spitsin.main.User;

import java.util.List;

/**
 * Created by aser on 15.02.2016.
 */
public interface UserDao {
    List<User> getAll() throws Exception;

    User getById(int id) throws Exception;

    User getByName(String name) throws Exception;

    int deleteById(int id) throws Exception;

    void insert(User user) throws Exception;

}

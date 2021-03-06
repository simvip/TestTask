package com.Sliusar.testTask.dao;

import com.Sliusar.testTask.model.User;

import java.util.List;

/**
 * Created by Admin on 21.11.2016.
 */
public interface UserDao {
    public void addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserById(int id);

    public List<User> listUsers();

    public void fillStartList();
}

package com.Sliusar.testTask.service;

import com.Sliusar.testTask.dao.UserDao;
import com.Sliusar.testTask.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Admin on 21.11.2016.
 */
@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);

    }

    @Override
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUsers() {
        return this.userDao.listUsers();
    }

    @Override
    @Transactional
    public void fillStartList(){
        this.userDao.fillStartList();
    }

}

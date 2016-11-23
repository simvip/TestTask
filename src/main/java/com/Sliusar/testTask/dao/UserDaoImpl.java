package com.Sliusar.testTask.dao;

import com.Sliusar.testTask.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class UserDaoImpl implements UserDao {

    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. Details: " + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully update. Details: " + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if(user!=null){
            session.delete(user);
        }
        logger.info("User successfully removed. Details: " + user);
    }

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. Details: " + user);

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();

        for(User user: userList){
            logger.info("User list: " + user);
        }

        return userList;
    }

    @Override
    @Transactional
    public void fillStartList(){

        ArrayList<String> listname = new ArrayList<String>();

        listname.add("Kevin");
        listname.add("Ivan");
        listname.add("Kindrat");
        listname.add("Anton");
        listname.add("Pretty woman");
        listname.add("Kitti");
        listname.add("Piter");

        int maxInd = listname.size()-1;

        Random random = new Random();
        for (int i=0; i<10; i++) {
            User user = new User();
            user.setAdmin(random.nextBoolean());
            user.setName(listname.get(random.nextInt(maxInd)));
            user.setAge(random.nextInt(50));
            addUser(user);
        }

    }
}

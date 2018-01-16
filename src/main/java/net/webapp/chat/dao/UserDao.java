package net.webapp.chat.dao;

import net.webapp.chat.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getAllUsers(){
        Session session = this.sessionFactory.getCurrentSession();
        List<User> users = session.createQuery("from user").list();
        return users;
    }


}

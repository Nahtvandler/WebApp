package net.webapp.chat.service;

import net.webapp.chat.dao.UserDao;
import net.webapp.chat.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class UserServ {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> getAllUsers(){
        return this.userDao.getAllUsers();
    }
}

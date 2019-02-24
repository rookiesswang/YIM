package top.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import top.learn.configuration.UserDao;
import top.learn.entity.User;
import top.learn.service.UserService;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findByAccount(String account) {
        return userDao.selectByAccount(account);
    }

    @Override
    public int registerUser(User user) {
            return userDao.insert(user);
    }


}

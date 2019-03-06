package top.learn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.learn.configuration.FriendDao;
import top.learn.configuration.UserDao;
import top.learn.entity.Friend;
import top.learn.service.UserService;
import top.learn.entity.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private FriendDao friendDao;

    @Override
    public User findByAccount(String account) {
        return userDao.selectByAccount(account);
    }

    @Override
    public int registerUser(User user) {
            return userDao.insert(user);
    }

    @Override
    public List<Friend> findFriendsById(Integer id) {
        return friendDao.selectFriendsById(id);
    }


}

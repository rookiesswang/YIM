package top.learn.service;

import top.learn.entity.User;

public interface UserService {
     User findByAccount(String account);

     int registerUser(User user);

}

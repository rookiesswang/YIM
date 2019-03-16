package top.learn.service;

import top.learn.entity.Friend;
import top.learn.entity.FriendMenu;
import top.learn.entity.Group;
import top.learn.entity.User;

import java.util.List;

public interface UserService {
     User findByAccount(String account);

     int registerUser(User user);

     List<Friend> findFriendsById(Integer Id);

     List<Group> findGroupsById(Integer Id);

}

package top.learn.configuration;

import org.springframework.stereotype.Repository;
import top.learn.entity.Friend;

import java.util.List;

@Repository
public interface FriendDao {
    List<Friend> selectFriendsById(Integer id);
}

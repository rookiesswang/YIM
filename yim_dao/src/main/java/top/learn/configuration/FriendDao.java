package top.learn.configuration;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.learn.entity.Friend;

import java.util.List;

@Repository
public interface FriendDao {
    List<Friend> selectFriendsById(@Param("user_id") Integer id);
}

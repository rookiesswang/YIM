package top.learn.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserVO implements Serializable {
    private String username;
    private String id;
    private String status;
    private String sign;
    private String avatar;

    public UserVO(){}

    public UserVO(Friend friend) {
        id = friend.getAccount();
        username = friend.getNickname();
        status = friend.getStatus();
        sign = friend.getSign();
        avatar = friend.getAvatar();
    }

    public UserVO(User user) {
        id = user.getAccount();
        username = user.getNickname();
        status = user.getStatus();
        sign = user.getSign();
        avatar = user.getAvatar();
    }


}

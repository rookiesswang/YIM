package top.learn.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class FriendMenu implements Serializable {
    private String groupname;
    private String id;
    private Set<UserVO> list;

    public FriendMenu() {
        this.id = "";
        this.groupname = "";
        this.list = new HashSet<>();
    }
}

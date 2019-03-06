package top.learn.entity;

import lombok.Data;

import java.util.List;

@Data
public class FriendMenu {
    private int menu_id;
    private String groupName;
    private List<User> friends;
}

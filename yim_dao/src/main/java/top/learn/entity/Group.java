package top.learn.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Group implements Serializable {
    private String groupname;
    private String id;
    private String avatar;
}

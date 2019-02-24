package top.learn.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "chat_group", schema = "yim")
public class ChatGroup {
    private int groupId;
    private Integer groupNo;
    private String groupDesc;

    @Id
    @Column(name = "group_id")
    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    @Basic
    @Column(name = "group_no")
    public Integer getGroupNo() {
        return groupNo;
    }

    public void setGroupNo(Integer groupNo) {
        this.groupNo = groupNo;
    }

    @Basic
    @Column(name = "group_desc")
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatGroup chatGroup = (ChatGroup) o;
        return groupId == chatGroup.groupId &&
                Objects.equals(groupNo, chatGroup.groupNo) &&
                Objects.equals(groupDesc, chatGroup.groupDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(groupId, groupNo, groupDesc);
    }
}

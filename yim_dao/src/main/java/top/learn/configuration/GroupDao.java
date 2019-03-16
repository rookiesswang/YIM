package top.learn.configuration;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import top.learn.entity.Group;

import java.util.List;

@Component
public interface GroupDao {

    public List<Group> selectGroupsById(@Param("user_id")Integer Id);
}

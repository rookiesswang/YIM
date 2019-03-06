package top.learn.configuration;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import top.learn.entity.User;

@Repository
@Mapper
public interface UserDao extends tk.mybatis.mapper.common.Mapper<User>{

    User selectByAccount(@Param("account") String account);
}

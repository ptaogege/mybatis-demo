package com.demo.mapper;

import com.demo.entity.UserDo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UserMapper {
    int insertInfo(UserDo userDo);

    int deleteUser(Integer id);

    int updateInfo(UserDo userDo);

    UserDo selectByColumn(@Param("column") String column, @Param("values") String values);

    List<UserDo> selectByIds(@Param("ids") Collection<Integer> ids);

    List<UserDo> findActiveUser(UserDo userDo);
}

package com.vouov.yapps.dao;

import com.vouov.yapps.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userID);

    int insert(User record);

    User selectByPrimaryKey(Integer userID);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}
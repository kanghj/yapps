package com.vouov.yapps.service;

import com.vouov.yapps.dao.UserMapper;
import com.vouov.yapps.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: yuml
 * Date: 12-9-8
 * Time: 上午1:00
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> selectAll(){
        return userMapper.selectAll();
    }
}

package com.vouov.yapps.controller;

import com.vouov.yapps.dao.UserMapper;
import com.vouov.yapps.json.bean.Pagination;
import com.vouov.yapps.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: yuml
 * Date: 12-9-9
 * Time: 下午6:37
 */
@Controller
@RequestMapping("/manager/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/search")
    @ResponseBody
    public Pagination<User> queryAll() {
        Pagination<User> pagingData = new Pagination<User>();
        List<User> data = userMapper.selectAll();
        pagingData.setTotal(data.size());
        pagingData.setData(data);
        return pagingData;
    }
}

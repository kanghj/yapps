package com.vouov.yapps.dao;

import com.vouov.yapps.model.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuMapper {
    int deleteByPrimaryKey(Integer menuID);

    int insert(Menu record);

    Menu selectByPrimaryKey(Integer menuID);

    List<Menu> selectAll();

    int updateByPrimaryKey(Menu record);
}
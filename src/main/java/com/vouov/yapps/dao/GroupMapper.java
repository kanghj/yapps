package com.vouov.yapps.dao;

import com.vouov.yapps.model.Group;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GroupMapper {
    int deleteByPrimaryKey(Integer groupID);

    int insert(Group record);

    Group selectByPrimaryKey(Integer groupID);

    List<Group> selectAll();

    int updateByPrimaryKey(Group record);
}
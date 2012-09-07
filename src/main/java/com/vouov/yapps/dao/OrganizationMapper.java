package com.vouov.yapps.dao;

import com.vouov.yapps.model.Organization;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrganizationMapper {
    int deleteByPrimaryKey(Integer orgID);

    int insert(Organization record);

    Organization selectByPrimaryKey(Integer orgID);

    List<Organization> selectAll();

    int updateByPrimaryKey(Organization record);
}
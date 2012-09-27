package com.vouov.yapps.service;

import com.vouov.yapps.dao.PermissionMapper;
import com.vouov.yapps.model.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User: yuml
 * Date: 12-9-9
 * Time: 下午6:18
 */
@Service
public class PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;

    public List<Permission> query(){
        return permissionMapper.selectAll();
    }
}

package com.vouov.yapps.controller;

import com.vouov.yapps.json.bean.JsonResult;
import com.vouov.yapps.json.bean.Pagination;
import com.vouov.yapps.model.Permission;
import com.vouov.yapps.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: yuml
 * Date: 12-9-22
 * Time: 下午11:58
 */
@Controller
@RequestMapping("/manager/permission")
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    @RequestMapping("/search")
    @ResponseBody
    public Pagination<Permission> query() {
        Pagination<Permission> data = new Pagination<Permission>();
        List<Permission> permissions = permissionService.query();
        data.setData(permissions);
        data.setTotal(permissions.size());
        return data;
    }
    @RequestMapping("/delete")
    @ResponseBody
    public JsonResult delete(@RequestBody Permission permission){
        JsonResult jsonResult = new JsonResult();
        long id = permission.getPermissionID();
        System.out.println(id);
        jsonResult.setSuccess(false);
        jsonResult.setMessage("没有权限");
        return jsonResult;
    }
}

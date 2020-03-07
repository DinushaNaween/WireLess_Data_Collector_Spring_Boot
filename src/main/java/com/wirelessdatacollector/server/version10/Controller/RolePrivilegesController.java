package com.wirelessdatacollector.server.version10.Controller;

import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.entity.RolePrivilege;
import com.wirelessdatacollector.server.version10.service.RolePrivilegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/roleprivilege")
public class RolePrivilegesController {

    @Autowired
    private RolePrivilegesService rolePrivilegesService;

    // ---------------------------------
    // add new role privilege to database
    // ---------------------------------
    @PostMapping(path = "/")
    public @ResponseBody String addRolePrivilege(@RequestBody RolePrivilege rolePrivilege){

        return rolePrivilegesService.addRolePrivilege(rolePrivilege);
    }

    // ---------------------------------
    // update role privilege
    // ---------------------------------
    @PostMapping(path = "/update")
    public @ResponseBody String updateRolePrivilege(@RequestBody RolePrivilege rolePrivilege){

        Integer privilegeId = 0;

        if (rolePrivilege.getPrivilegeId() != 0){
            privilegeId = rolePrivilege.getPrivilegeId();
        }
        return rolePrivilegesService.updateRolePrivilege(privilegeId, rolePrivilege);
    }
}

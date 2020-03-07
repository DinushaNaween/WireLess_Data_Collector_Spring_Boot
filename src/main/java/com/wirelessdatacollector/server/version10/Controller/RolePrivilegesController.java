package com.wirelessdatacollector.server.version10.Controller;

import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.entity.RolePrivilege;
import com.wirelessdatacollector.server.version10.service.RolePrivilegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    // ---------------------------------
    // get all role privileges
    // ---------------------------------
    @GetMapping(path = "/")
    public @ResponseBody Iterable<RolePrivilege> getAllRolePrivileges(){

        return rolePrivilegesService.getAllPrivileges();
    }

    // ---------------------------------
    // get role privilege by id
    // ---------------------------------
    @GetMapping(path = "/{privilegeId}")
    public @ResponseBody
    Optional<RolePrivilege> getRolePrivilegeById(@PathVariable Integer privilegeId){

        return rolePrivilegesService.getPrivilegeById(privilegeId);
    }

    // ---------------------------------
    // delete role privilege
    // ---------------------------------
    @DeleteMapping(path = "/delete/{privilegeId}")
    public @ResponseBody String deleteRolePrivilege(@PathVariable Integer privilegeId){

        return rolePrivilegesService.deletePrivilege(privilegeId);
    }
}

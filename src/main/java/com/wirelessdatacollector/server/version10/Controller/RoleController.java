package com.wirelessdatacollector.server.version10.Controller;

import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/role")
public class RoleController {

    @Autowired 
    private RoleService roleService;

    // ---------------------------------
    // add new role to database
    // ---------------------------------
    @PostMapping(path = "/")
    public @ResponseBody String addRole(@RequestBody Role role){

        return roleService.addRole(role);
    }

    // ---------------------------------
    // update role
    // ---------------------------------
    @PostMapping(path = "/update")
    public @ResponseBody String updateRole(@RequestBody Role role){

        Integer roleId = 0;

        if (role.getRoleId() != 0){
            roleId = role.getRoleId();
        }
        return roleService.updateRole(roleId, role);
    }

    // ---------------------------------
    // get all roles
    // ---------------------------------
    @GetMapping(path = "/")
    public @ResponseBody Iterable<Role> getAllRoles(){

        return roleService.getAllRoles();
    }

    // ---------------------------------
    // get a role
    // ---------------------------------
    @GetMapping(path = "/{roleId}")
    public @ResponseBody Optional<Role> getRoleById(@PathVariable Integer roleId){

        return roleService.getRoleById(roleId);
    }

    // ---------------------------------
    // delete role
    // ---------------------------------
    @DeleteMapping(path = "/delete/{roleId}")
    public @ResponseBody String deleteRole(@PathVariable Integer roleId){

        return roleService.deleteRole(roleId);
    }
}

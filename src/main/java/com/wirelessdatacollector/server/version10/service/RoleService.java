package com.wirelessdatacollector.server.version10.service;

import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    // ---------------------------------
    // add new role to database
    // ---------------------------------
    public String addRole(Role role){

        try {
            roleRepository.save(role);
            return "Saved";
        } catch (Exception e){
            return e.toString();
        }
    }

    // ---------------------------------
    // update role
    // ---------------------------------
    public String updateRole(Integer roleId, Role role){

        if (roleId == 0){
            return "Id not found";
        }

        try {
            role.setRoleId(roleId);
            roleRepository.save(role);
            return "Updated";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // get all roles
    // ---------------------------------
    public Iterable<Role> getAllRoles(){
        System.out.println("get all roles");
        return roleRepository.findAll();
    }

    // ---------------------------------
    // get role by id
    // ---------------------------------
    public Optional<Role> getRoleById(Integer roleId){
        return roleRepository.findById(roleId);
    }

    // ---------------------------------
    // delete a role
    // ---------------------------------
    public String deleteRole(Integer roleId){

        try {
            roleRepository.deleteById(roleId);
            return "Role deleted successfully";
        } catch (Exception e){
            return "Failed to delete";
        }
    }
}

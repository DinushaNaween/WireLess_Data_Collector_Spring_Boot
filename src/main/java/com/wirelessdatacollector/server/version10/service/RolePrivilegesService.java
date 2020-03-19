package com.wirelessdatacollector.server.version10.service;

import com.wirelessdatacollector.server.version10.entity.RolePrivilege;
import com.wirelessdatacollector.server.version10.repository.RolePrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.Query;
import javax.persistence.EntityManager;
import java.util.Optional;

@Service
public class RolePrivilegesService {

    @Autowired
    private RolePrivilegeRepository rolePrivilegesRepository;

//    private EntityManager entityManager;

    // ---------------------------------
    // add new role privilege
    // ---------------------------------
    public String addRolePrivilege(RolePrivilege rolePrivilege){

        try {
            rolePrivilegesRepository.save(rolePrivilege);
            return "Saved";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // update rolePrivilege
    // ---------------------------------
    public String updateRolePrivilege(Integer rolePrivilegeId, RolePrivilege rolePrivilege){

        try {
            rolePrivilege.setPrivilegeId(rolePrivilegeId);
            rolePrivilegesRepository.save(rolePrivilege);
            return "Updated";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // get all privileged
    // ---------------------------------
    public Iterable<RolePrivilege> getAllPrivileges(){ return rolePrivilegesRepository.findAll(); }

    // ---------------------------------
    // get privilege by id
    // ---------------------------------
    public Optional<RolePrivilege> getPrivilegeById(Integer privilegeId){ return rolePrivilegesRepository.findById(privilegeId); }

    // ---------------------------------
    // delete a privilege
    // ---------------------------------
    public String deletePrivilege(Integer privilegeId){

        try {
            rolePrivilegesRepository.deleteById(privilegeId);
            return "Privilege deleted successfully";
        } catch (Exception e){
            return "Failed to delete";
        }
    }

    // ---------------------------------
    // get all privileges of a role
    // ---------------------------------
//    public RolePrivilege getAllPrivilegesOfARole(Integer roleId){
//        try {
//
//
//            Query query = new
//        }
//    }
}

package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.RolePrivilege;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolePrivilegeRepository extends CrudRepository<RolePrivilege, Integer> {
}

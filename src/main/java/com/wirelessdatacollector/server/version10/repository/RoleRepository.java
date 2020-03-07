package com.wirelessdatacollector.server.version10.repository;


import com.wirelessdatacollector.server.version10.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}

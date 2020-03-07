package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
}

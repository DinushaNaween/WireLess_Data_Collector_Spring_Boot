package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.Unit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Integer> {
}

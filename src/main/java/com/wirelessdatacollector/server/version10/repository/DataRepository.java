package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.Data;
import org.springframework.data.repository.CrudRepository;

public interface DataRepository extends CrudRepository<Data, Integer> {
}

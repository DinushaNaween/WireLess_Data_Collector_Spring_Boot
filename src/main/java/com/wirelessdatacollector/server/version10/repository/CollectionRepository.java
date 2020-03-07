package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.Collection;
import org.springframework.data.repository.CrudRepository;

public interface CollectionRepository extends CrudRepository<Collection, Integer> {
}

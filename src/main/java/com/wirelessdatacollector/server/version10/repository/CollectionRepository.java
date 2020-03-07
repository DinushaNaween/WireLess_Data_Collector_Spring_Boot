package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.Collection;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends CrudRepository<Collection, Integer> {
}

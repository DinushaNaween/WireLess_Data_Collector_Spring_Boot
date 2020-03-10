package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.ParentNode;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentNodeRepository extends CrudRepository<ParentNode, Integer> {
}

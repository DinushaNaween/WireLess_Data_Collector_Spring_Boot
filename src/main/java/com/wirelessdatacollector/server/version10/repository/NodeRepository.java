package com.wirelessdatacollector.server.version10.repository;

import com.wirelessdatacollector.server.version10.entity.Node;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NodeRepository extends CrudRepository<Node, Integer> {
}

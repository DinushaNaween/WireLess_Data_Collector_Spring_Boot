package com.wirelessdatacollector.server.version10.service;

import com.wirelessdatacollector.server.version10.entity.Node;
import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    // ---------------------------------
    // add new node
    // ---------------------------------
    public String addNode(Node node){

        try {
            nodeRepository.save(node);
            return "Saved";
        } catch (Exception e){
            return e.toString();
        }
    }

    // ---------------------------------
    // update node
    // ---------------------------------
    public String updateNode(Integer nodeId, Node node){

        if (nodeId == 0){
            return "Id not found";
        }

        try {
            node.setNodeId(nodeId);
            nodeRepository.save(node);
            return "Updated";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // get all nodes
    // ---------------------------------
    public Iterable<Node> getAllNodes(){

        return nodeRepository.findAll();
    }

    // ---------------------------------
    // get node by id
    // ---------------------------------
    public Optional<Node> getNodeById(Integer nodeId){

        return nodeRepository.findById(nodeId);
    }

    // ---------------------------------
    // delete a node
    // ---------------------------------
    public String deleteNode(Integer nodeId){

        try {
            nodeRepository.deleteById(nodeId);
            return "Node deleted successfully";
        } catch (Exception e){
            return "Failed to delete";
        }
    }
}

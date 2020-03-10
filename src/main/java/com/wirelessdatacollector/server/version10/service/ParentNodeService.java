package com.wirelessdatacollector.server.version10.service;

import com.wirelessdatacollector.server.version10.entity.ParentNode;
import com.wirelessdatacollector.server.version10.repository.ParentNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ParentNodeService {

    @Autowired
    private ParentNodeRepository parentNodeRepository;

    // ---------------------------------
    // add new parent node to database
    // ---------------------------------
    public String addParentNode(ParentNode parentNode){

        try {
            parentNodeRepository.save(parentNode);
            return "Saved";
        } catch (Exception e){
            return e.toString();
        }
    }

    // ---------------------------------
    // update parent node
    // ---------------------------------
    public String updateParentNode(Integer parentNodeId, ParentNode parentNode){

        if (parentNodeId == 0){
            return "Id not found";
        }

        try {
            parentNode.setParentNodeId(parentNodeId);
            parentNodeRepository.save(parentNode);
            return "Updated";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // get all parent nodes
    // ---------------------------------
    public Iterable<ParentNode> getAllParentNodes(){

        return parentNodeRepository.findAll();
    }

    // ---------------------------------
    // get parent node by id
    // ---------------------------------
    public Optional<ParentNode> getParentNodeById(Integer parentNodeId){

        return parentNodeRepository.findById(parentNodeId);
    }

    // ---------------------------------
    // delete a parent node
    // ---------------------------------
    public String deleteParentNode(Integer parentNodeId){

        try {
            parentNodeRepository.deleteById(parentNodeId);
            return "Parent Node deleted successfully";
        } catch (Exception e){
            return "Failed to delete";
        }
    }
}

package com.wirelessdatacollector.server.version10.Controller;

import com.wirelessdatacollector.server.version10.entity.Node;
import com.wirelessdatacollector.server.version10.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class NodeController {

    @Autowired
    private NodeService nodeService;

    // ---------------------------------
    // add new node to database
    // ---------------------------------
    @PostMapping(path = "/")
    public @ResponseBody String addNode(@RequestBody Node node){

        return nodeService.addNode(node);
    }

    // ---------------------------------
    // update node
    // ---------------------------------
    @PostMapping(path = "/update")
    public @ResponseBody String updateNode(@RequestBody Node node){

        Integer nodeId = 0;

        if (node.getNodeId() != 0){
            nodeId = node.getNodeId();
        }
        return nodeService.updateNode(nodeId, node);
    }

    // ---------------------------------
    // get all nodes
    // ---------------------------------
    @GetMapping(path = "/")
    public @ResponseBody Iterable<Node> getAllNodes(){

        return nodeService.getAllNodes();
    }

    // ---------------------------------
    // get a node
    // ---------------------------------
    @GetMapping(path = "/{nodeId}")
    public @ResponseBody Optional<Node> getNodeById(@PathVariable Integer nodeId){

        return nodeService.getNodeById(nodeId);
    }

    // ---------------------------------
    // delete node
    // ---------------------------------
    @DeleteMapping(path = "/delete/{nodeId}")
    public @ResponseBody String deleteNode(@PathVariable Integer nodeId){

        return nodeService.deleteNode(nodeId);
    }
}

package com.wirelessdatacollector.server.version10.Controller;

import com.wirelessdatacollector.server.version10.entity.Collection;
import com.wirelessdatacollector.server.version10.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

    // ---------------------------------
    // add new collection to database
    // ---------------------------------
    @PostMapping(path = "/")
    public @ResponseBody String addCollection(@RequestBody Collection collection){

        return collectionService.addCollection(collection);
    }

    // ---------------------------------
    // update collection
    // ---------------------------------
    @PostMapping(path = "/update")
    public @ResponseBody
    String updateCollection(@RequestBody Collection collection){

        Integer collectionId = 0;

        if (collection.getCollectionId() != 0){
            collectionId = collection.getCollectionId();
        }
        return collectionService.updateCollection(collectionId, collection);
    }

    // ---------------------------------
    // get all collection
    // ---------------------------------
    @GetMapping(path = "/")
    public @ResponseBody Iterable<Collection> getAllCollections(){

        return collectionService.getAllCollections();
    }

    // ---------------------------------
    // get a collection
    // ---------------------------------
    @GetMapping(path = "/{collectionId}")
    public @ResponseBody
    Optional<Collection> getCollectionById(@PathVariable Integer collectionId){

        return collectionService.getCollectionById(collectionId);
    }

    // ---------------------------------
    // delete collection
    // ---------------------------------
    @DeleteMapping(path = "/delete/{collectionId}")
    public @ResponseBody String deleteCollection(@PathVariable Integer collectionId){

        return collectionService.deleteCollection(collectionId);
    }
}

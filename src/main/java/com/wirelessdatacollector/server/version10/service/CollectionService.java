package com.wirelessdatacollector.server.version10.service;

import com.wirelessdatacollector.server.version10.entity.Collection;
import com.wirelessdatacollector.server.version10.entity.Role;
import com.wirelessdatacollector.server.version10.repository.CollectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CollectionService {

    @Autowired
    private CollectionRepository collectionRepository;

    // ---------------------------------
    // add new collection to database
    // ---------------------------------
    public String addCollection(Collection collection){

        try {
            collectionRepository.save(collection);
            return "Saved";
        } catch (Exception e){
            return e.toString();
        }
    }

    // ---------------------------------
    // update collection
    // ---------------------------------
    public String updateCollection(Integer collectionId, Collection collection){

        if (collectionId == 0){
            return "Id not found";
        }

        try {
            collection.setCollectionId(collectionId);
            collectionRepository.save(collection);
            return "Updated";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // get all collections
    // ---------------------------------
    public Iterable<Collection> getAllCollections(){

        return collectionRepository.findAll();
    }

    // ---------------------------------
    // get collection by id
    // ---------------------------------
    public Optional<Collection> getCollectionById(Integer collectionId){

        return collectionRepository.findById(collectionId);
    }

    // ---------------------------------
    // delete a collection
    // ---------------------------------
    public String deleteCollection(Integer collectionId){

        try {
            collectionRepository.deleteById(collectionId);
            return "Collection deleted successfully";
        } catch (Exception e){
            return "Failed to delete";
        }
    }
}

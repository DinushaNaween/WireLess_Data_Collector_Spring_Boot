package com.wirelessdatacollector.server.version10.service;

import com.wirelessdatacollector.server.version10.entity.Unit;
import com.wirelessdatacollector.server.version10.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UnitService {

    @Autowired
    private UnitRepository unitRepository;

    // ---------------------------------
    // add new unit to database
    // ---------------------------------
    public String addUnit(Unit unit){

        try {
            unitRepository.save(unit);
            return "Saved";
        } catch (Exception e){
            return e.toString();
        }
    }

    // ---------------------------------
    // update unit
    // ---------------------------------
    public String updateUnit(Integer unitId, Unit unit){

        if (unitId == 0){
            return "Id not found";
        }

        try {
            unit.setUnitId(unitId);
            unitRepository.save(unit);
            return "Updated";
        } catch (Exception e){
            return "Failed";
        }
    }

    // ---------------------------------
    // get all units
    // ---------------------------------
    public Iterable<Unit> getAllUnits(){

        return unitRepository.findAll();
    }

    // ---------------------------------
    // get unit by id
    // ---------------------------------
    public Optional<Unit> getUnitById(Integer unitId){

        return unitRepository.findById(unitId);
    }

    // ---------------------------------
    // delete a unit
    // ---------------------------------
    public String deleteUnit(Integer unitId){

        try {
            unitRepository.deleteById(unitId);
            return "Unit deleted successfully";
        } catch (Exception e){
            return "Failed to delete";
        }
    }
}

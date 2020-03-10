package com.wirelessdatacollector.server.version10.Controller;

import com.wirelessdatacollector.server.version10.entity.Unit;
import com.wirelessdatacollector.server.version10.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    // ---------------------------------
    // add new unit to collection
    // ---------------------------------
    @PostMapping(path = "/")
    public @ResponseBody String addUnit(@RequestBody Unit unit){

        return unitService.addUnit(unit);
    }

    // ---------------------------------
    // update unit
    // ---------------------------------
    @PostMapping(path = "/update")
    public @ResponseBody String updateUnit(@RequestBody Unit unit){

        Integer unitId = 0;

        if (unit.getUnitId() != 0){
            unitId = unit.getUnitId();
        }
        return unitService.updateUnit(unitId, unit);
    }

    // ---------------------------------
    // get all units
    // ---------------------------------
    @GetMapping(path = "/")
    public @ResponseBody Iterable<Unit> getAllUnits(){

        return unitService.getAllUnits();
    }

    // ---------------------------------
    // get a unit
    // ---------------------------------
    @GetMapping(path = "/{unitId}")
    public @ResponseBody Optional<Unit> getUnitById(@PathVariable Integer unitId){

        return unitService.getUnitById(unitId);
    }

    // ---------------------------------
    // delete unit
    // ---------------------------------
    @DeleteMapping(path = "/delete/{unitId}")
    public @ResponseBody String deleteUnit(@PathVariable Integer unitId){

        return unitService.deleteUnit(unitId);
    }
}

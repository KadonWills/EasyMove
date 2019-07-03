/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Buses;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import sessions.BusesFacade;

/**
 *
 * @author nkengasong
 */
@Named
@ViewScoped
public class BusesController implements Serializable {
    
    private Buses bus;
    private List<Buses> busList;
    private Integer numOfBuses;

    private Buses selectedBus;
    private List<Buses> filteredBuses;

    private String msg;
    
    @Inject
    private BusesFacade busOperation;
    
    public BusesController(){
        
    }
    
    public void intializeLists() {
        busList.clear();
        busList.addAll(busOperation.findAll());
        numOfBuses = busList.size();
    }

    @PostConstruct
    public void init() {
        busList = new ArrayList<>();
        bus = new Buses();
    }

    /**
     * Saves a bus using the current persistence unit
     */
    public void save() {
        try {
            busOperation.create(bus);
            msg = "Saved Successfully";
        } catch (Exception ex) {
            msg = "Unable to Save the bus";
        }
    }
    
    /**
     * Edits a bus using the current persistence unit
     */
    public void edit() {
        try {
            busOperation.edit(bus);
            msg = "Edited Successfully";
        } catch (Exception ex) {
            msg = "Unable to Edit the bus";
        }
    }

    /**
     * Deletes a bus using the current persistence unit
     */
    public void delete() {
        try {
            busOperation.remove(bus);
            msg = "Deleted Successfully";
        } catch (Exception ex) {
            msg = "Unable to Delete the bus";
        }
    }

    public Buses getBus() {
        return bus;
    }

    public void setBus(Buses bus) {
        this.bus = bus;
    }

    public List<Buses> getBusList() {
        return busList;
    }

    public void setBusList(List<Buses> busList) {
        this.busList = busList;
    }

    public Integer getNumOfBuses() {
        return numOfBuses;
    }

    public void setNumOfBuses(Integer numOfBuses) {
        this.numOfBuses = numOfBuses;
    }

    public Buses getSelectedBus() {
        return selectedBus;
    }

    public void setSelectedBus(Buses selectedBus) {
        this.selectedBus = selectedBus;
    }

    public List<Buses> getFilteredBuses() {
        return filteredBuses;
    }

    public void setFilteredBuses(List<Buses> filteredBuses) {
        this.filteredBuses = filteredBuses;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusesFacade getBusOperation() {
        return busOperation;
    }

    public void setBusOperation(BusesFacade busOperation) {
        this.busOperation = busOperation;
    }
    
    
    
    

}

package controllers;

import entities.Operations;
import entities.Trips;
import entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.component.commandbutton.CommandButton;
import sessions.OperationsFacade;
import sessions.TripsFacade;

/**
 *
 * @author nkengasong
 */
@Named
@ViewScoped
public class TripsController implements Serializable  {
    
    @Inject private TripsFacade tripsFacade;
    @Inject private OperationsFacade operationsFacade;
    private Trips trip;
    List<Trips> trips;
    private String operation;
    private String msg;

    public TripsController() {
        trips = new ArrayList<>();
    }

    @PostConstruct
    public void init() {
        trips.clear();
        trips.addAll(tripsFacade.findAll());
    }
    
    public void saveOperation(String name, String target) {
        try {
            Operations operation = new Operations();
            operation.setOperationsName(name);
            operation.setOperationTarget(target);
            operation.setUsersId((Users) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("currentUser"));
            operationsFacade.create(operation);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public void createTrip() {
        try {
            tripsFacade.create(trip);
            saveOperation("Create new agency", "From " + trip.getDepartAgency() + " to " + trip.getArrivalAgency() + " with id = " + trip.getTripsId());
            msg = "Trip successfully created!";
        } catch (Exception e){
            e.printStackTrace();
            msg = "Trip creation failed!";
        }
    }
    
    public void editTrip() {
        try {
            tripsFacade.edit(trip);
            saveOperation("Edited an existing agency", "From " + trip.getDepartAgency() + " to " + trip.getArrivalAgency() + " with id = " + trip.getTripsId());
            msg = "Trip successfully updated!";
        } catch (Exception e){
            e.printStackTrace();
            msg = "Trip update failed!";
        }
    } 
    
    public void deleteTrip() {
        try {
            tripsFacade.remove(trip);
            saveOperation("Deleted a trip", "From " + trip.getDepartAgency() + " to " + trip.getArrivalAgency() + " with id = " + trip.getTripsId());
            msg = "Trip successfully deleted!";
        } catch (Exception e){
            e.printStackTrace();
            msg = "Trip deletion failed!";
        }
    }

    public void action(ActionEvent e){
        CommandButton button = (CommandButton) e.getSource();
        this.operation = button.getWidgetVar();
        if (operation.equalsIgnoreCase("add")) this.trip = new Trips();
        this.msg = "";
    } 
    
    public void persist() {
        switch (this.operation) {
            case "add":
                createTrip();
                break;
            case "modify":
                editTrip();
                break;
            case "delete":
                deleteTrip();
                break;
        } 
    }
    
    
    /* Getters and Setters */

    public TripsFacade getTripsFacade() {
        return tripsFacade;
    }

    public void setTripsFacade(TripsFacade tripsFacade) {
        this.tripsFacade = tripsFacade;
    }

    public OperationsFacade getOperationsFacade() {
        return operationsFacade;
    }

    public void setOperationsFacade(OperationsFacade operationsFacade) {
        this.operationsFacade = operationsFacade;
    }

    public Trips getTrip() {
        return trip;
    }

    public void setTrip(Trips trip) {
        this.trip = trip;
    }

    public List<Trips> getTrips() {
        return trips;
    }

    public void setTrips(List<Trips> trips) {
        this.trips = trips;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}

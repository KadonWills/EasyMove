package controllers;

import entities.Agencies;
import entities.Operations;
import entities.Trips;
import entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import sessions.AgenciesFacade;
import sessions.OperationsFacade;
import sessions.TripsFacade;
import sessions.UsersFacade;

/**
 *
 * @author nkengasong
 */
@Named
@ViewScoped
public class TripsController implements Serializable {

    @Inject
    private TripsFacade tripsFacade;
    @Inject
    private OperationsFacade operationsFacade;
   @Inject
    private UsersFacade userFacade;
    @Inject
    private AgenciesFacade agenciesFacade;
    private Trips trip;
    List<Trips> trips;
    private String operation;
    private String msg;
    private String arrivalAgency;
    private Boolean disable;

    public TripsController() {
        trips = new ArrayList<>();
        trip = new Trips();
        disable = true; 
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String createTrip() {
        try {
            tripsFacade.create(trip);
            saveOperation("Create new agency", "From " + trip.getDepartAgency() + " to " + trip.getArrivalAgency() + " with id = " + trip.getTripsId());
            msg = "Trip successfully created!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Trip creation failed!";
        } finally {
            return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
        }
    }

    public String editTrip() {
        try {
            trip.setAgenciesId(agenciesFacade.find(Integer.parseInt(arrivalAgency)));
            tripsFacade.edit(trip);
            saveOperation("Edited an existing agency", "From " + trip.getDepartAgency() + " to " + trip.getArrivalAgency() + " with id = " + trip.getTripsId());
            msg = "Trip successfully updated!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Trip update failed!";
        } finally {
            return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
        }
    }

    public String deleteTrip() {
        try {
            tripsFacade.remove(trip);
            saveOperation("Deleted a trip", "From " + trip.getDepartAgency() + " to " + trip.getArrivalAgency() + " with id = " + trip.getTripsId());
            msg = "Trip successfully deleted!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Trip deletion failed!";
        } finally {
            return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
        }
    }

    public void rowSelectionListener(SelectEvent event) {
        this.trip = (Trips) event.getObject();
        setDisable(false);
    }
    
    public List<Agencies> getArrivalAgencies() {
        // set departure agency to agency of current user todo: get user using authenticationController
        // the current user should not be the admin because he/she should be performing day to day task
        Users currentAgent = userFacade.find(2);  
        Agencies agencyOfAgent = currentAgent.getAgenciesId();
        this.trip.setAgenciesId(agencyOfAgent); 
        List<Agencies> arrivals = agenciesFacade.findArrivalAgencies(agencyOfAgent.getAgenciesId());
        return arrivals;
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

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public UsersFacade getUserFacade() {
        return userFacade;
    }

    public void setUserFacade(UsersFacade userFacade) {
        this.userFacade = userFacade;
    }

    public AgenciesFacade getAgenciesFacade() {
        return agenciesFacade;
    }

    public void setAgenciesFacade(AgenciesFacade agenciesFacade) {
        this.agenciesFacade = agenciesFacade;
    }

    public String getArrivalAgency() {
        return arrivalAgency;
    }

    public void setArrivalAgency(String arrivalAgency) {
        this.arrivalAgency = arrivalAgency;
    }

    
}

/*

<!-- Modal: add trip -->
        <div class="modal fade" id="add" tabindex="-1" role="modal" aria-labelledby="Add trip"
             aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <!--Header-->
                    <div class="modal-header">
                        <h4 class="modal-title" id="myModalLabel">Add new trip</h4>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <!--Body-->
                    <h:form class=" form-group">
                        <table class="col table ">
                            <tr>
                                <td>Departure :</td>
                                <td>
                                    <form class="form-inline ">
                                        <div class="md-form my-0 ">
                                            <input class="form-control mr-sm-2 col-md-9" type="datetime-local" value="#{tripsController.trips.departure}"></input> 
                                        </div>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>Arrival :</td>
                                <td>
                                    <div class="md-form my-0 ">
                                        <input class="form-control mr-sm-2 col-md-9" type="datetime-local" value="#{tripsController.trips.arrival}"></input> 
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>Departure agency :</td>
                                <td>
                                    <form class="form-inline ">
                                        <div class="md-form my-0 ">
                                            <!--this should display the agency of the connected agent-->
                                            <p:inputText class="form-control mr-sm-2 col-md-9" value="#{authenticationcontroller.currentAgent.agenciesId.agenciesName}" disabled="true" />
                                        </div>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td>Arrival agency :</td>
                                <td>
                                    <div class="md-form my-0 ">
                                        <!-- list of agencies except that of the user's agency -->
                                        <h:selectOneMenu class="form-control mr-sm-2 col-md-9 mdb-select md-form" id="arrival-agency" value="#{tripsController.trip.ageAgenciesId}">
                                            <f:selectItems var="agency" value="#{tripsController.arrivalAgencies}" itemLabel="#{agency.agenciesName}" itemValue="#{agency}" />
                                        </h:selectOneMenu>
                                    </div>
                                </td>
                            </tr>
                        </table>	  
                        <!--Footer-->
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-primary" data-dismiss="modal">Close</button>
                            <h:commandButton id="addButton" class="btn btn-primary" value="Add Trip" ps:data-dismiss="modal" action="#{tripsController.createTrip()}">
                                <f:ajax execute="@form" render="@form tripsDataTable" />
                            </h:commandButton>
                        </div>	  
                    </h:form>
                </div>
            </div>
        </div>
        <!-- Modal: add trip -->


<tr>
                                <td>Arrival :</td>
                                <td>
                                    <div class="md-form my-0 ">
                                        <input class="form-control mr-sm-2 col-md-9" type="datetime-local" value="#{tripsController.trips.arrival}"></input> 
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>Departure agency :</td>
                                <td>
                                    <div class="md-form my-0 ">
                                        this should display the agency of the connected agent
                                        <p:inputText class="form-control mr-sm-2 col-md-9" value="#{authenticationcontroller.currentAgent.agenciesId.agenciesName }" disabled="true" />
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>Arrival agency :</td>
                                <td>
                                    <div class="md-form my-0 ">
                                         list of agencies except that of the user's agency 
                                        <h:selectOneMenu class="form-control mr-sm-2 col-md-9 mdb-select md-form" id="arrival-agency" value="#{tripsController.trip.ageAgenciesId}">
                                            <f:selectItems var="agency" value="#{tripsController.arrivalAgencies}" itemLabel="#{agency.agenciesName}" itemValue="#{agency}" />
                                        </h:selectOneMenu>
                                    </div>
                                </td>
                            </tr>
*/
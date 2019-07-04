/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Agencies;
import entities.Operations;
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

/**
 *
 * @author nkengasong
 */
@Named
@ViewScoped
public class AgenciesController implements Serializable {

    @Inject
    private AgenciesFacade agenciesFacade;
    @Inject
    private OperationsFacade operationsFacade;
    private Agencies agency;
    List<Agencies> agencies;
    private String operation;
    private String msg;
    private Boolean disable;

    public AgenciesController() {
        agencies = new ArrayList<>();
        agency = new Agencies();
        disable = true;
    }

    @PostConstruct
    public void init() {
        agencies.clear();
        agencies.addAll(agenciesFacade.findAll());
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

    public String createAgency() {
        try {
            agenciesFacade.create(agency);
            saveOperation("Create new agency", agency.getAgenciesName() + " with id = " + agency.getAgenciesId());
            msg = "Agency successfully created!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Agency creation failed!";
        } finally {
            return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
        }
    }

    public String editAgency() {
        try {
            agenciesFacade.edit(agency);
            saveOperation("Edited an existing agency", agency.getAgenciesName() + " with id = " + agency.getAgenciesId());
            msg = "Agency successfully updated!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Agency update failed!";
        } finally {
            return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
        }
    }

    public String deleteAgency() {
        try {
            agenciesFacade.remove(agency);
            saveOperation("Deleted an agency", agency.getAgenciesName() + " with id = " + agency.getAgenciesId());
            msg = "Agency successfully deleted!";
        } catch (Exception e) {
            e.printStackTrace();
            msg = "Agency deletion failed!";
        } finally {
            return FacesContext.getCurrentInstance().getExternalContext().getRequestPathInfo() + "?faces-redirect=true";
        }
    }

    public void rowSelectionListener(SelectEvent event) {
        this.agency = (Agencies) event.getObject();     
        setDisable(false);
    }

    /* Getters and Setters */
    public AgenciesFacade getAgenciesService() {
        return agenciesFacade;
    }

    public void setAgenciesService(AgenciesFacade agenciesService) {
        this.agenciesFacade = agenciesService;
    }

    public Agencies getAgency() {
        return agency;
    }

    public void setAgency(Agencies agency) {
        this.agency = agency;
    }

    public List<Agencies> getAgencies() {
        return agencies;
    }

    public void setAgencies(List<Agencies> agencies) {
        this.agencies = agencies;
    }

    public AgenciesFacade getAgenciesFacade() {
        return agenciesFacade;
    }

    public void setAgenciesFacade(AgenciesFacade agenciesFacade) {
        this.agenciesFacade = agenciesFacade;
    }

    public OperationsFacade getOperationsFacade() {
        return operationsFacade;
    }

    public void setOperationsFacade(OperationsFacade operationsFacade) {
        this.operationsFacade = operationsFacade;
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

}

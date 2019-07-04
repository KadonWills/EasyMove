package controllers;

import entities.Users;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author nkengasong
 */
@Named
@SessionScoped
public class Authenticationcontroller implements Serializable  {

    private Users currentAgent;
    private String msg;
    
    @PostConstruct
    public void init(){
    } 
    
    
    /* Getters and Setters */

    public Users getCurrentAgent() {
        return currentAgent;
    }

    public void setCurrentAgent(Users currentAgent) {
        this.currentAgent = currentAgent;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    } 
}

/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.Mails;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import sessions.MailsFacade;

/**
 *
 * @author nkengasong
 */
@Named
public class MailsController implements Serializable {

    private Mails mail;
    private List<Mails> mailList;
    private Integer numOfMails;

    private Mails selectedMail;
    private List<Mails> filteredMails;

    private String msg;

    @Inject
    private MailsFacade mailOperation;

    public MailsController() {

    }

    public void intializeLists() {
        mailList.clear();
        mailList.addAll(mailOperation.findAll());
        numOfMails = mailList.size();
    }

    @PostConstruct
    public void init() {
        mailList = new ArrayList<>();
        mail = new Mails();
    }

    /**
     * Saves a mail using the current persistence unit
     */
    public void save() {
        try {
            mailOperation.create(mail);
            msg = "Saved Successfully";
        } catch (Exception ex) {
            msg = "Unable to Save the mail";
        }
    }
    /**
     * Changes the state of the mail
     */
    public void changeMailState(){
        
    }
    /**
     * Edits a mail using the current persistence unit
     */
    public void edit() {
        try {
            mailOperation.edit(mail);
            msg = "Edited Successfully";
        } catch (Exception ex) {
            msg = "Unable to Edit the mail";
        }
    }

    /**
     * Deletes a mail using the current persistence unit
     */
    public void delete() {
        try {
            mailOperation.remove(mail);
            msg = "Deleted Successfully";
        } catch (Exception ex) {
            msg = "Unable to Delete the mail";
        }
    }

    public Mails getMail() {
        return mail;
    }

    public void setMail(Mails mail) {
        this.mail = mail;
    }

    public Mails getSelectedMail() {
        return selectedMail;
    }

    public void setSelectedMail(Mails selectedMail) {
        this.selectedMail = selectedMail;
    }

    public List<Mails> getFilteredMails() {
        return filteredMails;
    }

    public void setFilteredMails(List<Mails> filteredMails) {
        this.filteredMails = filteredMails;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Mails> getMailList() {
        return mailList;
    }

    public void setMailList(List<Mails> mailList) {
        this.mailList = mailList;
    }

    public MailsFacade getMailOperation() {
        return mailOperation;
    }

    public void setMailOperation(MailsFacade mailOperation) {
        this.mailOperation = mailOperation;
    }

    public Integer getNumOfMails() {
        return numOfMails;
    }

    public void setNumOfMails(Integer numOfMails) {
        this.numOfMails = numOfMails;
    }

}

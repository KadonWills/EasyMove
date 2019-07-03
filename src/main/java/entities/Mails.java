/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author nkengasong
 */
@Entity
@Table(name = "mails", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "Mails.findAll", query = "SELECT m FROM Mails m"),
    @NamedQuery(name = "Mails.findByMailsId", query = "SELECT m FROM Mails m WHERE m.mailsId = :mailsId"),
    @NamedQuery(name = "Mails.findByMailsType", query = "SELECT m FROM Mails m WHERE m.mailsType = :mailsType"),
    @NamedQuery(name = "Mails.findByReceiverName", query = "SELECT m FROM Mails m WHERE m.receiverName = :receiverName"),
    @NamedQuery(name = "Mails.findByReceiverNumber", query = "SELECT m FROM Mails m WHERE m.receiverNumber = :receiverNumber"),
    @NamedQuery(name = "Mails.findByMailState", query = "SELECT m FROM Mails m WHERE m.mailState = :mailState"),
    @NamedQuery(name = "Mails.findByMailsName", query = "SELECT m FROM Mails m WHERE m.mailsName = :mailsName"),
    @NamedQuery(name = "Mails.findBySenderName", query = "SELECT m FROM Mails m WHERE m.senderName = :senderName"),
    @NamedQuery(name = "Mails.findBySenderNumber", query = "SELECT m FROM Mails m WHERE m.senderNumber = :senderNumber")})
public class Mails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mails_id", nullable = false)
    private Integer mailsId;
    @Size(max = 254)
    @Column(name = "mails_type", length = 254)
    private String mailsType;
    @Size(max = 254)
    @Column(name = "receiver_name", length = 254)
    private String receiverName;
    @Size(max = 254)
    @Column(name = "receiver_number", length = 254)
    private String receiverNumber;
    @Size(max = 254)
    @Column(name = "mail_state", length = 254)
    private String mailState;
    @Size(max = 254)
    @Column(name = "mails_name", length = 254)
    private String mailsName;
    @Size(max = 254)
    @Column(name = "sender_name", length = 254)
    private String senderName;
    @Size(max = 254)
    @Column(name = "sender_number", length = 254)
    private String senderNumber;
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users usersId;
    @JoinColumn(name = "use_users_id", referencedColumnName = "users_id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Users useUsersId;
    @OneToMany(mappedBy = "mailsId", fetch = FetchType.LAZY)
    private Collection<BusTrips> busTripsCollection;

    public Mails() {
    }

    public Mails(Integer mailsId) {
        this.mailsId = mailsId;
    }

    public Integer getMailsId() {
        return mailsId;
    }

    public void setMailsId(Integer mailsId) {
        this.mailsId = mailsId;
    }

    public String getMailsType() {
        return mailsType;
    }

    public void setMailsType(String mailsType) {
        this.mailsType = mailsType;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverNumber() {
        return receiverNumber;
    }

    public void setReceiverNumber(String receiverNumber) {
        this.receiverNumber = receiverNumber;
    }

    public String getMailState() {
        return mailState;
    }

    public void setMailState(String mailState) {
        this.mailState = mailState;
    }

    public String getMailsName() {
        return mailsName;
    }

    public void setMailsName(String mailsName) {
        this.mailsName = mailsName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderNumber() {
        return senderNumber;
    }

    public void setSenderNumber(String senderNumber) {
        this.senderNumber = senderNumber;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    public Users getUseUsersId() {
        return useUsersId;
    }

    public void setUseUsersId(Users useUsersId) {
        this.useUsersId = useUsersId;
    }

    public Collection<BusTrips> getBusTripsCollection() {
        return busTripsCollection;
    }

    public void setBusTripsCollection(Collection<BusTrips> busTripsCollection) {
        this.busTripsCollection = busTripsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mailsId != null ? mailsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mails)) {
            return false;
        }
        Mails other = (Mails) object;
        if ((this.mailsId == null && other.mailsId != null) || (this.mailsId != null && !this.mailsId.equals(other.mailsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Mails[ mailsId=" + mailsId + " ]";
    }
    
}

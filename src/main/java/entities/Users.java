/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "users", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUsersId", query = "SELECT u FROM Users u WHERE u.usersId = :usersId"),
    @NamedQuery(name = "Users.findByFirstName", query = "SELECT u FROM Users u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "Users.findByLastName", query = "SELECT u FROM Users u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "Users.findByLusersOgin", query = "SELECT u FROM Users u WHERE u.lusersOgin = :lusersOgin"),
    @NamedQuery(name = "Users.findByUsersPassword", query = "SELECT u FROM Users u WHERE u.usersPassword = :usersPassword"),
    @NamedQuery(name = "Users.findByUsersRole", query = "SELECT u FROM Users u WHERE u.usersRole = :usersRole"),
    @NamedQuery(name = "Users.findByUsersStatus", query = "SELECT u FROM Users u WHERE u.usersStatus = :usersStatus"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByIdCard", query = "SELECT u FROM Users u WHERE u.idCard = :idCard"),
    @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender"),
    @NamedQuery(name = "Users.findByPhoneNum", query = "SELECT u FROM Users u WHERE u.phoneNum = :phoneNum"),
    @NamedQuery(name = "Users.findByAdresse", query = "SELECT u FROM Users u WHERE u.adresse = :adresse"),
    @NamedQuery(name = "Users.findByPhoto", query = "SELECT u FROM Users u WHERE u.photo = :photo")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "users_id", nullable = false)
    private Integer usersId;
    @Size(max = 254)
    @Column(name = "first_name", length = 254)
    private String firstName;
    @Size(max = 254)
    @Column(name = "last_name", length = 254)
    private String lastName;
    @Size(max = 254)
    @Column(name = "lusers_ogin", length = 254)
    private String lusersOgin;
    @Size(max = 254)
    @Column(name = "users_password", length = 254)
    private String usersPassword;
    @Size(max = 254)
    @Column(name = "users_role", length = 254)
    private String usersRole;
    @Size(max = 254)
    @Column(name = "users_status", length = 254)
    private String usersStatus;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 254)
    @Column(name = "email", length = 254)
    private String email;
    @Size(max = 254)
    @Column(name = "id_card", length = 254)
    private String idCard;
    @Size(max = 254)
    @Column(name = "gender", length = 254)
    private String gender;
    @Size(max = 254)
    @Column(name = "phone_num", length = 254)
    private String phoneNum;
    @Size(max = 254)
    @Column(name = "adresse", length = 254)
    private String adresse;
    @Size(max = 254)
    @Column(name = "photo", length = 254)
    private String photo;
    @ManyToMany(mappedBy = "usersCollection", fetch = FetchType.LAZY)
    private Collection<UsersMenu> usersMenuCollection;
    @OneToMany(mappedBy = "usersId", fetch = FetchType.LAZY)
    private Collection<Mails> mailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "useUsersId", fetch = FetchType.LAZY)
    private Collection<Mails> mailsCollection1;
    @OneToMany(mappedBy = "usersId", fetch = FetchType.LAZY)
    private Collection<Operations> operationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users", fetch = FetchType.LAZY)
    private Collection<Reservations> reservationsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersId", fetch = FetchType.LAZY)
    private Collection<Trips> tripsCollection;
    @JoinColumn(name = "agencies_id", referencedColumnName = "agencies_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Agencies agenciesId;
    @OneToMany(mappedBy = "useUsersId", fetch = FetchType.LAZY)
    private Collection<Users> usersCollection;
    @JoinColumn(name = "use_users_id", referencedColumnName = "users_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users useUsersId;

    public Users() {
    }

    public Users(Integer usersId) {
        this.usersId = usersId;
    }

    public Integer getUsersId() {
        return usersId;
    }

    public void setUsersId(Integer usersId) {
        this.usersId = usersId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLusersOgin() {
        return lusersOgin;
    }

    public void setLusersOgin(String lusersOgin) {
        this.lusersOgin = lusersOgin;
    }

    public String getUsersPassword() {
        return usersPassword;
    }

    public void setUsersPassword(String usersPassword) {
        this.usersPassword = usersPassword;
    }

    public String getUsersRole() {
        return usersRole;
    }

    public void setUsersRole(String usersRole) {
        this.usersRole = usersRole;
    }

    public String getUsersStatus() {
        return usersStatus;
    }

    public void setUsersStatus(String usersStatus) {
        this.usersStatus = usersStatus;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Collection<UsersMenu> getUsersMenuCollection() {
        return usersMenuCollection;
    }

    public void setUsersMenuCollection(Collection<UsersMenu> usersMenuCollection) {
        this.usersMenuCollection = usersMenuCollection;
    }

    public Collection<Mails> getMailsCollection() {
        return mailsCollection;
    }

    public void setMailsCollection(Collection<Mails> mailsCollection) {
        this.mailsCollection = mailsCollection;
    }

    public Collection<Mails> getMailsCollection1() {
        return mailsCollection1;
    }

    public void setMailsCollection1(Collection<Mails> mailsCollection1) {
        this.mailsCollection1 = mailsCollection1;
    }

    public Collection<Operations> getOperationsCollection() {
        return operationsCollection;
    }

    public void setOperationsCollection(Collection<Operations> operationsCollection) {
        this.operationsCollection = operationsCollection;
    }

    public Collection<Reservations> getReservationsCollection() {
        return reservationsCollection;
    }

    public void setReservationsCollection(Collection<Reservations> reservationsCollection) {
        this.reservationsCollection = reservationsCollection;
    }

    public Collection<Trips> getTripsCollection() {
        return tripsCollection;
    }

    public void setTripsCollection(Collection<Trips> tripsCollection) {
        this.tripsCollection = tripsCollection;
    }

    public Agencies getAgenciesId() {
        return agenciesId;
    }

    public void setAgenciesId(Agencies agenciesId) {
        this.agenciesId = agenciesId;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Users getUseUsersId() {
        return useUsersId;
    }

    public void setUseUsersId(Users useUsersId) {
        this.useUsersId = useUsersId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersId != null ? usersId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usersId == null && other.usersId != null) || (this.usersId != null && !this.usersId.equals(other.usersId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Users[ usersId=" + usersId + " ]";
    }
    
}

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
import javax.persistence.JoinTable;
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
@Table(name = "users_menu", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "UsersMenu.findAll", query = "SELECT u FROM UsersMenu u"),
    @NamedQuery(name = "UsersMenu.findByIdmenu", query = "SELECT u FROM UsersMenu u WHERE u.idmenu = :idmenu"),
    @NamedQuery(name = "UsersMenu.findByMenuName", query = "SELECT u FROM UsersMenu u WHERE u.menuName = :menuName"),
    @NamedQuery(name = "UsersMenu.findByMenuKey", query = "SELECT u FROM UsersMenu u WHERE u.menuKey = :menuKey")})
public class UsersMenu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmenu", nullable = false)
    private Integer idmenu;
    @Size(max = 254)
    @Column(name = "menu_name", length = 254)
    private String menuName;
    @Size(max = 254)
    @Column(name = "menu_key", length = 254)
    private String menuKey;
    @JoinTable(name = "priviledges", joinColumns = {
        @JoinColumn(name = "idmenu", referencedColumnName = "idmenu", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "users_id", referencedColumnName = "users_id", nullable = false)})
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Users> usersCollection;
    @OneToMany(mappedBy = "useIdmenu", fetch = FetchType.LAZY)
    private Collection<UsersMenu> usersMenuCollection;
    @JoinColumn(name = "use_idmenu", referencedColumnName = "idmenu")
    @ManyToOne(fetch = FetchType.LAZY)
    private UsersMenu useIdmenu;

    public UsersMenu() {
    }

    public UsersMenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Collection<UsersMenu> getUsersMenuCollection() {
        return usersMenuCollection;
    }

    public void setUsersMenuCollection(Collection<UsersMenu> usersMenuCollection) {
        this.usersMenuCollection = usersMenuCollection;
    }

    public UsersMenu getUseIdmenu() {
        return useIdmenu;
    }

    public void setUseIdmenu(UsersMenu useIdmenu) {
        this.useIdmenu = useIdmenu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmenu != null ? idmenu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersMenu)) {
            return false;
        }
        UsersMenu other = (UsersMenu) object;
        if ((this.idmenu == null && other.idmenu != null) || (this.idmenu != null && !this.idmenu.equals(other.idmenu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UsersMenu[ idmenu=" + idmenu + " ]";
    }
    
}

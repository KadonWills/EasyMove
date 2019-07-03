/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 *
 * @author nkengasong
 */
@Entity
@Table(name = "operations", catalog = "easymove", schema = "")
@NamedQueries({
    @NamedQuery(name = "Operations.findAll", query = "SELECT o FROM Operations o"),
    @NamedQuery(name = "Operations.findByIdOperations", query = "SELECT o FROM Operations o WHERE o.idOperations = :idOperations"),
    @NamedQuery(name = "Operations.findByOperationsName", query = "SELECT o FROM Operations o WHERE o.operationsName = :operationsName"),
    @NamedQuery(name = "Operations.findByOperationTarget", query = "SELECT o FROM Operations o WHERE o.operationTarget = :operationTarget"),
    @NamedQuery(name = "Operations.findByOperationDate", query = "SELECT o FROM Operations o WHERE o.operationDate = :operationDate")})
public class Operations implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_operations", nullable = false)
    private Integer idOperations;
    @Size(max = 254)
    @Column(name = "operations_name", length = 254)
    private String operationsName;
    @Size(max = 254)
    @Column(name = "operation_target", length = 254)
    private String operationTarget;
    @Column(name = "operation_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date operationDate;
    @JoinColumn(name = "users_id", referencedColumnName = "users_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Users usersId;

    public Operations() {
    }

    public Operations(Integer idOperations) {
        this.idOperations = idOperations;
    }

    public Integer getIdOperations() {
        return idOperations;
    }

    public void setIdOperations(Integer idOperations) {
        this.idOperations = idOperations;
    }

    public String getOperationsName() {
        return operationsName;
    }

    public void setOperationsName(String operationsName) {
        this.operationsName = operationsName;
    }

    public String getOperationTarget() {
        return operationTarget;
    }

    public void setOperationTarget(String operationTarget) {
        this.operationTarget = operationTarget;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }

    public Users getUsersId() {
        return usersId;
    }

    public void setUsersId(Users usersId) {
        this.usersId = usersId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOperations != null ? idOperations.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Operations)) {
            return false;
        }
        Operations other = (Operations) object;
        if ((this.idOperations == null && other.idOperations != null) || (this.idOperations != null && !this.idOperations.equals(other.idOperations))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Operations[ idOperations=" + idOperations + " ]";
    }
    
    @PrePersist
    public void prePersist(){
        setOperationDate(new Date());
    }
    
}

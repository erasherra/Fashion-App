/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amir Ingher
 */
@Entity
@Table(name = "auth")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auth.findAll", query = "SELECT a FROM Auth a")
    , @NamedQuery(name = "Auth.findById", query = "SELECT a FROM Auth a WHERE a.id = :id")
    , @NamedQuery(name = "Auth.findPasswordById", query = "SELECT a FROM Auth a WHERE a.user = :user")})
public class Auth implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //@Lob
    //@Size(max = 65535)
    @Column(name = "user")
    private String user;
    //@Lob
    //@Size(max = 65535)
    @Column(name = "password")
    private String password;

    public Auth() {
    }

    public Auth(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auth)) {
            return false;
        }
        Auth other = (Auth) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Auth[ id=" + id + " ]";
    }
    
}

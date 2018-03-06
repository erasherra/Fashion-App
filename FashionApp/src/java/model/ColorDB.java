/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saritakhanal
 */
@Entity
@Table(name = "colorDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColorDB.findAll", query = "SELECT c FROM ColorDB c")
    , @NamedQuery(name = "ColorDB.findByColorID", query = "SELECT c FROM ColorDB c WHERE c.colorID = :colorID")
    , @NamedQuery(name = "ColorDB.findByColorName", query = "SELECT c FROM ColorDB c WHERE c.colorName = :colorName")
    , @NamedQuery(name = "ColorDB.findByColorCode", query = "SELECT c FROM ColorDB c WHERE c.colorCode = :colorCode")})
public class ColorDB implements Serializable {

    @Size(max = 30)
    @Column(name = "colorName")
    private String colorName;
    @Size(max = 30)
    @Column(name = "colorCode")
    private String colorCode;
    @OneToMany(mappedBy = "colorId")
    private Collection<Project> projectCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colorID")
    private Integer colorID;
    @JoinTable(name = "colorHolder", joinColumns = {
        @JoinColumn(name = "colorid", referencedColumnName = "colorID")}, inverseJoinColumns = {
        @JoinColumn(name = "themeID", referencedColumnName = "ID")})
    @ManyToMany
    private Collection<Themes> themesCollection;

    public ColorDB() {
    }

    public ColorDB(Integer colorID) {
        this.colorID = colorID;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }


    @XmlTransient
    public Collection<Themes> getThemesCollection() {
        return themesCollection;
    }

    public void setThemesCollection(Collection<Themes> themesCollection) {
        this.themesCollection = themesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (colorID != null ? colorID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ColorDB)) {
            return false;
        }
        ColorDB other = (ColorDB) object;
        if ((this.colorID == null && other.colorID != null) || (this.colorID != null && !this.colorID.equals(other.colorID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ColorDB[ colorID=" + colorID + " ]";
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    @XmlTransient
    public Collection<Project> getProjectCollection() {
        return projectCollection;
    }

    public void setProjectCollection(Collection<Project> projectCollection) {
        this.projectCollection = projectCollection;
    }
    
}

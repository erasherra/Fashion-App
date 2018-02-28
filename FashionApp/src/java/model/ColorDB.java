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
@Table(name = "colorDB")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColorDB.findAll", query = "SELECT c FROM ColorDB c")
    , @NamedQuery(name = "ColorDB.findByColorID", query = "SELECT c FROM ColorDB c WHERE c.colorID = :colorID")
    , @NamedQuery(name = "ColorDB.findByColorName", query = "SELECT c FROM ColorDB c WHERE c.colorName = :colorName")
    , @NamedQuery(name = "ColorDB.findByColorCode", query = "SELECT c FROM ColorDB c WHERE c.colorCode = :colorCode")})
public class ColorDB implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "colorID")
    private Integer colorID;
    @Size(max = 30)
    @Column(name = "colorName")
    private String colorName;
    @Size(max = 30)
    @Column(name = "colorCode")
    private String colorCode;

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
    
}

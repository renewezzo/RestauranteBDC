/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asi.restaurantbcd.modelo;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author samaelopez
 */
@Entity
@Table(name = "condicionpago")
@NamedQueries({
    @NamedQuery(name = "Condicionpago.findAll", query = "SELECT c FROM Condicionpago c")})
public class Condicionpago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcondicionpago")
    private Integer idcondicionpago;
    @Basic(optional = false)
   
    @Column(name = "condicionpago")
    private String condicionpago;

    public Condicionpago() {
    }

    public Condicionpago(Integer idcondicionpago) {
        this.idcondicionpago = idcondicionpago;
    }

    public Condicionpago(Integer idcondicionpago, String condicionpago) {
        this.idcondicionpago = idcondicionpago;
        this.condicionpago = condicionpago;
    }

    public Integer getIdcondicionpago() {
        return idcondicionpago;
    }

    public void setIdcondicionpago(Integer idcondicionpago) {
        this.idcondicionpago = idcondicionpago;
    }

    public String getCondicionpago() {
        return condicionpago;
    }

    public void setCondicionpago(String condicionpago) {
        this.condicionpago = condicionpago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcondicionpago != null ? idcondicionpago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Condicionpago)) {
            return false;
        }
        Condicionpago other = (Condicionpago) object;
        if ((this.idcondicionpago == null && other.idcondicionpago != null) || (this.idcondicionpago != null && !this.idcondicionpago.equals(other.idcondicionpago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.asi.restaurantbcd.modelo.Condicionpago[ idcondicionpago=" + idcondicionpago + " ]";
    }
    
}

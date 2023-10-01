/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.erp_system.co.db;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author disec
 */
@Entity
@Table(name = "cuenta_cobrar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaCobrar.findAll", query = "SELECT c FROM CuentaCobrar c")
    , @NamedQuery(name = "CuentaCobrar.findById", query = "SELECT c FROM CuentaCobrar c WHERE c.id = :id")
    , @NamedQuery(name = "CuentaCobrar.findByMontoPendiente", query = "SELECT c FROM CuentaCobrar c WHERE c.montoPendiente = :montoPendiente")
    , @NamedQuery(name = "CuentaCobrar.findByMontoTotal", query = "SELECT c FROM CuentaCobrar c WHERE c.montoTotal = :montoTotal")})
public class CuentaCobrar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_pendiente")
    private double montoPendiente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_total")
    private double montoTotal;
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes cliente;
    @JoinColumn(name = "pago", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingresos pago;

    public CuentaCobrar() {
    }

    public CuentaCobrar(Integer id) {
        this.id = id;
    }

    public CuentaCobrar(Integer id, double montoPendiente, double montoTotal) {
        this.id = id;
        this.montoPendiente = montoPendiente;
        this.montoTotal = montoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMontoPendiente() {
        return montoPendiente;
    }

    public void setMontoPendiente(double montoPendiente) {
        this.montoPendiente = montoPendiente;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Ingresos getPago() {
        return pago;
    }

    public void setPago(Ingresos pago) {
        this.pago = pago;
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
        if (!(object instanceof CuentaCobrar)) {
            return false;
        }
        CuentaCobrar other = (CuentaCobrar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.CuentaCobrar[ id=" + id + " ]";
    }
    
}

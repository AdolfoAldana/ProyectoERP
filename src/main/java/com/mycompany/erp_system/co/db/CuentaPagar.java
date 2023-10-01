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
@Table(name = "cuenta_pagar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaPagar.findAll", query = "SELECT c FROM CuentaPagar c")
    , @NamedQuery(name = "CuentaPagar.findById", query = "SELECT c FROM CuentaPagar c WHERE c.id = :id")
    , @NamedQuery(name = "CuentaPagar.findByCuentaContable", query = "SELECT c FROM CuentaPagar c WHERE c.cuentaContable = :cuentaContable")
    , @NamedQuery(name = "CuentaPagar.findByMontoPendiente", query = "SELECT c FROM CuentaPagar c WHERE c.montoPendiente = :montoPendiente")
    , @NamedQuery(name = "CuentaPagar.findByPago", query = "SELECT c FROM CuentaPagar c WHERE c.pago = :pago")
    , @NamedQuery(name = "CuentaPagar.findByMontoTotal", query = "SELECT c FROM CuentaPagar c WHERE c.montoTotal = :montoTotal")})
public class CuentaPagar implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_contable")
    private int cuentaContable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_pendiente")
    private double montoPendiente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "pago")
    private double pago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_total")
    private double montoTotal;
    @JoinColumn(name = "proveedores", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedores proveedores;

    public CuentaPagar() {
    }

    public CuentaPagar(Integer id) {
        this.id = id;
    }

    public CuentaPagar(Integer id, int cuentaContable, double montoPendiente, double pago, double montoTotal) {
        this.id = id;
        this.cuentaContable = cuentaContable;
        this.montoPendiente = montoPendiente;
        this.pago = pago;
        this.montoTotal = montoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(int cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public double getMontoPendiente() {
        return montoPendiente;
    }

    public void setMontoPendiente(double montoPendiente) {
        this.montoPendiente = montoPendiente;
    }

    public double getPago() {
        return pago;
    }

    public void setPago(double pago) {
        this.pago = pago;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
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
        if (!(object instanceof CuentaPagar)) {
            return false;
        }
        CuentaPagar other = (CuentaPagar) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.CuentaPagar[ id=" + id + " ]";
    }
    
}

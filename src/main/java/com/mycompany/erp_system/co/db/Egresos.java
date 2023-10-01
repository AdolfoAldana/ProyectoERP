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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author disec
 */
@Entity
@Table(name = "egresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Egresos.findAll", query = "SELECT e FROM Egresos e")
    , @NamedQuery(name = "Egresos.findById", query = "SELECT e FROM Egresos e WHERE e.id = :id")
    , @NamedQuery(name = "Egresos.findByTipoTransaccion", query = "SELECT e FROM Egresos e WHERE e.tipoTransaccion = :tipoTransaccion")
    , @NamedQuery(name = "Egresos.findByNumeroTransaccion", query = "SELECT e FROM Egresos e WHERE e.numeroTransaccion = :numeroTransaccion")
    , @NamedQuery(name = "Egresos.findByMonto", query = "SELECT e FROM Egresos e WHERE e.monto = :monto")})
public class Egresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo_transaccion")
    private String tipoTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_transaccion")
    private int numeroTransaccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto")
    private double monto;
    @JoinColumn(name = "numero_factura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factura numeroFactura;
    @JoinColumn(name = "proveedor", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedores proveedor;

    public Egresos() {
    }

    public Egresos(Integer id) {
        this.id = id;
    }

    public Egresos(Integer id, String tipoTransaccion, int numeroTransaccion, double monto) {
        this.id = id;
        this.tipoTransaccion = tipoTransaccion;
        this.numeroTransaccion = numeroTransaccion;
        this.monto = monto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public int getNumeroTransaccion() {
        return numeroTransaccion;
    }

    public void setNumeroTransaccion(int numeroTransaccion) {
        this.numeroTransaccion = numeroTransaccion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Factura getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Factura numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public Proveedores getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedores proveedor) {
        this.proveedor = proveedor;
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
        if (!(object instanceof Egresos)) {
            return false;
        }
        Egresos other = (Egresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.Egresos[ id=" + id + " ]";
    }
    
}

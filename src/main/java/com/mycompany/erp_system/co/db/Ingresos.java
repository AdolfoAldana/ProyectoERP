/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.erp_system.co.db;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author disec
 */
@Entity
@Table(name = "ingresos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingresos.findAll", query = "SELECT i FROM Ingresos i")
    , @NamedQuery(name = "Ingresos.findById", query = "SELECT i FROM Ingresos i WHERE i.id = :id")
    , @NamedQuery(name = "Ingresos.findByTipoTransaccion", query = "SELECT i FROM Ingresos i WHERE i.tipoTransaccion = :tipoTransaccion")
    , @NamedQuery(name = "Ingresos.findByNumeroTransaccion", query = "SELECT i FROM Ingresos i WHERE i.numeroTransaccion = :numeroTransaccion")
    , @NamedQuery(name = "Ingresos.findByMonto", query = "SELECT i FROM Ingresos i WHERE i.monto = :monto")})
public class Ingresos implements Serializable {

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
    @JoinColumn(name = "cliente", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes cliente;
    @JoinColumn(name = "numero_factura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factura numeroFactura;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pago")
    private Collection<CuentaCobrar> cuentaCobrarCollection;

    public Ingresos() {
    }

    public Ingresos(Integer id) {
        this.id = id;
    }

    public Ingresos(Integer id, String tipoTransaccion, int numeroTransaccion, double monto) {
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

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Factura getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Factura numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    @XmlTransient
    public Collection<CuentaCobrar> getCuentaCobrarCollection() {
        return cuentaCobrarCollection;
    }

    public void setCuentaCobrarCollection(Collection<CuentaCobrar> cuentaCobrarCollection) {
        this.cuentaCobrarCollection = cuentaCobrarCollection;
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
        if (!(object instanceof Ingresos)) {
            return false;
        }
        Ingresos other = (Ingresos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.Ingresos[ id=" + id + " ]";
    }
    
}

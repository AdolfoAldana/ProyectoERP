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
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findById", query = "SELECT f FROM Factura f WHERE f.id = :id")
    , @NamedQuery(name = "Factura.findByNumeroFactura", query = "SELECT f FROM Factura f WHERE f.numeroFactura = :numeroFactura")
    , @NamedQuery(name = "Factura.findByFechaEmision", query = "SELECT f FROM Factura f WHERE f.fechaEmision = :fechaEmision")
    , @NamedQuery(name = "Factura.findByCuentaContable", query = "SELECT f FROM Factura f WHERE f.cuentaContable = :cuentaContable")
    , @NamedQuery(name = "Factura.findByDetalle", query = "SELECT f FROM Factura f WHERE f.detalle = :detalle")
    , @NamedQuery(name = "Factura.findByCantidad", query = "SELECT f FROM Factura f WHERE f.cantidad = :cantidad")
    , @NamedQuery(name = "Factura.findByMontoUnitario", query = "SELECT f FROM Factura f WHERE f.montoUnitario = :montoUnitario")
    , @NamedQuery(name = "Factura.findByMontoTotal", query = "SELECT f FROM Factura f WHERE f.montoTotal = :montoTotal")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_factura")
    private int numeroFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "fecha_emision")
    private String fechaEmision;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cuenta_contable")
    private int cuentaContable;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "detalle")
    private String detalle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_unitario")
    private double montoUnitario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "monto_total")
    private double montoTotal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroFactura")
    private Collection<Ingresos> ingresosCollection;
    @JoinColumn(name = "clientes", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Clientes clientes;
    @JoinColumn(name = "empleado", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Empleados empleado;
    @JoinColumn(name = "proveedores", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Proveedores proveedores;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroFactura")
    private Collection<Invetario> invetarioCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeroFactura")
    private Collection<Egresos> egresosCollection;

    public Factura() {
    }

    public Factura(Integer id) {
        this.id = id;
    }

    public Factura(Integer id, int numeroFactura, String fechaEmision, int cuentaContable, String detalle, int cantidad, double montoUnitario, double montoTotal) {
        this.id = id;
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.cuentaContable = cuentaContable;
        this.detalle = detalle;
        this.cantidad = cantidad;
        this.montoUnitario = montoUnitario;
        this.montoTotal = montoTotal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getCuentaContable() {
        return cuentaContable;
    }

    public void setCuentaContable(int cuentaContable) {
        this.cuentaContable = cuentaContable;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getMontoUnitario() {
        return montoUnitario;
    }

    public void setMontoUnitario(double montoUnitario) {
        this.montoUnitario = montoUnitario;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    @XmlTransient
    public Collection<Ingresos> getIngresosCollection() {
        return ingresosCollection;
    }

    public void setIngresosCollection(Collection<Ingresos> ingresosCollection) {
        this.ingresosCollection = ingresosCollection;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Empleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleados empleado) {
        this.empleado = empleado;
    }

    public Proveedores getProveedores() {
        return proveedores;
    }

    public void setProveedores(Proveedores proveedores) {
        this.proveedores = proveedores;
    }

    @XmlTransient
    public Collection<Invetario> getInvetarioCollection() {
        return invetarioCollection;
    }

    public void setInvetarioCollection(Collection<Invetario> invetarioCollection) {
        this.invetarioCollection = invetarioCollection;
    }

    @XmlTransient
    public Collection<Egresos> getEgresosCollection() {
        return egresosCollection;
    }

    public void setEgresosCollection(Collection<Egresos> egresosCollection) {
        this.egresosCollection = egresosCollection;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.Factura[ id=" + id + " ]";
    }
    
}

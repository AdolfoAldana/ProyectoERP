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
@Table(name = "proveedores")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedores.findAll", query = "SELECT p FROM Proveedores p")
    , @NamedQuery(name = "Proveedores.findById", query = "SELECT p FROM Proveedores p WHERE p.id = :id")
    , @NamedQuery(name = "Proveedores.findByNit", query = "SELECT p FROM Proveedores p WHERE p.nit = :nit")
    , @NamedQuery(name = "Proveedores.findByNombreFiscal", query = "SELECT p FROM Proveedores p WHERE p.nombreFiscal = :nombreFiscal")
    , @NamedQuery(name = "Proveedores.findByNombreComercial", query = "SELECT p FROM Proveedores p WHERE p.nombreComercial = :nombreComercial")
    , @NamedQuery(name = "Proveedores.findByTiempoCredito", query = "SELECT p FROM Proveedores p WHERE p.tiempoCredito = :tiempoCredito")})
public class Proveedores implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private int nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_fiscal")
    private String nombreFiscal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tiempo_credito")
    private int tiempoCredito;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedores")
    private Collection<CuentaPagar> cuentaPagarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedores")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "proveedor")
    private Collection<Egresos> egresosCollection;

    public Proveedores() {
    }

    public Proveedores(Integer id) {
        this.id = id;
    }

    public Proveedores(Integer id, int nit, String nombreFiscal, String nombreComercial, int tiempoCredito) {
        this.id = id;
        this.nit = nit;
        this.nombreFiscal = nombreFiscal;
        this.nombreComercial = nombreComercial;
        this.tiempoCredito = tiempoCredito;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public String getNombreFiscal() {
        return nombreFiscal;
    }

    public void setNombreFiscal(String nombreFiscal) {
        this.nombreFiscal = nombreFiscal;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public int getTiempoCredito() {
        return tiempoCredito;
    }

    public void setTiempoCredito(int tiempoCredito) {
        this.tiempoCredito = tiempoCredito;
    }

    @XmlTransient
    public Collection<CuentaPagar> getCuentaPagarCollection() {
        return cuentaPagarCollection;
    }

    public void setCuentaPagarCollection(Collection<CuentaPagar> cuentaPagarCollection) {
        this.cuentaPagarCollection = cuentaPagarCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
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
        if (!(object instanceof Proveedores)) {
            return false;
        }
        Proveedores other = (Proveedores) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.Proveedores[ id=" + id + " ]";
    }
    
}

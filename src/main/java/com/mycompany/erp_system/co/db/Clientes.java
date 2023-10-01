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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findById", query = "SELECT c FROM Clientes c WHERE c.id = :id")
    , @NamedQuery(name = "Clientes.findByCodigo", query = "SELECT c FROM Clientes c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Clientes.findByNombreFiscal", query = "SELECT c FROM Clientes c WHERE c.nombreFiscal = :nombreFiscal")
    , @NamedQuery(name = "Clientes.findByNombreComercial", query = "SELECT c FROM Clientes c WHERE c.nombreComercial = :nombreComercial")
    , @NamedQuery(name = "Clientes.findByNit", query = "SELECT c FROM Clientes c WHERE c.nit = :nit")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private int codigo;
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
    @Column(name = "nit")
    private int nit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<Ingresos> ingresosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientes")
    private Collection<Factura> facturaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private Collection<CuentaCobrar> cuentaCobrarCollection;

    public Clientes() {
    }

    public Clientes(Integer id) {
        this.id = id;
    }

    public Clientes(Integer id, int codigo, String nombreFiscal, String nombreComercial, int nit) {
        this.id = id;
        this.codigo = codigo;
        this.nombreFiscal = nombreFiscal;
        this.nombreComercial = nombreComercial;
        this.nit = nit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    @XmlTransient
    public Collection<Ingresos> getIngresosCollection() {
        return ingresosCollection;
    }

    public void setIngresosCollection(Collection<Ingresos> ingresosCollection) {
        this.ingresosCollection = ingresosCollection;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
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
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.Clientes[ id=" + id + " ]";
    }
    
}

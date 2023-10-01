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
@Table(name = "invetario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invetario.findAll", query = "SELECT i FROM Invetario i")
    , @NamedQuery(name = "Invetario.findById", query = "SELECT i FROM Invetario i WHERE i.id = :id")
    , @NamedQuery(name = "Invetario.findByFecha", query = "SELECT i FROM Invetario i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "Invetario.findByUnidadesIngreso", query = "SELECT i FROM Invetario i WHERE i.unidadesIngreso = :unidadesIngreso")
    , @NamedQuery(name = "Invetario.findByMuIngreso", query = "SELECT i FROM Invetario i WHERE i.muIngreso = :muIngreso")
    , @NamedQuery(name = "Invetario.findByMtIngreso", query = "SELECT i FROM Invetario i WHERE i.mtIngreso = :mtIngreso")
    , @NamedQuery(name = "Invetario.findByUnidadesEgreso", query = "SELECT i FROM Invetario i WHERE i.unidadesEgreso = :unidadesEgreso")
    , @NamedQuery(name = "Invetario.findByMuEgreso", query = "SELECT i FROM Invetario i WHERE i.muEgreso = :muEgreso")
    , @NamedQuery(name = "Invetario.findByMtEgreso", query = "SELECT i FROM Invetario i WHERE i.mtEgreso = :mtEgreso")
    , @NamedQuery(name = "Invetario.findByUnidadesExistencias", query = "SELECT i FROM Invetario i WHERE i.unidadesExistencias = :unidadesExistencias")
    , @NamedQuery(name = "Invetario.findByMuExistencias", query = "SELECT i FROM Invetario i WHERE i.muExistencias = :muExistencias")
    , @NamedQuery(name = "Invetario.findByMtExistencias", query = "SELECT i FROM Invetario i WHERE i.mtExistencias = :mtExistencias")})
public class Invetario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "fecha")
    private String fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades_ingreso")
    private int unidadesIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mu_ingreso")
    private double muIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mt_ingreso")
    private double mtIngreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades_egreso")
    private int unidadesEgreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mu_egreso")
    private double muEgreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mt_egreso")
    private double mtEgreso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unidades_existencias")
    private int unidadesExistencias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mu_existencias")
    private int muExistencias;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mt_existencias")
    private int mtExistencias;
    @JoinColumn(name = "numero_factura", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Factura numeroFactura;

    public Invetario() {
    }

    public Invetario(Integer id) {
        this.id = id;
    }

    public Invetario(Integer id, String fecha, int unidadesIngreso, double muIngreso, double mtIngreso, int unidadesEgreso, double muEgreso, double mtEgreso, int unidadesExistencias, int muExistencias, int mtExistencias) {
        this.id = id;
        this.fecha = fecha;
        this.unidadesIngreso = unidadesIngreso;
        this.muIngreso = muIngreso;
        this.mtIngreso = mtIngreso;
        this.unidadesEgreso = unidadesEgreso;
        this.muEgreso = muEgreso;
        this.mtEgreso = mtEgreso;
        this.unidadesExistencias = unidadesExistencias;
        this.muExistencias = muExistencias;
        this.mtExistencias = mtExistencias;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getUnidadesIngreso() {
        return unidadesIngreso;
    }

    public void setUnidadesIngreso(int unidadesIngreso) {
        this.unidadesIngreso = unidadesIngreso;
    }

    public double getMuIngreso() {
        return muIngreso;
    }

    public void setMuIngreso(double muIngreso) {
        this.muIngreso = muIngreso;
    }

    public double getMtIngreso() {
        return mtIngreso;
    }

    public void setMtIngreso(double mtIngreso) {
        this.mtIngreso = mtIngreso;
    }

    public int getUnidadesEgreso() {
        return unidadesEgreso;
    }

    public void setUnidadesEgreso(int unidadesEgreso) {
        this.unidadesEgreso = unidadesEgreso;
    }

    public double getMuEgreso() {
        return muEgreso;
    }

    public void setMuEgreso(double muEgreso) {
        this.muEgreso = muEgreso;
    }

    public double getMtEgreso() {
        return mtEgreso;
    }

    public void setMtEgreso(double mtEgreso) {
        this.mtEgreso = mtEgreso;
    }

    public int getUnidadesExistencias() {
        return unidadesExistencias;
    }

    public void setUnidadesExistencias(int unidadesExistencias) {
        this.unidadesExistencias = unidadesExistencias;
    }

    public int getMuExistencias() {
        return muExistencias;
    }

    public void setMuExistencias(int muExistencias) {
        this.muExistencias = muExistencias;
    }

    public int getMtExistencias() {
        return mtExistencias;
    }

    public void setMtExistencias(int mtExistencias) {
        this.mtExistencias = mtExistencias;
    }

    public Factura getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Factura numeroFactura) {
        this.numeroFactura = numeroFactura;
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
        if (!(object instanceof Invetario)) {
            return false;
        }
        Invetario other = (Invetario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.erp_system.co.db.Invetario[ id=" + id + " ]";
    }
    
}

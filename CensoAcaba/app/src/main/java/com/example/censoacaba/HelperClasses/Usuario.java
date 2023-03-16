package com.example.censoacaba.HelperClasses;

import android.content.Intent;

public class Usuario {

    private Integer id;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String correo;
    private String genero;
    private String telefono;
    private String fechaNacimiento;
    private String tipoDoc;
    private Integer documento;
    private String fechaExpedicion;
    private String departamento;
    private String municipio;
    private String consejo;
    private String comunidad;
    private Integer troncoFamiliar;
    private Integer idFamiliar;
    private String permanenciaTerritorial;
    private String parentesco;
    private String cabezaFamilia;
    private String etnia;
    private String tipoSangre;
    private String nivelEscolar;
    private String discapacidad;
    private String tipoVictima;
    private String eps;
    private Integer status;


    public Usuario() {
        this.id = id;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.correo = correo;
        this.telefono = telefono;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.tipoDoc = tipoDoc;
        this.documento = documento;
        this.fechaExpedicion = fechaExpedicion;
        this.departamento = departamento;
        this.municipio = municipio;
        this.consejo = consejo;
        this.comunidad = comunidad;
        this.troncoFamiliar = troncoFamiliar;
        this.idFamiliar = idFamiliar;
        this.permanenciaTerritorial = permanenciaTerritorial;
        this.parentesco = parentesco;
        this.cabezaFamilia = cabezaFamilia;
        this.etnia = etnia;
        this.tipoSangre = tipoSangre;
        this.nivelEscolar = nivelEscolar;
        this.discapacidad = discapacidad;
        this.tipoVictima = tipoVictima;
        this.eps = eps;
        this.status = status;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTelefono() { return telefono; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoDoc() {
        return tipoDoc;
    }

    public void setTipoDoc(String tipoDoc) {
        this.tipoDoc = tipoDoc;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(String fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getConsejo() {
        return consejo;
    }

    public void setConsejo(String consejo) {
        this.consejo = consejo;
    }

    public String getComunidad() {
        return comunidad;
    }

    public void setComunidad(String comunidad) {
        this.comunidad = comunidad;
    }

    public Integer getTroncoFamiliar() {
        return troncoFamiliar;
    }

    public void setTroncoFamiliar(Integer troncoFamiliar) {
        this.troncoFamiliar = troncoFamiliar;
    }

    public Integer getIdFamiliar() {
        return idFamiliar;
    }

    public void setIdFamiliar(Integer idFamiliar) {
        this.idFamiliar = idFamiliar;
    }

    public String getPermanenciaTerritorial() {
        return permanenciaTerritorial;
    }

    public void setPermanenciaTerritorial(String permanenciaTerritorial) {
        this.permanenciaTerritorial = permanenciaTerritorial;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getCabezaFamilia() {
        return cabezaFamilia;
    }

    public void setCabezaFamilia(String cabezaFamilia) {
        this.cabezaFamilia = cabezaFamilia;
    }

    public String getEtnia() {
        return etnia;
    }

    public void setEtnia(String etnia) {
        this.etnia = etnia;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getNivelEscolar() {
        return nivelEscolar;
    }

    public void setNivelEscolar(String nivelEscolar) {
        this.nivelEscolar = nivelEscolar;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getTipoVictima() {
        return tipoVictima;
    }

    public void setTipoVictima(String tipoVictima) {
        this.tipoVictima = tipoVictima;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }
}

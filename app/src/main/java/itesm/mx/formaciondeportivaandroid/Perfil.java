package itesm.mx.formaciondeportivaandroid;

/*
* Copyright (c) 2016, Instituto Tecnológico y de Estudios Superiores de Monterrey, México. Derechos reservados.
* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
*
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program.  If not, see <http://www.gnu.org/licenses.
*/

public class Perfil {
    private long iId;
    private String sNombre;
    private String sMatricula;
    private String sGenero;
    private String sFechaNacimiento;
    private String sPesoActual;
    private String sPesoMeta;
    private String sPesoMaximoPierna;
    private String sPesoMaximoBrazo;
    private String sGrupoMuscular;
    private String sRepeticion;
    private String sPorcentaje;
    private String sPeso;

    private byte[] sFoto;

    public Perfil(){
        this.iId = -1;
        this.sNombre = null;
        this.sMatricula = null;
        this.sFechaNacimiento = null;
        this.sPesoActual= null;
        this.sPesoMeta= null;
        this.sPesoMaximoPierna= null;
        this.sPesoMaximoBrazo= null;
        this.sGrupoMuscular= null;
        this.sRepeticion= null;
        this.sPorcentaje= null;
        this.sPeso= null;
        this.sFoto = null;
    }

    public Perfil(String sNombre, String sMatricula, String sGenero, String sFechaNacimiento, String sPesoActual, String sPesoMeta, String ssPesoMaximoPierna, String ssPesoMaximoBrazo, String sGrupoMuscular, String sRepeticion,String sPorcentaje, String sPeso, byte[] sFoto){
        this.iId = -1;
        this.sNombre = sNombre;
        this.sMatricula = sMatricula;
        this.sGenero = sGenero;
        this.sFechaNacimiento = sFechaNacimiento;
        this.sPesoActual= sPesoActual;
        this.sPesoMeta= sPesoMeta;
        this.sPesoMaximoPierna= ssPesoMaximoPierna;
        this.sPesoMaximoBrazo= ssPesoMaximoBrazo;
        this.sGrupoMuscular= sGrupoMuscular;
        this.sRepeticion= sRepeticion;
        this.sPorcentaje= sPorcentaje;
        this.sPeso= sPeso;
        this.sFoto = sFoto;
    }

    public Perfil(long iId, String sNombre, String sMatricula, String sGenero, String sFechaNacimiento, String sPesoActual, String sPesoMeta, String ssPesoMaximoPierna, String ssPesoMaximoBrazo, String sGrupoMuscular, String sRepeticion, String sPorcentaje, String sPeso, byte[] sFoto){
        this.iId = iId;
        this.sNombre = sNombre;
        this.sMatricula = sMatricula;
        this.sGenero = sGenero;
        this.sFechaNacimiento = sFechaNacimiento;
        this.sPesoActual= sPesoActual;
        this.sPesoMeta= sPesoMeta;
        this.sPesoMaximoPierna= ssPesoMaximoPierna;
        this.sPesoMaximoBrazo= ssPesoMaximoBrazo;
        this.sGrupoMuscular= sGrupoMuscular;
        this.sRepeticion= sRepeticion;
        this.sPorcentaje= sPorcentaje;
        this.sPeso= sPeso;
        this.sFoto = sFoto;
    }

    public void setId(long iId){
        this.iId = iId;
    }

    public long getId(){
        return this.iId;
    }

    public String getNombre() {
        return sNombre;
    }

    public void setNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getMatricula() {
        return sMatricula;
    }

    public void setMatricula(String sMatricula) {
        this.sMatricula = sMatricula;
    }

    public String getGenero() {
        return sGenero;
    }

    public void setGenero(String sGenero) {
        this.sGenero = sGenero;
    }

    public String getFechaNacimiento() {
        return sFechaNacimiento;
    }

    public void setFechaNacimiento(String sFechaNacimiento) {
        this.sFechaNacimiento = sFechaNacimiento;
    }

    public String getPesoActual() {
        return sPesoActual;
    }

    public void setPesoActual(String sPesoActual) {
        this.sPesoActual = sPesoActual;
    }

    public String getPesoMeta() {
        return sPesoMeta;
    }

    public void setPesoMeta(String sPesoMeta) {
        this.sPesoMeta = sPesoMeta;
    }

    public String getPesoMaximoPierna() {
        return sPesoMaximoPierna;
    }

    public void setPesoMaximoPierna(String ssPesoMaximoPierna) {
        this.sPesoMaximoPierna = ssPesoMaximoPierna;
    }

    public String getPesoMaximoBrazo() {
        return sPesoMaximoBrazo;
    }

    public void setPesoMaximoBrazo(String ssPesoMaximoBrazo) {
        this.sPesoMaximoBrazo = ssPesoMaximoBrazo;
    }

    public String getGrupoMuscular() {
        return sGrupoMuscular;
    }

    public void setGrupoMuscular(String sGrupoMuscular) {
        this.sGrupoMuscular = sGrupoMuscular;
    }

    public String getRepeticion() {
        return sRepeticion;
    }

    public void setRepeticion(String sRepeticion) {
        this.sRepeticion = sRepeticion;
    }

    public String getPorcentaje() {
        return sPorcentaje;
    }

    public void setPorcentaje(String sPorcentaje) {
        this.sPorcentaje = sPorcentaje;
    }

    public String getPeso() {
        return sPeso;
    }

    public void setPeso(String sPeso) {
        this.sPeso = sPeso;
    }

    public byte[] getFoto() {
        return sFoto;
    }

    public void setFoto(byte[] sFoto) {
        this.sFoto = sFoto;
    }

}

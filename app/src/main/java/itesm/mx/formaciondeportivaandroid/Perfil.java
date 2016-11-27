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
    private long id;
    private String nombre;
    private String matricula;
    private String genero;
    private String diaNaciemiento;
    private String mesNaciemiento;
    private String anoNaciemiento;
    private String pesoActual;
    private String pesoMeta;
    private String pesoMaximoPierna;
    private String pesoMaximoBrazo;
    private String grupoMuscular;
    private String repeticion;
    private String porcentaje;
    private String peso;

    private byte[] foto;

    public Perfil(){
        this.id = -1;
        this.nombre = null;
        this.matricula = null;
        this.diaNaciemiento= null;
        this.mesNaciemiento= null;
        this.anoNaciemiento= null;
        this.pesoActual= null;
        this.pesoMeta= null;
        this.pesoMaximoPierna= null;
        this.pesoMaximoBrazo= null;
        this.grupoMuscular= null;
        this.repeticion= null;
        this.porcentaje= null;
        this.peso= null;
        this.foto = null;
    }

    public Perfil(String nombre, String matricula, String genero, String diaNaciemiento, String mesNaciemiento, String anoNaciemiento, String pesoActual, String pesoMeta, String pesoMaximoPierna, String pesoMaximoBrazo, String grupoMuscular, String repeticion,String porcentaje, String peso, byte[] foto){
        this.id = -1;
        this.nombre = nombre;
        this.matricula = matricula;
        this.genero = genero;
        this.diaNaciemiento= diaNaciemiento;
        this.mesNaciemiento= mesNaciemiento;
        this.anoNaciemiento= anoNaciemiento;
        this.pesoActual= pesoActual;
        this.pesoMeta= pesoMeta;
        this.pesoMaximoPierna= pesoMaximoPierna;
        this.pesoMaximoBrazo= pesoMaximoBrazo;
        this.grupoMuscular= grupoMuscular;
        this.repeticion= repeticion;
        this.porcentaje= porcentaje;
        this.peso= peso;
        this.foto = foto;
    }

    public Perfil(long id, String nombre, String matricula, String genero, String diaNaciemiento, String mesNaciemiento, String anoNaciemiento, String pesoActual, String pesoMeta, String pesoMaximoPierna, String pesoMaximoBrazo, String grupoMuscular, String repeticion, String porcentaje, String peso, byte[] foto){
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.genero = genero;
        this.diaNaciemiento= diaNaciemiento;
        this.mesNaciemiento= mesNaciemiento;
        this.anoNaciemiento= anoNaciemiento;
        this.pesoActual= pesoActual;
        this.pesoMeta= pesoMeta;
        this.pesoMaximoPierna= pesoMaximoPierna;
        this.pesoMaximoBrazo= pesoMaximoBrazo;
        this.grupoMuscular= grupoMuscular;
        this.repeticion= repeticion;
        this.porcentaje= porcentaje;
        this.peso= peso;
        this.foto = foto;
    }

    public void setId(long id){
        this.id = id;
    }

    public long getId(){
        return this.id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDiaNaciemiento() {
        return diaNaciemiento;
    }

    public void setDiaNaciemiento(String diaNaciemiento) {
        this.diaNaciemiento = diaNaciemiento;
    }

    public String getMesNaciemiento() {
        return mesNaciemiento;
    }

    public void setMesNaciemiento(String mesNaciemiento) {
        this.mesNaciemiento = mesNaciemiento;
    }

    public String getAnoNaciemiento() {
        return anoNaciemiento;
    }

    public void setAnoNaciemiento(String anoNaciemiento) {
        this.anoNaciemiento = anoNaciemiento;
    }

    public String getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(String pesoActual) {
        this.pesoActual = pesoActual;
    }

    public String getPesoMeta() {
        return pesoMeta;
    }

    public void setPesoMeta(String pesoMeta) {
        this.pesoMeta = pesoMeta;
    }

    public String getPesoMaximoPierna() {
        return pesoMaximoPierna;
    }

    public void setPesoMaximoPierna(String pesoMaximoPierna) {
        this.pesoMaximoPierna = pesoMaximoPierna;
    }

    public String getPesoMaximoBrazo() {
        return pesoMaximoBrazo;
    }

    public void setPesoMaximoBrazo(String pesoMaximoBrazo) {
        this.pesoMaximoBrazo = pesoMaximoBrazo;
    }

    public String getGrupoMuscular() {
        return grupoMuscular;
    }

    public void setGrupoMuscular(String grupoMuscular) {
        this.grupoMuscular = grupoMuscular;
    }

    public String getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

}

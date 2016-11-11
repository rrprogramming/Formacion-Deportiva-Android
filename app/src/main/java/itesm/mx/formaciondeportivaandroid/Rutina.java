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

import android.util.Log;

import java.util.ArrayList;

public class Rutina {
    private  long id;
    private String sNombre;
    private ArrayList<TipoEjercicio> tipoEjercicio;
    private ArrayList<Ejercicio> ejercicio;
    private int idFotoR;

    public Rutina(){
        this.id = -1;
        this.sNombre = null;
        this.ejercicio = null;
        this.idFotoR = -1;
    }

    public Rutina(long id, String sNombre, int idFotoR) {
        this.sNombre = sNombre;
        this.tipoEjercicio = tipoEjercicio;
        this.ejercicio = ejercicio;
        this.idFotoR = idFotoR;
    }

    public Rutina(String sNombre, ArrayList<TipoEjercicio> tipoEjercicio, ArrayList<Ejercicio> ejercicio, int idFotoR) {
        this.sNombre = sNombre;
        this.tipoEjercicio = tipoEjercicio;
        this.ejercicio = ejercicio;
        this.idFotoR = idFotoR;
    }

    public Rutina(long id, String sNombre, ArrayList<TipoEjercicio> tipoEjercicio, ArrayList<Ejercicio> ejercicio, int idFotoR) {
        this.id = id;
        this.sNombre = sNombre;
        this.tipoEjercicio = tipoEjercicio;
        this.ejercicio = ejercicio;
        this.idFotoR = idFotoR;
    }

    public Long getid(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public ArrayList<TipoEjercicio> getTipoEjercicio(){
        return this.tipoEjercicio;
    }

    public void setTipoEjercicio(ArrayList<TipoEjercicio> tipoEjercicio){
        this.tipoEjercicio = tipoEjercicio;
    }

    public ArrayList<Ejercicio> getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(ArrayList<Ejercicio> ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getIdFotoR() {
        return idFotoR;
    }

    public void setIdFotoR(int idFotoR) {
        this.idFotoR = idFotoR;
    }
}
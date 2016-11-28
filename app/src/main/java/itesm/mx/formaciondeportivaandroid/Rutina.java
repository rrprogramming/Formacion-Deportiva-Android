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

import java.util.ArrayList;

public class Rutina {
    private  long iId;
    private String sNombre;
    private ArrayList<Ejercicio> ejercicio;
    private int iIdFotoR;

    public Rutina(){
        this.iId = -1;
        this.sNombre = null;
        this.ejercicio = null;
    }

    public Rutina(long iId, String sNombre, int iIdFotoR) {
        this.iId = iId;
        this.sNombre = sNombre;
        this.iIdFotoR = iIdFotoR;
    }

    public Rutina(String sNombre, ArrayList<Ejercicio> ejercicio,int iIdFotoR) {
        this.iId = -1;
        this.sNombre = sNombre;
        this.ejercicio = ejercicio;
        this.iIdFotoR = iIdFotoR;
    }

    public Rutina(long iId, String sNombre, ArrayList<Ejercicio> ejercicio, int iIdFotoR) {
        this.iId = iId;
        this.sNombre = sNombre;
        this.ejercicio = ejercicio;
        this.iIdFotoR = iIdFotoR;
    }

    public Long getid(){
        return this.iId;
    }

    public void setId(long iId){
        this.iId = iId;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public ArrayList<Ejercicio> getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(ArrayList<Ejercicio> ejercicio) {
        this.ejercicio = ejercicio;
    }

    public int getIdFotoR() {return iIdFotoR;}

    public void setIdFotoR(int iIdFotoR) {this.iIdFotoR = iIdFotoR;}

}
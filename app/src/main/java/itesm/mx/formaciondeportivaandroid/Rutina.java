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
    private String sNombre;
    private ArrayList<Ejercicio> sEjercicio;
    private int idFotoR;

    public Rutina(String sNombre, ArrayList<Ejercicio> sEjercicio, int idFotoR) {
        this.sNombre = sNombre;
        this.sEjercicio = sEjercicio;
        this.idFotoR = idFotoR;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public ArrayList<Ejercicio> getsEjercicio() {
        return sEjercicio;
    }

    public void setsEjercicio(ArrayList<Ejercicio> sEjercicio) {
        this.sEjercicio = sEjercicio;
    }

    public int getIdFotoR() {
        return idFotoR;
    }

    public void setIdFotoR(int idFotoR) {
        this.idFotoR = idFotoR;
    }
}
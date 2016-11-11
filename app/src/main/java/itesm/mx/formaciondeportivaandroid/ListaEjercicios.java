package itesm.mx.formaciondeportivaandroid;

import java.util.ArrayList;

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
public class ListaEjercicios {

    public ArrayList<Ejercicio> getLista(){
        ArrayList<Ejercicio> ejercicioArrayList = new ArrayList<>();
        Ejercicio ejercicio;

        ejercicio = new Ejercicio(0, "Ejemplo 1", "Ejemplo", 0, 0, 0);
        ejercicioArrayList.add(ejercicio);

        ejercicio = new Ejercicio(1, "Ejemplo 2", "Ejemplo", 0, 0, 0);
        ejercicioArrayList.add(ejercicio);

        ejercicio = new Ejercicio(2, "Ejemplo 3", "Ejemplo", 0, 0, 0);
        ejercicioArrayList.add(ejercicio);

        ejercicio = new Ejercicio(3, "Ejemplo 4", "Ejemplo", 0, 0, 0);
        ejercicioArrayList.add(ejercicio);

        ejercicio = new Ejercicio(4, "Ejemplo 5", "Ejemplo", 0, 0, 0);
        ejercicioArrayList.add(ejercicio);

        return ejercicioArrayList;
    }

}

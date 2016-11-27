package itesm.mx.formaciondeportivaandroid;

import android.provider.BaseColumns;

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
public class DatabaseSchema {
    private DatabaseSchema(){}

    public static class RutinaTable implements BaseColumns {
        public static final String TABLE_NAME = "RutinaTable";
        public static final String COLUNM_NAME_ID = "idRutina";
        public static final String COLUNM_NAME_NOMBRE = "nombreRutina";
        public static final String COLUMN_NAME_FOTO = "idFoto";
    }

    public static class EjercicioTable implements BaseColumns {
        public static final String TABLE_NAME = "EjerciciosTable";
        public static final String COLUNM_NAME_ID = "idEjercicio";
        public static final String COLUNM_NAME_ID_RUTINA = "idRutina";
        public static final String COLUNM_NAME_NOMBRE = "nombreEjercicio";
        public static final String COLUMN_NAME_TIPO_EJERCICIO = "tipoEjercicio";
        public static final String COLUMN_NAME_MUSCULO = "musculo";
        public static final String COLUMN_NAME_SERIES = "series";
        public static final String COLUMN_NAME_REPETICIONES = "repeticiones";
        public static final String COLUMN_NAME_FOTO = "idFoto";
        public static final String COLUMN_NAME_FIN = "fechaFin";
    }

    public static class HistorialTable implements BaseColumns {
        public static final String TABLE_NAME = "HistorialTable";
        public static final String COLUMN_NAME_ID = "idHistorial";
        public static final String COLUMN_NAME_EJERCICIO_ID = "EjercicioId";
        public static final String COLUMN_NAME_FIN = "fechaFin";
    }

    public static class PerfilTable implements BaseColumns {
        public static final String TABLE_NAME = "PerfilTable";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_MATRICULA = "matricula";
        public static final String COLUMN_NAME_GENERO = "genero";
        public static final String COLUMN_NAME_DIA_NACIMEINTO = "diaNacimiento";
        public static final String COLUMN_NAME_MES_NACIMIENTO = "mesNacimiento";
        public static final String COLUMN_NAME_ANO_NACIMIENTO = "anoNacimiento";
        public static final String COLUMN_NAME_PESO_ACTUAL = "pesoActual";
        public static final String COLUMN_NAME_PESO_META = "pesoMeta";
        public static final String COLUMN_NAME_PESO_MAXIMO_PIERNA = "pesoMaximoPierna";
        public static final String COLUMN_NAME_PESO_MAXIMO_BRAZO = "pesoMaximoBrao";
        public static final String COLUMN_NAME_GRUPO_MUSCULAR = "grupoMuscular";
        public static final String COLUMN_NAME_REPETICION = "repeticion";
        public static final String COLUMN_NAME_PESO = "peso";
        public static final String COLUMN_NAME_PORCENTAJE = "porcentaje";
        public static final String COLUMN_NAME_IMAGEN = "imagen";
    }
}

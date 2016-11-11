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

    public static class RelationTable implements BaseColumns {
        public static final String TABLE_NAME = "RelationTable";
        public static final String COLUNM_NAME_ID = "idRelation";
        public static final String COLUNM_NAME_RUTINA = "idRutina";
        public static final String COLUMN_NAME_EJERCICIO = "idEjercicio";
    }

    public static class TypeTable implements BaseColumns {
        public static final String TABLE_NAME = "TypeTable";
        public static final String COLUNM_NAME_ID = "idType";
        public static final String COLUNM_NAME_RUTINA = "idRutina";
        public static final String COLUMN_NAME_TYPE = "idType";
    }
}

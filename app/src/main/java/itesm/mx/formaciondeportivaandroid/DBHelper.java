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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TecDeportes.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_RUTINA_TABLE = "CREATE TABLE "+
                DatabaseSchema.RutinaTable.TABLE_NAME+
                "("+
                DatabaseSchema.RutinaTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.RutinaTable.COLUNM_NAME_NOMBRE+" TEXT, "+
                DatabaseSchema.RutinaTable.COLUMN_NAME_FOTO+" INTEGER "+
                ")";
        db.execSQL(CREATE_RUTINA_TABLE);

        String CREATE_EJERCICIO_TABLE = "CREATE TABLE "+
                DatabaseSchema.EjercicioTable.TABLE_NAME+
                "("+
                DatabaseSchema.EjercicioTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.EjercicioTable.COLUNM_NAME_ID_RUTINA+" INTEGER, "+
                DatabaseSchema.EjercicioTable.COLUNM_NAME_NOMBRE+" TEXT, "+
                DatabaseSchema.EjercicioTable.COLUMN_NAME_TIPO_EJERCICIO+" TEXT, "+
                DatabaseSchema.EjercicioTable.COLUMN_NAME_MUSCULO+" TEXT, "+
                DatabaseSchema.EjercicioTable.COLUMN_NAME_SERIES+" INTEGER, "+
                DatabaseSchema.EjercicioTable.COLUMN_NAME_REPETICIONES+" INTEGER, "+
                DatabaseSchema.EjercicioTable.COLUMN_NAME_FOTO+" INTEGER, "+
                DatabaseSchema.EjercicioTable.COLUMN_NAME_FIN+" DATETIME "+
                ")";
        db.execSQL(CREATE_EJERCICIO_TABLE);

        String CREATE_HISTORIAL_TABLE = "CREATE TABLE "+
                DatabaseSchema.HistorialTable.TABLE_NAME+
                "("+
                DatabaseSchema.HistorialTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.HistorialTable.COLUMN_NAME_EJERCICIO_ID+" INTEGER, "+
                DatabaseSchema.HistorialTable.COLUMN_NAME_FIN+" DATETIME "+
                ")";
        db.execSQL(CREATE_HISTORIAL_TABLE);

        String CREATE_PERFIL_TABLE = "CREATE TABLE "+
                DatabaseSchema.PerfilTable.TABLE_NAME+
                "("+
                DatabaseSchema.PerfilTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_NOMBRE+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_MATRICULA+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_GENERO+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_FECHANAC+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_ACTUAL+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_META+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_MAXIMO_PIERNA+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_MAXIMO_BRAZO+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_GRUPO_MUSCULAR+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_REPETICION+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_PESO+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_PORCENTAJE+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_IMAGEN+" BLOB "+
                ")";
        db.execSQL(CREATE_PERFIL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String DELETE_RUTINA_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.RutinaTable.TABLE_NAME;
        db.execSQL(DELETE_RUTINA_TABLE);
        onCreate(db);

        String DELETE_EJERCICIO_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.EjercicioTable.TABLE_NAME;
        db.execSQL(DELETE_EJERCICIO_TABLE);
        onCreate(db);

        String DELETE_HISTORIAL_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.HistorialTable.TABLE_NAME;
        db.execSQL(DELETE_HISTORIAL_TABLE);
        onCreate(db);

        String DELETE_PERFIL_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.PerfilTable.TABLE_NAME;
        db.execSQL(DELETE_PERFIL_TABLE);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
}

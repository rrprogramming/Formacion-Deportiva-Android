package itesm.mx.formaciondeportivaandroid;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

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
public class DBOperations {

    ListaEjercicios lista;
    ListaTipoEjercicios listaTipoEjercicios;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private ArrayList<Ejercicio> ejercicioArrayList = lista.getLista();
    private ArrayList<TipoEjercicio> tipoEjercicioArrayList = listaTipoEjercicios.getLista();

    public DBOperations(Context context){
        dbHelper = new DBHelper(context);
    }

    public void open(){
        try {
            db = dbHelper.getWritableDatabase();
        }catch (SQLException e){
            Log.e("SQLOPEN", e.toString());
        }
    }

    public long addRutina(Rutina rutina){
        long newRowId = 0;
        try {

            ContentValues values = new ContentValues();
            values.put(DatabaseSchema.RutinaTable.COLUNM_NAME_NOMBRE, rutina.getsNombre());
            values.put(DatabaseSchema.RutinaTable.COLUMN_NAME_FOTO, rutina.getIdFotoR());

            newRowId = db.insert(DatabaseSchema.RutinaTable.TABLE_NAME, null, values);

            values.clear();

            for (int i = 0; i < rutina.getEjercicio().size(); i++){
                values = new ContentValues();
                values.put(DatabaseSchema.RelationTable.COLUNM_NAME_RUTINA, rutina.getid());
                values.put(DatabaseSchema.RelationTable.COLUMN_NAME_EJERCICIO, rutina.getEjercicio().get(i).getId());

                long relationId = db.insert(DatabaseSchema.RelationTable.TABLE_NAME, null, values);
            }

        }catch (SQLException e){
            Log.e("SQLADD",e.toString());
        }

        return newRowId;
    }

    public Rutina getRutina(long id){
        Rutina rutina = new Rutina();
        ArrayList<Ejercicio> listEjercicio = new ArrayList<>();
        ArrayList<TipoEjercicio> listTipoEjercicio = new ArrayList<>();

        String query = "Select * FROM "+
                DatabaseSchema.RutinaTable.TABLE_NAME+
                " WHERE "+DatabaseSchema.RutinaTable._ID+
                " = \""+id+"\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            rutina = null;
            if(cursor.moveToFirst()){
                rutina = new Rutina(Integer.parseInt(cursor.getString(0)),
                        cursor.getString(1),
                        Integer.parseInt(cursor.getString(2)));
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("SQL Get", e.toString());
        }

        query = "Select * FROM "+
                DatabaseSchema.RelationTable.TABLE_NAME+
                " WHERE "+DatabaseSchema.RelationTable.COLUNM_NAME_RUTINA+
                " = \""+rutina.getid()+"\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()){
                do{
                    int eId = Integer.parseInt(cursor.getString(0));
                    listEjercicio.add(ejercicioArrayList.get(eId));
                }while (cursor.moveToNext());
            }
        }catch (SQLException e){
            Log.e("SQL Get",e.toString());
        }

        rutina.setEjercicio(listEjercicio);

        query = "Select * FROM "+
                DatabaseSchema.TypeTable.TABLE_NAME+
                " WHERE "+DatabaseSchema.TypeTable.COLUNM_NAME_RUTINA+
                " = \""+rutina.getid()+"\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            if (cursor.moveToFirst()){
                do{
                    int eId = Integer.parseInt(cursor.getString(0));
                    listTipoEjercicio.add(tipoEjercicioArrayList.get(eId));
                }while (cursor.moveToNext());
            }
        }catch (SQLException e){
            Log.e("SQL Get",e.toString());
        }

        rutina.setTipoEjercicio(listTipoEjercicio);

        return rutina;
    }

    public ArrayList<Rutina> getAllRutinas(){
        Rutina rutina;
        ArrayList<Rutina> rutinaArrayList = new ArrayList<>();
        ArrayList<Ejercicio> listEjercicio = new ArrayList<>();
        ArrayList<TipoEjercicio> listTipoEjercicio = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+DatabaseSchema.RutinaTable.TABLE_NAME;

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()) {
                do {
                    rutina = new Rutina(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            Integer.parseInt(cursor.getString(2)));

                    String query = "Select * FROM "+
                            DatabaseSchema.RelationTable.TABLE_NAME+
                            " WHERE "+DatabaseSchema.RelationTable.COLUNM_NAME_RUTINA+
                            " = \""+rutina.getid()+"\"";

                    try {
                        Cursor cursor2 = db.rawQuery(query, null);
                        if (cursor2.moveToFirst()){
                            do{
                                int eId = Integer.parseInt(cursor2.getString(0));
                                listEjercicio.add(ejercicioArrayList.get(eId));
                            }while (cursor2.moveToNext());
                        }
                    }catch (SQLException e){
                        Log.e("SQL Get",e.toString());
                    }

                    rutina.setEjercicio(listEjercicio);

                    query = "Select * FROM "+
                            DatabaseSchema.TypeTable.TABLE_NAME+
                            " WHERE "+DatabaseSchema.TypeTable.COLUNM_NAME_RUTINA+
                            " = \""+rutina.getid()+"\"";

                    try {
                        Cursor cursor2 = db.rawQuery(query, null);
                        if (cursor2.moveToFirst()){
                            do{
                                int eId = Integer.parseInt(cursor2.getString(0));
                                listTipoEjercicio.add(tipoEjercicioArrayList.get(eId));
                            }while (cursor2.moveToNext());
                        }
                    }catch (SQLException e){
                        Log.e("SQL Get",e.toString());
                    }

                    rutina.setTipoEjercicio(listTipoEjercicio);

                    rutinaArrayList.add(rutina);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("SQL Get", e.toString());
        }

        return rutinaArrayList;
    }
}

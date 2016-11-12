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

    ListaTipoEjercicios listaTipoEjercicios;

    private SQLiteDatabase db;
    private DBHelper dbHelper;
    private ArrayList<Ejercicio> ejercicioArrayList;
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

    //Esta clase recive un objeto de tipo Rutina para ingresarlo a la base de datos y regresar si id (AUTOINCREMENT)
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

            values.clear();

            for (int i = 0; i < rutina.getTipoEjercicio().size(); i++){
                values = new ContentValues();
                values.put(DatabaseSchema.TypeTable.COLUNM_NAME_RUTINA, rutina.getid());
                values.put(DatabaseSchema.TypeTable.COLUMN_NAME_TYPE, rutina.getTipoEjercicio().get(i).getId());

                long relationId = db.insert(DatabaseSchema.TypeTable.TABLE_NAME, null, values);
            }

            values.clear();

        }catch (SQLException e){
            Log.e("SQLADD",e.toString());
        }

        return newRowId;
    }

    //Esta clase recive el id de Rutina para regresar un objeto de tipo Rutina
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

    //Esta clase regresa un arreglo de objetos de tipo Rutina
    public ArrayList<Rutina> getAllRutinas(){
        Rutina rutina;
        Ejercicio ejercicio = new Ejercicio();
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

                                String subQuery = "Select * FROM "+
                                        DatabaseSchema.RelationTable.TABLE_NAME+
                                        " WHERE "+DatabaseSchema.RelationTable.COLUNM_NAME_RUTINA+
                                        " = \""+rutina.getid()+"\"";

                                try {
                                    Cursor subCursor = db.rawQuery(subQuery, null);
                                    if (subCursor.moveToFirst()){
                                        do{
                                            ejercicio = new Ejercicio(Integer.parseInt(subCursor.getString(0)),
                                                    subCursor.getString(1),
                                                    subCursor.getString(2),
                                                    subCursor.getString(3),
                                                    Integer.parseInt(subCursor.getString(4)),
                                                    Integer.parseInt(subCursor.getString(5)),
                                                    Integer.parseInt(subCursor.getString(6)),
                                                    subCursor.getString(7));
                                        }while (subCursor.moveToNext());
                                    }
                                }catch (SQLException e){
                                    Log.e("SQL Get",e.toString());
                                }

                                listEjercicio.add(ejercicio);
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

    //Esta clase recive un rango de fechas en formato 'YYYY-MM-DD' para regresar un objeto de tipo Ejercicio (ejercicio contiene el id de la Rutina a la que pertenece
    public ArrayList<Ejercicio> getHistorial(String fechaInicio, String fechaFinal){
        Ejercicio ejercicio;
        ArrayList<Ejercicio> listEjercicio = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+DatabaseSchema.EjercicioTable.TABLE_NAME+
                            " WHERE "+DatabaseSchema.EjercicioTable.COLUMN_NAME_FIN+
                            " >= "+'\''+fechaInicio+'\''+" AND"+" <= "+'\''+fechaFinal+'\'';

        Log.i("QUERY: ", selectQuery);

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()) {
                do{
                    ejercicio = new Ejercicio(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            Integer.parseInt(cursor.getString(4)),
                            Integer.parseInt(cursor.getString(5)),
                            Integer.parseInt(cursor.getString(6)),
                            cursor.getString(7));

                    listEjercicio.add(ejercicio);
                }while (cursor.moveToNext());
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("SQL Get", e.toString());
        }

        return listEjercicio;
    }

}

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

    private SQLiteDatabase db;
    private DBHelper dbHelper;

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

    public void close(){
        db.close();
    }

    //Esta clase recive un objeto de tipo Rutina para ingresarlo a la base de datos y regresar si id (AUTOINCREMENT)
    public long addRutina(Rutina rutina){
        long newRowId = 0;
        try {

            ContentValues values = new ContentValues();
            values.put(DatabaseSchema.RutinaTable.COLUNM_NAME_NOMBRE, rutina.getsNombre());
            values.put(DatabaseSchema.RutinaTable.COLUMN_NAME_FOTO, rutina.getIdFotoR());

            newRowId = db.insert(DatabaseSchema.RutinaTable.TABLE_NAME, null, values);

            for (int i = 0; i < rutina.getEjercicio().size(); i++){
                Log.i("EJERCICIO", "Guardando ejercicio "+rutina.getEjercicio().get(i).getsNombreEjer()+" / "+newRowId);
                ContentValues values2 = new ContentValues();
                values2.put(DatabaseSchema.EjercicioTable.COLUNM_NAME_ID_RUTINA, newRowId);
                values2.put(DatabaseSchema.EjercicioTable.COLUNM_NAME_NOMBRE, rutina.getEjercicio().get(i).getsNombreEjer());
                values2.put(DatabaseSchema.EjercicioTable.COLUMN_NAME_TIPO_EJERCICIO, rutina.getEjercicio().get(i).getsNombreEjer());
                values2.put(DatabaseSchema.EjercicioTable.COLUMN_NAME_MUSCULO, rutina.getEjercicio().get(i).getsMusculo());
                values2.put(DatabaseSchema.EjercicioTable.COLUMN_NAME_SERIES, rutina.getEjercicio().get(i).getiSeries());
                values2.put(DatabaseSchema.EjercicioTable.COLUMN_NAME_REPETICIONES, rutina.getEjercicio().get(i).getiRepeticiones());
                values2.put(DatabaseSchema.EjercicioTable.COLUMN_NAME_FOTO, rutina.getEjercicio().get(i).getIdFotoE());
                values2.put(DatabaseSchema.EjercicioTable.COLUMN_NAME_FIN, rutina.getEjercicio().get(i).getDiaFin());

                long ejercicioId = db.insert(DatabaseSchema.EjercicioTable.TABLE_NAME, null, values2);
            }

        }catch (SQLException e){
            Log.e("SQLADD",e.toString());
        }

        return newRowId;
    }

    public long addPerfil(Perfil perfil){
        long newRowId = perfil.getId();

        if(perfil.getId()<0) {
            try {

                ContentValues values = new ContentValues();
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_NOMBRE, perfil.getNombre());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_MATRICULA,perfil.getMatricula());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_GENERO,perfil.getGenero());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_DIA_NACIMEINTO, perfil.getDiaNaciemiento());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_MES_NACIMIENTO, perfil.getMesNaciemiento());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_ANO_NACIMIENTO, perfil.getAnoNaciemiento());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_ACTUAL, perfil.getPesoActual());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_META, perfil.getPesoMeta());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_MAXIMO_PIERNA, perfil.getPesoMaximoPierna());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_MAXIMO_BRAZO, perfil.getPesoMaximoBrazo());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_GRUPO_MUSCULAR, perfil.getGrupoMuscular());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_REPETICION,perfil.getRepeticion());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_PESO, perfil.getPeso());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_PORCENTAJE, perfil.getPorcentaje());
                values.put(DatabaseSchema.PerfilTable.COLUMN_NAME_IMAGEN, perfil.getFoto());

                newRowId = db.insert(DatabaseSchema.PerfilTable.TABLE_NAME, null, values);

            } catch (SQLException e) {
                Log.e("SQLADD", e.toString());
            }
        }else {
            String query = "UPDATE "+DatabaseSchema.PerfilTable.TABLE_NAME+
                    " SET "+ DatabaseSchema.PerfilTable.COLUMN_NAME_NOMBRE +"="+"\'"+perfil.getNombre()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_MATRICULA +"="+"\'"+perfil.getMatricula()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_GENERO +"="+"\'"+perfil.getGenero()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_DIA_NACIMEINTO +"="+"\'"+perfil.getDiaNaciemiento()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_MES_NACIMIENTO +"="+"\'"+perfil.getMesNaciemiento()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_ANO_NACIMIENTO +"="+"\'"+perfil.getAnoNaciemiento()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_ACTUAL +"="+"\'"+perfil.getPesoActual()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_META +"="+"\'"+perfil.getPesoMeta()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_MAXIMO_PIERNA +"="+"\'"+perfil.getPesoMaximoPierna()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_PESO_MAXIMO_BRAZO +"="+"\'"+perfil.getPesoMaximoBrazo()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_GRUPO_MUSCULAR +"="+"\'"+perfil.getGrupoMuscular()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_REPETICION +"="+"\'"+perfil.getRepeticion()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_PESO +"="+"\'"+perfil.getPeso()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_PORCENTAJE +"="+"\'"+perfil.getPorcentaje()+"\'"+","+
                    DatabaseSchema.PerfilTable.COLUMN_NAME_IMAGEN +"="+"\'"+(byte[]) perfil.getFoto()+"\'"+" "+
                    "WHERE "+DatabaseSchema.PerfilTable._ID+"="+"\'"+perfil.getId()+"\'";

            db.execSQL(query);
        }
        return newRowId;
    }

    public Perfil getPerfil(long id){
        Perfil perfil = new Perfil();

        String query = "Select * FROM "+
                DatabaseSchema.PerfilTable.TABLE_NAME+
                " WHERE "+DatabaseSchema.PerfilTable._ID+
                " = \""+id+"\"";
        try {
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                perfil = new Perfil(Long.parseLong(cursor.getString(0)),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        cursor.getString(7),
                        cursor.getString(8),
                        cursor.getString(9),
                        cursor.getString(10),
                        cursor.getString(11),
                        cursor.getString(12),
                        cursor.getString(13),
                        cursor.getString(14),
                        cursor.getBlob(15));
            }
        }catch (SQLException e){
            Log.e("GET PERFIL", e.toString());
        }

        return perfil;
    }

    //Esta clase recive el id de Rutina para regresar un objeto de tipo Rutina
    public Rutina getRutina(long id){
        Rutina rutina = new Rutina();
        ArrayList<Ejercicio> listEjercicio = new ArrayList<>();

        Log.i("GET RUTINA","id "+id);

        String query = "Select * FROM "+
                DatabaseSchema.RutinaTable.TABLE_NAME+
                " WHERE "+DatabaseSchema.RutinaTable._ID+
                " = \""+id+"\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()){
                rutina = new Rutina(Long.parseLong(cursor.getString(0)),
                        cursor.getString(1),
                        Integer.parseInt(cursor.getString(2)));
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("SQL Get", e.toString());
        }

        //Obtiene la lista de ejerccios relacionada con las Rutinas
        query = "Select * FROM "+
                DatabaseSchema.EjercicioTable.TABLE_NAME+
                " WHERE "+DatabaseSchema.EjercicioTable.COLUNM_NAME_ID_RUTINA+
                " = \""+id+"\"";

        try {
            Cursor cursor = db.rawQuery(query, null);
            Log.i("EJERCICIO", "entering...");
            if (cursor.moveToFirst()){
                do{
                    Ejercicio ejercicio = new Ejercicio(Integer.parseInt(cursor.getString(0)),
                            Integer.parseInt(cursor.getString(1)),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            Integer.parseInt(cursor.getString(5)),
                            Integer.parseInt(cursor.getString(6)),
                            Integer.parseInt(cursor.getString(7)),
                            cursor.getString(8));

                    listEjercicio.add(ejercicio);

                    Log.i("EJERCICIO", listEjercicio.get(0).getsNombreEjer());
                }while (cursor.moveToNext());
            }
        }catch (SQLException e){
            Log.e("SQL Get",e.toString());
        }

        if(!listEjercicio.isEmpty()) {
            rutina.setEjercicio(listEjercicio);
        }

        return rutina;
    }

    //Esta clase regresa un arreglo de objetos de tipo Rutina
    public ArrayList<Rutina> getAllRutinas(){
        Rutina rutina;
        Ejercicio ejercicio;
        ArrayList<Rutina> rutinaArrayList = new ArrayList<>();
        ArrayList<Ejercicio> listEjercicio = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+DatabaseSchema.RutinaTable.TABLE_NAME;

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()) {
                do {
                    rutina = new Rutina(Long.parseLong(cursor.getString(0)),
                            cursor.getString(1),
                            Integer.parseInt(cursor.getString(2)));

                    Log.i("RUTINA ID", Long.toString(rutina.getid()));

                    String query = "Select * FROM "+
                            DatabaseSchema.EjercicioTable.TABLE_NAME+
                            " WHERE "+DatabaseSchema.EjercicioTable.COLUNM_NAME_ID_RUTINA+
                            " = \""+rutina.getid()+"\"";

                    try {
                        Cursor cursor2 = db.rawQuery(query, null);
                        if (cursor2.moveToFirst()){
                            do{

                                ejercicio = new Ejercicio(Integer.parseInt(cursor2.getString(0)),
                                        Integer.parseInt(cursor2.getString(1)),
                                        cursor2.getString(2),
                                        cursor2.getString(3),
                                        cursor2.getString(4),
                                        Integer.parseInt(cursor2.getString(5)),
                                        Integer.parseInt(cursor2.getString(6)),
                                        Integer.parseInt(cursor2.getString(7)),
                                        cursor2.getString(8));

                                listEjercicio.add(ejercicio);
                            }while (cursor2.moveToNext());
                        }
                    }catch (SQLException e){
                        Log.e("SQL Get",e.toString());
                    }

                    rutina.setEjercicio(listEjercicio);

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

        String selectQuery = "SELECT * FROM "+DatabaseSchema.HistorialTable.TABLE_NAME+
                            " WHERE "+DatabaseSchema.HistorialTable.COLUMN_NAME_FIN+
                            " BETWEEN "+'\''+fechaInicio+'\''+" AND "+'\''+fechaFinal+'\'';

        Log.i("QUERY: ", selectQuery);

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()) {
                do{

                    int id = Integer.parseInt(cursor.getString(1));

                    String ejercicioQuery = "SELECT * FROM "+DatabaseSchema.EjercicioTable.TABLE_NAME+
                            " WHERE "+DatabaseSchema.EjercicioTable._ID+
                            " = "+'\''+id+'\'';

                    try {
                        Cursor cursor2 = db.rawQuery(ejercicioQuery, null);
                        if (cursor2.moveToFirst()) {
                            do {

                                ejercicio = new Ejercicio(Integer.parseInt(cursor2.getString(0)),
                                        Integer.parseInt(cursor2.getString(1)),
                                        cursor2.getString(2),
                                        cursor2.getString(3),
                                        cursor2.getString(4),
                                        Integer.parseInt(cursor2.getString(5)),
                                        Integer.parseInt(cursor2.getString(6)),
                                        Integer.parseInt(cursor2.getString(7)),
                                        cursor2.getString(8));

                                listEjercicio.add(ejercicio);
                            }while (cursor2.moveToNext());
                        }
                    }catch (SQLException e){
                        Log.e("SQL Get", e.toString());
                    }
                }while (cursor.moveToNext());
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("SQL Get", e.toString());
        }

        return listEjercicio;
    }

    //Esta clase regresa un arreglo de objetos de tipo Ejercicio
    public ArrayList<Ejercicio> getAllEjercicios(long rId){
        Ejercicio ejercicio;
        ArrayList<Ejercicio> listEjercicio = new ArrayList<>();

        String selectQuery = "SELECT * FROM "+DatabaseSchema.EjercicioTable.TABLE_NAME+
                " WHILE "+DatabaseSchema.EjercicioTable.COLUNM_NAME_ID_RUTINA+
                " = "+"\'"+rId+"\'";

        try {
            Cursor cursor = db.rawQuery(selectQuery, null);
            if(cursor.moveToFirst()) {
                do {
                    ejercicio = new Ejercicio(Integer.parseInt(cursor.getString(0)),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            Integer.parseInt(cursor.getString(4)),
                            Integer.parseInt(cursor.getString(5)),
                            Integer.parseInt(cursor.getString(6)),
                            cursor.getString(7));

                    listEjercicio.add(ejercicio);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }catch (SQLException e){
            Log.e("SQL Get", e.toString());
        }

        return listEjercicio;
    }

    //Esta clase edita un objeto de tipo Ejercicio
    public long editEjercicio(long eId, String data){

        long newRowId = 0;
        try {

            ContentValues values = new ContentValues();
            values.put(DatabaseSchema.HistorialTable.COLUMN_NAME_EJERCICIO_ID, eId);
            values.put(DatabaseSchema.HistorialTable.COLUMN_NAME_FIN, data);

            newRowId = db.insert(DatabaseSchema.HistorialTable.TABLE_NAME, null, values);

        }catch (SQLException e){
            Log.e("SQL ADD",e.toString());
        }

        return newRowId;
    }
}

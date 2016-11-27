package itesm.mx.formaciondeportivaandroid;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Rolando on 11/9/2016.
 */
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
        Log.i("ProductHelper onCreate", CREATE_RUTINA_TABLE);
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
        Log.i("ProductHelper onCreate", CREATE_EJERCICIO_TABLE);
        db.execSQL(CREATE_EJERCICIO_TABLE);

        String CREATE_HISTORIAL_TABLE = "CREATE TABLE "+
                DatabaseSchema.HistorialTable.TABLE_NAME+
                "("+
                DatabaseSchema.HistorialTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.HistorialTable.COLUMN_NAME_EJERCICIO_ID+" INTEGER, "+
                DatabaseSchema.HistorialTable.COLUMN_NAME_FIN+" DATETIME "+
                ")";
        Log.i("ProductHelper onCreate", CREATE_HISTORIAL_TABLE);
        db.execSQL(CREATE_HISTORIAL_TABLE);

        String CREATE_PERFIL_TABLE = "CREATE TABLE "+
                DatabaseSchema.PerfilTable.TABLE_NAME+
                "("+
                DatabaseSchema.PerfilTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_NOMBRE+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_MATRICULA+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_GENERO+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_DIA_NACIMEINTO+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_MES_NACIMIENTO+" TEXT, "+
                DatabaseSchema.PerfilTable.COLUMN_NAME_ANO_NACIMIENTO+" TEXT, "+
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
        Log.i("ProductHelper onCreate", CREATE_PERFIL_TABLE);
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

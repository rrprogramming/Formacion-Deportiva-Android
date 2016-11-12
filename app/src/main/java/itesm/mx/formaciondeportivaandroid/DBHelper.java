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

        String CREATE_RELATION_TABLE = "CREATE TABLE "+
                DatabaseSchema.RelationTable.TABLE_NAME+
                "("+
                DatabaseSchema.RelationTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.RelationTable.COLUNM_NAME_RUTINA+" INTEGER, "+
                DatabaseSchema.RelationTable.COLUMN_NAME_EJERCICIO+" INTEGER "+
                ")";
        Log.i("ProductHelper onCreate", CREATE_RELATION_TABLE);
        db.execSQL(CREATE_RELATION_TABLE);

        String CREATE_TYPE_TABLE = "CREATE TABLE "+
                DatabaseSchema.TypeTable.TABLE_NAME+
                "("+
                DatabaseSchema.TypeTable._ID+" INTEGER PRIMARY KEY, "+
                DatabaseSchema.TypeTable.COLUNM_NAME_RUTINA+" INTEGER, "+
                DatabaseSchema.TypeTable.COLUMN_NAME_TYPE+" INTEGER "+
                ")";
        Log.i("ProductHelper onCreate", CREATE_TYPE_TABLE);
        db.execSQL(CREATE_TYPE_TABLE);

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
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        String DELETE_RUTINA_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.RutinaTable.TABLE_NAME;
        db.execSQL(DELETE_RUTINA_TABLE);
        onCreate(db);

        String DELETE_RELATION_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.RelationTable.TABLE_NAME;
        db.execSQL(DELETE_RELATION_TABLE);
        onCreate(db);

        String DELETE_TYPE_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.TypeTable.TABLE_NAME;
        db.execSQL(DELETE_TYPE_TABLE);
        onCreate(db);

        String DELETE_EJERCICIO_TABLE = "DROP TABLE IF EXISTS "+DatabaseSchema.EjercicioTable.TABLE_NAME;
        db.execSQL(DELETE_EJERCICIO_TABLE);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db, oldVersion, newVersion);
    }
}

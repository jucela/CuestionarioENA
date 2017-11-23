package pe.gob.inei.cuestionarioena;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.provider.BaseColumns;

public class DatabaseHandler extends SQLiteOpenHelper {


    public static abstract class DatosTabla implements BaseColumns {
        public static final String NOMBRE_TABLA = "CUESTIONARIO";
        public static final String COLUMNA_ID = "id";
        public static final String COLUMNA_PREG = "PREG1_1";
        public static final String COLUMNA_RESP = "RESP_1";


        private static final String TEXT_TYPE = " TEXT";
        private static final String COMMA_SEP = ",";
        private static final String CREAR_TABLA_1 =
                "CREATE TABLE IF NOT EXISTS " + DatosTabla.NOMBRE_TABLA + " (" +
                        DatosTabla.COLUMNA_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                        DatosTabla.COLUMNA_PREG + TEXT_TYPE + COMMA_SEP +
                        DatosTabla.COLUMNA_RESP + TEXT_TYPE+
                        " )";

        private static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + DatosTabla.NOMBRE_TABLA;

    }

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ENA.db";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DatosTabla.CREAR_TABLA_1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DatosTabla.SQL_DELETE_ENTRIES);
        onCreate(db);
    }

}

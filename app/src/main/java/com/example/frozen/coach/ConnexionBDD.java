package com.example.frozen.coach;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnexionBDD {

    class SQLiteConnector extends SQLiteOpenHelper
    {
        public SQLiteConnector(Context context, String databaseName, int databaseVersion)
        {
            super(context, databaseName, null, databaseVersion);
        }

        public void onCreate(SQLiteDatabase db)
        {
            db.execSQL("CREATE TABLE nom_de_la_table (paramettres_de_la_table)");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {

        }
    }

}

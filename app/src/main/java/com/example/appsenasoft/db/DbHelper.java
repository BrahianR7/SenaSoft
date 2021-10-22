package com.example.appsenasoft.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "SenaSoft.db";
    public static final String TABLE_PERSONA = "t_persona";
    public static final String TABLE_EQUIPO = "t_equipo";
    public static final String TABLE_OPERACION = "t_operacion";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSONA + "(" +
                "personaid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "documento TEXT NOT NULL," +
                "tipo TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EQUIPO + "(" +
                "equipoid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "descripcion TEXT," +
                "marca TEXT," +
                "serial TEXT NOT NULL," +
                "color TEXT," +
                "personaid INTEGER NOT NULL," +
                "FOREIGN KEY (personaid) REFERENCES " + TABLE_PERSONA + "(personaid))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_OPERACION + "(" +
                "operacionid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "equipoid INTEGER NOT NULL," +
                "fechaIngreso DATETIME NOT NULL," +
                "fechaSalida DATETIME," +
                "tipooperacion INT NOT NULL," +
                "FOREIGN KEY (equipoid) REFERENCES " + TABLE_EQUIPO + "(equipoid))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_PERSONA);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_EQUIPO);
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_OPERACION);
        onCreate(sqLiteDatabase);

    }
}

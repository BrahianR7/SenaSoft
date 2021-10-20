package com.example.appsenasoft.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "SenaSoft.db";
    public static final String TABLE_PERSONA = "t_persona";
    public static final String TABLE_TIPO = "t_tipo";
    public static final String TABLE_EQUIPO = "t_equipo";
    public static final String TABLE_OPERACION = "t_operacion";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_TIPO + "(" +
                "tipoid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_PERSONA + "(" +
                "personaid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT," +
                "documento TEXT NOT NULL," +
                "tipoid INTEGER NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_EQUIPO + "(" +
                "equipoid INTEGER PRIMARY KEY AUTOINCREMENT," +
                "descripcion TEXT," +
                "marca TEXT," +
                "serial TEXT NOT NULL," +
                "color TEXT," +
                "personaid INTEGER NOT NULL)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

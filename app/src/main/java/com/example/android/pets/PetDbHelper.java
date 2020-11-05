package com.example.android.pets;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.android.pets.data.PetsContract;

public class PetDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "schelter.db";
    private static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String comand="CREATE TABLE " + PetsContract.TABLE_NAME+"("+PetsContract._ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PetsContract.COLUMN_PET_NAME+ " TEXT NOT NULL, "+
                PetsContract.COLUMN_PET_BREED + " TEXT, "+
                PetsContract.COLUMN_PET_GENDER + " INTEGER NOT NULL, "+
                PetsContract.COLUMN_PET_WEIGHT+" INTEGER NOT NULL DEFAULT 0"+")";
db.execSQL(comand);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + PetsContract.TABLE_NAME);
                onCreate(db);
    }
}

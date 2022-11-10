package com.example.androiddatabasecrud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "FacultyRoom.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "my_room";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_GEDUNG = "nama_gedung";
    private static final String COLUMN_RUANG = "nama_ruang";
    private static final String COLUMN_KAPASITAS = "besar_kapasitas";

    MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_GEDUNG + " TEXT, " +
                        COLUMN_RUANG + " TEXT, " +
                        COLUMN_KAPASITAS + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addRoom(String gedung, String ruang, int kapasitas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GEDUNG, gedung);
        cv.put(COLUMN_RUANG, ruang);
        cv.put(COLUMN_KAPASITAS, kapasitas);

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to Add", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData() {
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String gedung, String ruang, int kapasitas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GEDUNG, gedung);
        cv.put(COLUMN_RUANG, ruang);
        cv.put(COLUMN_KAPASITAS, kapasitas);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[] {row_id});

        if (result == -1) {
            Toast.makeText(context, "Failed to Update", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Successfully Update", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteData(String row_id, String gedung, String ruang, int kapasitas) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_GEDUNG, gedung);
        cv.put(COLUMN_RUANG, ruang);
        cv.put(COLUMN_KAPASITAS, kapasitas);

        long result = db.delete(TABLE_NAME,"_id=?", new String[] {row_id});

        if (result == -1) {
            Toast.makeText(context, "Failed to Delete", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Room Deleted", Toast.LENGTH_SHORT).show();
        }
    }
}

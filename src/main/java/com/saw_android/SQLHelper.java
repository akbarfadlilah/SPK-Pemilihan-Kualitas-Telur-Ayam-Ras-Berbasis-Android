package com.saw_android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHelper extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "saw.db";
    private static final int DATABASE_VERSION = 1;

    public SQLHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table alternatif( id_alternatif integer primary key autoincrement, nama_alternatif varchar(200) null, " +
                "deskripsi text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO alternatif (id_alternatif, nama_alternatif, deskripsi) VALUES (1, 'Telur 1', 'Telur Blitar');";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif (id_alternatif, nama_alternatif, deskripsi) VALUES (2, 'Telur 2', 'Telur Blitar');";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif (id_alternatif, nama_alternatif, deskripsi) VALUES (3, 'Telur 3', 'Telur Blitar');";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif (id_alternatif, nama_alternatif, deskripsi) VALUES (4, 'Telur 4', 'Telur Blitar');";
        db.execSQL(sql);

        sql = "create table kriteria( id_kriteria integer primary key autoincrement, nama_kriteria varchar(200) null, " +
                "kepentingan double null, cost_benefit varchar(50) null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO kriteria (id_kriteria, nama_kriteria, kepentingan, cost_benefit) VALUES (1, 'Warna', 0.4, 'benefit');";
        db.execSQL(sql);
        sql = "INSERT INTO kriteria (id_kriteria, nama_kriteria, kepentingan, cost_benefit) VALUES (2, 'Berat', 0.3, 'benefit');";
        db.execSQL(sql);
        sql = "INSERT INTO kriteria (id_kriteria, nama_kriteria, kepentingan, cost_benefit) VALUES (3, 'Usia', 0.3, 'cost');";
        db.execSQL(sql);

        sql = "create table alternatif_kriteria( id_alternatif_kriteria integer primary key autoincrement, id_alternatif integer null, " +
                "id_kriteria integer null, nilai double null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (1, 1, 1, 5);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (2, 1, 2, 55);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (3, 1, 3, 2);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (7, 2, 1, 3);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (8, 2, 2, 60);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (9, 2, 3, 1);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (13, 3, 1, 1);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (14, 3, 2, 45);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (15, 3, 3, 3);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (19, 4, 1, 4);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (20, 4, 2, 50);";
        db.execSQL(sql);
        sql = "INSERT INTO alternatif_kriteria (id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) VALUES (21, 4, 3, 1);";
        db.execSQL(sql);

        sql = "create table login( username varchar(50) primary key, password varchar(50) null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO login (username, password) VALUES ('admin', '123');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

    }

}

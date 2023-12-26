package com.saw_android;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class AlternatifKriteriaActivity extends AppCompatActivity {
//public class AlternatifKriteriaActivity extends Activity {

    String[] array_id_alternatif_kriteria;
    String[] array_id_alternatif;
    String[] array_id_kriteria;
    String[] array_nilai;
    String[] array_alternatif_kriteria;
    ListView listalternatifkriteria;

    Button btnalternatifkriteriaadd;

    protected Cursor cursor;
    SQLHelper dbHelper;
    public static AlternatifKriteriaActivity obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_alternatif_kriteria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        obj = this;

        dbHelper = new SQLHelper(this);

        btnalternatifkriteriaadd = (Button) findViewById(R.id.btnalternatifkriteriaadd);
        btnalternatifkriteriaadd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(AlternatifKriteriaActivity.this, AddAlternatifKriteriaActivity.class);
                startActivity(i);
            }
        });

        RefreshList();
    }

    public void RefreshList()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //cursor = db.rawQuery("SELECT alternatif_kriteria.id_alternatif_kriteria, alternatif_kriteria.id_alternatif, alternatif_kriteria.id_kriteriaalternatif_kriteria.nilai, alternatif.nama_alternatif, kriteria.nama_kriteria FROM alternatif_kriteria LEFT JOIN alternatif ON alternatif.id_alternatif = alternatif_kriteria.id_alternatif LEFT JOIN kriteria.id_kriteria = alternatif_kriteria.id_kriteria",null);
        cursor = db.rawQuery("SELECT alternatif_kriteria.*, alternatif.nama_alternatif, kriteria.nama_kriteria FROM alternatif_kriteria LEFT JOIN kriteria ON kriteria.id_kriteria = alternatif_kriteria.id_kriteria  LEFT JOIN alternatif ON alternatif.id_alternatif = alternatif_kriteria.id_alternatif",null);
        //cursor = db.rawQuery("SELECT * FROM alternatif_kriteria ak LEFT JOIN kriteria k ON k.id_kriteria = ak.id_kriteria  LEFT JOIN alternatif a ON a.id_alternatif = ak.id_alternatif",null);

        array_id_alternatif_kriteria = new String[cursor.getCount()];
        array_id_alternatif = new String[cursor.getCount()];
        array_id_kriteria = new String[cursor.getCount()];
        array_nilai = new String[cursor.getCount()];
        array_alternatif_kriteria = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            array_id_alternatif_kriteria[cc] = cursor.getString(0).toString();
            array_id_alternatif[cc] = cursor.getString(1).toString();
            array_id_kriteria[cc] = cursor.getString(2).toString();
            array_nilai[cc] = cursor.getString(3).toString();
            array_alternatif_kriteria[cc] = cursor.getString(0).toString() + ". " + cursor.getString(4).toString() + "/" + cursor.getString(5).toString() + "\nNilai = " + cursor.getString(3).toString();
        }

        listalternatifkriteria = (ListView)findViewById(R.id.listalternatifkriteria);
        listalternatifkriteria.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_alternatif_kriteria));
        listalternatifkriteria.setSelected(true);
        listalternatifkriteria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                final int posisi = arg2; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Edit", "Delete"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AlternatifKriteriaActivity.this);
                builder.setTitle("Pilih ?");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), EditAlternatifKriteriaActivity.class);
                                i.putExtra("id_alternatif_kriteria", array_id_alternatif_kriteria[posisi]);
                                i.putExtra("id_alternatif", array_id_alternatif[posisi]);
                                i.putExtra("id_kriteria", array_id_kriteria[posisi]);
                                i.putExtra("nilai", array_nilai[posisi]);
                                startActivity(i);
                                break;
                            case 1 :
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.execSQL("delete from alternatif_kriteria where id_alternatif_kriteria = '" + array_id_alternatif_kriteria[posisi] + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});


        ((ArrayAdapter)listalternatifkriteria.getAdapter()).notifyDataSetInvalidated();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alternatif_kriteria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } switch (item.getItemId()) {
            case R.id.menu_alternatif_kriteria_add:
                Intent i = new Intent(AlternatifKriteriaActivity.this, AddAlternatifKriteriaActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_alternatif_kriteria_refresh:
                RefreshList();
                return true;
            case R.id.menu_alternatif_kriteria_exit:
                finish();
                return true;
        }
        return false;
    }

}

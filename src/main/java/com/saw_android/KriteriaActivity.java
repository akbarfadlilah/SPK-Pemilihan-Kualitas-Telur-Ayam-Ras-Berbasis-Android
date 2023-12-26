package com.saw_android;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class KriteriaActivity extends AppCompatActivity {
//public class KriteriaActivity extends Activity {

    String[] array_id_kriteria;
    String[] array_nama_kriteria;
    String[] array_kepentingan;
    String[] array_cost_benefit;
    String[] array_kriteria;
    ListView listkriteria;

    Button btnkriteriaadd;

    protected Cursor cursor;
    SQLHelper dbHelper;
    public static KriteriaActivity obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_kriteria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        obj = this;

        dbHelper = new SQLHelper(this);

        btnkriteriaadd = (Button) findViewById(R.id.btnkriteriaadd);
        btnkriteriaadd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(KriteriaActivity.this, AddKriteriaActivity.class);
                startActivity(i);
            }
        });

        RefreshList();
    }

    public void RefreshList()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM kriteria",null);

        array_id_kriteria = new String[cursor.getCount()];
        array_nama_kriteria = new String[cursor.getCount()];
        array_kepentingan = new String[cursor.getCount()];
        array_cost_benefit = new String[cursor.getCount()];
        array_kriteria = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            array_id_kriteria[cc] = cursor.getString(0).toString();
            array_nama_kriteria[cc] = cursor.getString(1).toString();
            array_kepentingan[cc] = cursor.getString(2).toString();
            array_cost_benefit[cc] = cursor.getString(3).toString();
            array_kriteria[cc] = cursor.getString(0).toString() + ". " + cursor.getString(1).toString() + "\n Kepentingan: " + cursor.getString(2).toString() + " (" + cursor.getString(3).toString() + ")";
        }

        listkriteria = (ListView)findViewById(R.id.listkriteria);
        listkriteria.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_kriteria));
        listkriteria.setSelected(true);
        listkriteria.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                final int posisi = arg2; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Edit", "Delete"};
                AlertDialog.Builder builder = new AlertDialog.Builder(KriteriaActivity.this);
                builder.setTitle("Pilih ?");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), EditKriteriaActivity.class);
                                i.putExtra("id_kriteria", array_id_kriteria[posisi]);
                                i.putExtra("nama_kriteria", array_nama_kriteria[posisi]);
                                i.putExtra("kepentingan", array_kepentingan[posisi]);
                                i.putExtra("cost_benefit", array_cost_benefit[posisi]);
                                startActivity(i);
                                break;
                            case 1 :
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.execSQL("delete from kriteria where id_kriteria = '" + array_id_kriteria[posisi] + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});


        ((ArrayAdapter)listkriteria.getAdapter()).notifyDataSetInvalidated();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_kriteria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } switch (item.getItemId()) {
            case R.id.menu_kriteria_add:
                Intent i = new Intent(KriteriaActivity.this, AddKriteriaActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_kriteria_refresh:
                RefreshList();
                return true;
            case R.id.menu_kriteria_exit:
                finish();
                return true;
        }
        return false;
    }

}

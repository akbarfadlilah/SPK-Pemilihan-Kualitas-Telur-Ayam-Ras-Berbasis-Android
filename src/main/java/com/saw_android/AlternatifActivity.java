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

public class AlternatifActivity extends AppCompatActivity {
//public class AlternatifActivity extends Activity {

    String[] array_id_alternatif;
    String[] array_nama_alternatif;
    String[] array_deskripsi;
    String[] array_alternatif;
    ListView listalternatif;

    Button btnalternatifadd;

    protected Cursor cursor;
    SQLHelper dbHelper;
    public static AlternatifActivity obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_alternatif);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        obj = this;

        dbHelper = new SQLHelper(this);

        btnalternatifadd = (Button) findViewById(R.id.btnalternatifadd);
        btnalternatifadd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent i = new Intent(AlternatifActivity.this, AddAlternatifActivity.class);
                startActivity(i);
            }
        });

        RefreshList();
    }



    public void RefreshList()
    {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM alternatif",null);

        array_id_alternatif = new String[cursor.getCount()];
        array_nama_alternatif = new String[cursor.getCount()];
        array_deskripsi = new String[cursor.getCount()];
        array_alternatif = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            array_id_alternatif[cc] = cursor.getString(0).toString();
            array_nama_alternatif[cc] = cursor.getString(1).toString();
            array_deskripsi[cc] = cursor.getString(2).toString();
            array_alternatif[cc] = cursor.getString(0).toString() + ". " + cursor.getString(1).toString() + "\n" + cursor.getString(2).toString();
        }

        listalternatif = (ListView)findViewById(R.id.listalternatif);
        listalternatif.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, array_alternatif));
        listalternatif.setSelected(true);
        listalternatif.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                final int posisi = arg2; //.getItemAtPosition(arg2).toString();
                final CharSequence[] dialogitem = {"Edit", "Delete"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AlternatifActivity.this);
                builder.setTitle("Pilih ?");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        switch(item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), EditAlternatifActivity.class);
                                i.putExtra("id_alternatif", array_id_alternatif[posisi]);
                                i.putExtra("nama_alternatif", array_nama_alternatif[posisi]);
                                i.putExtra("deskripsi", array_deskripsi[posisi]);
                                startActivity(i);
                                break;
                            case 1 :
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                db.execSQL("delete from alternatif where id_alternatif = '" + array_id_alternatif[posisi] + "'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }});


        ((ArrayAdapter)listalternatif.getAdapter()).notifyDataSetInvalidated();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alternatif, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            if (item.getItemId() == android.R.id.home) {
                onBackPressed();
                return true;
            } switch (item.getItemId()) {
            case R.id.menu_alternatif_add:
                Intent i = new Intent(AlternatifActivity.this, AddAlternatifActivity.class);
                startActivity(i);
                return true;
            case R.id.menu_alternatif_refresh:
                RefreshList();
                return true;
            case R.id.menu_alternatif_exit:
                finish();
                return true;
        }
        return false;
    }

}

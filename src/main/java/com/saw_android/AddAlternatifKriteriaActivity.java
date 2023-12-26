package com.saw_android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class AddAlternatifKriteriaActivity extends AppCompatActivity {


    protected Cursor cursor;
    SQLHelper dbHelper;

    Button btnaddalternatifkriteriasave;
    EditText edaddalternatifkriteriaid;
    Spinner spnaddalternatifkriteriaidalternatif;
    Spinner spnaddalternatifkriteriaidkriteria;
    EditText edaddalternatifkriterianilai;

    String[] array_id_alternatif;
    String[] array_nama_alternatif;
    String[] array_id_kriteria;
    String[] array_nama_kriteria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_alternatif_kriteria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        edaddalternatifkriteriaid = (EditText) findViewById(R.id.edaddalternatifkriteriaid);
        spnaddalternatifkriteriaidalternatif = (Spinner) findViewById(R.id.spnaddalternatifkriteriaidalternatif);
        spnaddalternatifkriteriaidkriteria = (Spinner) findViewById(R.id.spnaddalternatifkriteriaidkriteria);
        edaddalternatifkriterianilai = (EditText) findViewById(R.id.edaddalternatifkriterianilai);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM alternatif",null);

        array_id_alternatif = new String[cursor.getCount()];
        array_nama_alternatif = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            array_id_alternatif[cc] = cursor.getString(0).toString();
            array_nama_alternatif[cc] = cursor.getString(1).toString();
        }

        cursor = db.rawQuery("SELECT * FROM kriteria",null);

        array_id_kriteria = new String[cursor.getCount()];
        array_nama_kriteria = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            array_id_kriteria[cc] = cursor.getString(0).toString();
            array_nama_kriteria[cc] = cursor.getString(1).toString();
        }

        ArrayAdapter<String> adapter_spnaddalternatifkriteriaidalternatif = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_nama_alternatif);
        adapter_spnaddalternatifkriteriaidalternatif.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnaddalternatifkriteriaidalternatif.setAdapter(adapter_spnaddalternatifkriteriaidalternatif);

        ArrayAdapter<String> adapter_spnaddalternatifkriteriaidkriteria = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_nama_kriteria);
        adapter_spnaddalternatifkriteriaidkriteria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnaddalternatifkriteriaidkriteria.setAdapter(adapter_spnaddalternatifkriteriaidkriteria);

        btnaddalternatifkriteriasave = (Button) findViewById(R.id.btnaddalternatifkriteriasave);
        btnaddalternatifkriteriasave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                db.execSQL("insert into alternatif_kriteria(id_alternatif_kriteria, id_alternatif, id_kriteria, nilai) values('" + edaddalternatifkriteriaid.getText().toString()+
                        "','"+ array_id_alternatif[spnaddalternatifkriteriaidalternatif.getSelectedItemPosition()] +"','" + array_id_kriteria[spnaddalternatifkriteriaidkriteria.getSelectedItemPosition()] + "','" + edaddalternatifkriterianilai.getText().toString() + "')");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                AlternatifKriteriaActivity.obj.RefreshList();
                finish();
            }

        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } return false;
    }

}

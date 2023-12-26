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

public class EditAlternatifKriteriaActivity extends AppCompatActivity {
//public class EditAlternatifKriteriaActivity extends Activity {

    protected Cursor cursor;
    SQLHelper dbHelper;

    Button btneditalternatifkriteriasave;
    EditText ededitalternatifkriteriaid;
    Spinner spneditalternatifkriteriaidkriteria;
    Spinner spneditalternatifkriteriaidalternatif;
    EditText ededitalternatifkriterianilai;

    String[] array_id_alternatif;
    String[] array_nama_alternatif;
    String[] array_id_kriteria;
    String[] array_nama_kriteria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_alternatif_kriteria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        ededitalternatifkriteriaid = (EditText) findViewById(R.id.ededitalternatifkriteriaid);
        spneditalternatifkriteriaidalternatif = (Spinner) findViewById(R.id.spneditalternatifkriteriaidalternatif);
        spneditalternatifkriteriaidkriteria = (Spinner) findViewById(R.id.spneditalternatifkriteriaidkriteria);
        ededitalternatifkriterianilai = (EditText) findViewById(R.id.ededitalternatifkriterianilai);

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
        spneditalternatifkriteriaidalternatif.setAdapter(adapter_spnaddalternatifkriteriaidalternatif);

        ArrayAdapter<String> adapter_spnaddalternatifkriteriaidkriteria = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_nama_kriteria);
        adapter_spnaddalternatifkriteriaidkriteria.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spneditalternatifkriteriaidkriteria.setAdapter(adapter_spnaddalternatifkriteriaidkriteria);

        ededitalternatifkriteriaid.setText(getIntent().getStringExtra("id_alternatif_kriteria"));
        int i;
        int posisi_id_alternatif = 0;
        for (i=0;i<array_id_alternatif.length;i++)
        {
            if (array_id_alternatif[i].equals(getIntent().getStringExtra("id_alternatif")) == true)
            {
                posisi_id_alternatif = i;
            }
        }
        int posisi_id_kriteria = 0;
        for (i=0;i<array_id_kriteria.length;i++)
        {
            if (array_id_kriteria[i].equals(getIntent().getStringExtra("id_kriteria")) == true)
            {
                posisi_id_kriteria = i;
            }
        }
        spneditalternatifkriteriaidalternatif.setSelection(posisi_id_alternatif);
        spneditalternatifkriteriaidkriteria.setSelection(posisi_id_kriteria);
        ededitalternatifkriterianilai.setText(getIntent().getStringExtra("nilai"));

        btneditalternatifkriteriasave = (Button) findViewById(R.id.btneditalternatifkriteriasave);
        // daftarkan even onClick pada btnSimpan
        btneditalternatifkriteriasave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update alternatif_kriteria SET id_alternatif='" + array_id_alternatif[spneditalternatifkriteriaidalternatif.getSelectedItemPosition()] +"', " +
                        "id_kriteria='"+ array_id_kriteria[spneditalternatifkriteriaidkriteria.getSelectedItemPosition()] +"', nilai='"+ ededitalternatifkriterianilai.getText().toString() +"' WHERE " +
                        " id_alternatif_kriteria = '" + getIntent().getStringExtra("id_alternatif_kriteria") + "'");
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

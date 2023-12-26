package com.saw_android;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


//public class EditAlternatifActivity extends AppCompatActivity {
public class EditAlternatifActivity extends AppCompatActivity {

    SQLHelper dbHelper;

    Button btneditalternatifsave;
    EditText ededitalternatifid;
    EditText ededitalternatifnama;
    EditText ededitalternatifdeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_alternatif);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        ededitalternatifid = (EditText) findViewById(R.id.ededitalternatifid);
        ededitalternatifnama = (EditText) findViewById(R.id.ededitalternatifnama);
        ededitalternatifdeskripsi = (EditText) findViewById(R.id.ededitalternatifdeskripsi);

        ededitalternatifid.setText(getIntent().getStringExtra("id_alternatif"));
        ededitalternatifnama.setText(getIntent().getStringExtra("nama_alternatif"));
        ededitalternatifdeskripsi.setText(getIntent().getStringExtra("deskripsi"));

        btneditalternatifsave = (Button) findViewById(R.id.btneditalternatifsave);
        // daftarkan even onClick pada btnSimpan
        btneditalternatifsave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update alternatif SET nama_alternatif='" + ededitalternatifnama.getText().toString()+"', " +
                        "deskripsi='"+ ededitalternatifdeskripsi.getText().toString() +"' WHERE " +
                        " id_alternatif = '" + getIntent().getStringExtra("id_alternatif") + "'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                AlternatifActivity.obj.RefreshList();
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

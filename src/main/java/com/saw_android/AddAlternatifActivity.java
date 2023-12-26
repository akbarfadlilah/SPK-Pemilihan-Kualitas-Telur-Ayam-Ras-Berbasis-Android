package com.saw_android;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class AddAlternatifActivity extends AppCompatActivity {
//public class AddAlternatifActivity extends Activity {

    protected Cursor cursor;
    SQLHelper dbHelper;

    Button btnaddalternatifsave;
    EditText edaddalternatifid;
    EditText edaddalternatifnama;
    EditText edaddalternatifdeskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_alternatif);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        edaddalternatifid = (EditText) findViewById(R.id.edaddalternatifid);
        edaddalternatifnama = (EditText) findViewById(R.id.edaddalternatifnama);
        edaddalternatifdeskripsi = (EditText) findViewById(R.id.edaddalternatifdeskripsi);

        btnaddalternatifsave = (Button) findViewById(R.id.btnaddalternatifsave);
        btnaddalternatifsave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("insert into alternatif(id_alternatif, nama_alternatif, deskripsi) values('" + edaddalternatifid.getText().toString() +
                        "','" + edaddalternatifnama.getText().toString() + "','" + edaddalternatifdeskripsi.getText().toString() + "')");
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
        }
        return false;
    }


}

package com.saw_android;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class EditKriteriaActivity extends AppCompatActivity {

    SQLHelper dbHelper;

    Button btneditkriteriasave;
    EditText ededitkriteriaid;
    EditText ededitkriterianama;
    EditText ededitkriteriakepentingan;
    Spinner spneditkriteriacostbenefit;

    String[] array_spncostbenefit = { "cost", "benefit" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_edit_kriteria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        ededitkriteriaid = (EditText) findViewById(R.id.ededitkriteriaid);
        ededitkriterianama = (EditText) findViewById(R.id.ededitkriterianama);
        ededitkriteriakepentingan = (EditText) findViewById(R.id.ededitkriteriakepentingan);
        spneditkriteriacostbenefit = (Spinner) findViewById(R.id.spneditkriteriacostbenefit);

        ededitkriteriaid.setText(getIntent().getStringExtra("id_kriteria"));
        ededitkriterianama.setText(getIntent().getStringExtra("nama_kriteria"));
        ededitkriteriakepentingan.setText(getIntent().getStringExtra("kepentingan"));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_spncostbenefit);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spneditkriteriacostbenefit.setAdapter(adapter);

        if (getIntent().getStringExtra("cost_benefit").equals("cost") == true) {
            spneditkriteriacostbenefit.setSelection(0);
        }
        else {
            spneditkriteriacostbenefit.setSelection(1);
        }

        btneditkriteriasave = (Button) findViewById(R.id.btneditkriteriasave);
        // daftarkan even onClick pada btnSimpan
        btneditkriteriasave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String cost_benefit = "";
                if (spneditkriteriacostbenefit.getSelectedItemPosition() == 0) {
                    cost_benefit = "cost";
                }
                else {
                    cost_benefit = "benefit";
                }
                db.execSQL("update kriteria SET nama_kriteria='" + ededitkriterianama.getText().toString()+"', " +
                        "kepentingan='"+ ededitkriteriakepentingan.getText().toString() +"', cost_benefit='"+ cost_benefit +"' WHERE " +
                        " id_kriteria = '" + getIntent().getStringExtra("id_kriteria") + "'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                KriteriaActivity.obj.RefreshList();
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

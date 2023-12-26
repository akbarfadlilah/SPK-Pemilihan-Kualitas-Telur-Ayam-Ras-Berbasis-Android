package com.saw_android;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddKriteriaActivity extends AppCompatActivity {
//public class AddKriteriaActivity extends Activity {

    protected Cursor cursor;
    SQLHelper dbHelper;

    Button btnaddkriteriasave;
    EditText edaddkriteriaid;
    EditText edaddkriterianama;
    EditText edaddkriteriakepentingan;
    Spinner spnaddkriteriacostbenefit;

    String[] array_spncostbenefit = { "cost", "benefit" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kriteria);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_add_kriteria);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        edaddkriteriaid = (EditText) findViewById(R.id.edaddkriteriaid);
        edaddkriterianama = (EditText) findViewById(R.id.edaddkriterianama);
        edaddkriteriakepentingan = (EditText) findViewById(R.id.edaddkriteriakepentingan);
        spnaddkriteriacostbenefit = (Spinner) findViewById(R.id.spnaddkriteriacostbenefit);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_spncostbenefit);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnaddkriteriacostbenefit.setAdapter(adapter);

        btnaddkriteriasave = (Button) findViewById(R.id.btnaddkriteriasave);
        btnaddkriteriasave.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                String cost_benefit = "";
                if (spnaddkriteriacostbenefit.getSelectedItemPosition() == 0) {
                    cost_benefit = "cost";
                }
                else {
                    cost_benefit = "benefit";
                }
                db.execSQL("insert into kriteria(id_kriteria, nama_kriteria, kepentingan, cost_benefit) values('" + edaddkriteriaid.getText().toString()+
                        "','"+ edaddkriterianama.getText().toString() +"','" + edaddkriteriakepentingan.getText().toString() + "','" + cost_benefit + "')");
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

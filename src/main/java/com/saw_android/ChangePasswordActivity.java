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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePasswordActivity extends AppCompatActivity {
//public class ChangePasswordActivity extends Activity {

    EditText edpasswordusername;
    EditText edpasswordold;
    EditText edpasswordnew;
    EditText edpasswordconfirm;
    Button btnpasswordsave;
    protected Cursor cursor;
    SQLHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_change_password);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        edpasswordusername = (EditText)findViewById(R.id.edpasswordusername);
        edpasswordold = (EditText)findViewById(R.id.edpasswordold);
        edpasswordnew = (EditText)findViewById(R.id.edpasswordnew);
        edpasswordconfirm = (EditText)findViewById(R.id.edpasswordconfirm);

        edpasswordusername.setText(AdminActivity.userlogin);

        btnpasswordsave = (Button)findViewById(R.id.btnpasswordsave);
        btnpasswordsave.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                cursor = db.rawQuery("SELECT * FROM login WHERE username = '" + edpasswordusername.getText().toString() + "' AND password = '" + edpasswordold.getText().toString() + "'", null);

                if (cursor.getCount() > 0) {
                    if (edpasswordnew.getText().toString().equals(edpasswordconfirm.getText().toString()) == true) {
                        db = dbHelper.getWritableDatabase();
                        db.execSQL("UPDATE login SET password='" + edpasswordnew.getText().toString() + "' " +
                                " WHERE username = '" + edpasswordusername.getText().toString() + "'");
                        Toast.makeText(getApplicationContext(), "Password Berhasil Diubah", Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(getApplicationContext(), "Password Baru Tidak Sama dengan Konfirmasi Password", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Password Lama Salah", Toast.LENGTH_LONG).show();
                }
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

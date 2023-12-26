package com.saw_android;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
//public class LoginActivity extends Activity {

    EditText edloginusername;
    EditText edloginpassword;
    Button btnlogin;
    protected Cursor cursor;
    SQLHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        dbHelper = new SQLHelper(this);

        edloginusername = (EditText)findViewById(R.id.edloginusername);
        edloginpassword = (EditText)findViewById(R.id.edloginpassword);

        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getReadableDatabase();

                cursor = db.rawQuery("SELECT * FROM login WHERE username = '" + edloginusername.getText().toString() + "' AND password = '" + edloginpassword.getText().toString() + "'", null);

                if (cursor.getCount() > 0) {
                    Intent i = new Intent(LoginActivity.this, AdminActivity.class);
                    startActivity(i);
                    AdminActivity.userlogin = edloginusername.getText().toString();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Login Gagal", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}

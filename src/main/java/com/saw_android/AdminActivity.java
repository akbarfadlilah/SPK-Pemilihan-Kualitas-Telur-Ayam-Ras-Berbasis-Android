package com.saw_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {
//public class AdminActivity extends Activity {

    Button btnadminalternatif;
    Button btnadminkriteria;
    Button btnadminalternatifkriteria;
    Button btnmainhasil;
    Button btnmainspk;
    Button btnadminpassword;
    Button btnadminback;

    public static String userlogin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_admin);

        btnadminalternatif = (Button)findViewById(R.id.btnadminalternatif);
        btnadminkriteria = (Button)findViewById(R.id.btnadminkriteria);
        btnadminalternatifkriteria = (Button)findViewById(R.id.btnadminalternatifkriteria);
        btnmainhasil = (Button)findViewById(R.id.btnmainhasil);
        btnadminpassword = (Button)findViewById(R.id.btnadminpassword);
        btnadminback = (Button)findViewById(R.id.btnadminback);
        btnmainspk = (Button)findViewById(R.id.btnmainspk);

        btnadminalternatif.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(AdminActivity.this, AlternatifActivity.class);
                startActivity(i);
            }
        });

        btnadminkriteria.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(AdminActivity.this, KriteriaActivity.class);
                startActivity(i);
            }
        });

        btnadminalternatifkriteria.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(AdminActivity.this, AlternatifKriteriaActivity.class);
                startActivity(i);
            }
        });

        btnmainhasil.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(AdminActivity.this, AnalisaSawActivity.class);
                startActivity(i);
            }
        });

        btnmainspk.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(AdminActivity.this, SawStatisActivity.class);
                startActivity(i);
            }
        });

        btnadminpassword.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent i = new Intent(AdminActivity.this, ChangePasswordActivity.class);
                startActivity(i);
            }
        });

        btnadminback.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });

    }

}

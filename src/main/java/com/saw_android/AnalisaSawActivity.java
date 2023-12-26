package com.saw_android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

//public class AnalisaActivity extends AppCompatActivity {
public class AnalisaSawActivity extends AppCompatActivity {

    String[] alternatif;
    String[] kriteria;
    String[] costbenefit;
    double[] kepentingan;
    double[][] alternatifkriteria;

    String[] id_alternatif;
    String[] id_kriteria;

    protected Cursor cursor;
    SQLHelper dbHelper;

    public LinearLayout tampiltabel(double[][] data)
    {
        LinearLayout.LayoutParams lpp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpp.setMargins(1, 1, 1, 1);

        LinearLayout llv = new LinearLayout(this);
        llv.setOrientation(LinearLayout.VERTICAL);
        for (int i=0; i<data.length; i++)
        {
            LinearLayout llh = new LinearLayout(this);
            llh.setOrientation(LinearLayout.HORIZONTAL);
            llv.addView(llh);

            for (int j=0; j<data[0].length; j++)
            {
                TextView textview = new TextView(this);
                int maxLength = 8;
                if (maxLength > String.valueOf(data[i][j]).length()) { maxLength = String.valueOf(data[i][j]).length(); }
                textview.setText(String.valueOf(data[i][j]).substring(0, maxLength));
                textview.setWidth(100);
                textview.setTypeface(Typeface.DEFAULT_BOLD);
                textview.setBackgroundColor(Color.parseColor("#ffffff"));
                textview.setLayoutParams(lpp);
                textview.setPadding(2, 2, 2, 2);
                llh.addView(textview);
            }
        }
        llv.setBackgroundColor(Color.parseColor("#0000ff"));
        llv.setLayoutParams(lpp);
        llv.setPadding(1, 1, 1, 1);

        return llv;
    }

    public LinearLayout tampilbaris(String[] data)
    {
        LinearLayout.LayoutParams lpp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpp.setMargins(1, 1, 1, 1);

        LinearLayout llv = new LinearLayout(this);
        llv.setOrientation(LinearLayout.VERTICAL);

        LinearLayout llh = new LinearLayout(this);
        llh.setOrientation(LinearLayout.HORIZONTAL);
        llv.addView(llh);

        for (int i=0; i<data.length; i++)
        {
            TextView textview = new TextView(this);
            int maxLength = 10;
            if (maxLength > String.valueOf(data[i]).length()) { maxLength = String.valueOf(data[i]).length(); }
            textview.setText(data[i].substring(0, maxLength));
            textview.setWidth(100);
            textview.setTypeface(Typeface.DEFAULT_BOLD);
            textview.setBackgroundColor(Color.parseColor("#ffffff"));
            textview.setLayoutParams(lpp);
            textview.setPadding(2, 2, 2, 2);
            llh.addView(textview);
        }

        llv.setBackgroundColor(Color.parseColor("#0000ff"));
        llv.setLayoutParams(lpp);
        llv.setPadding(1, 1, 1, 1);

        return llv;
    }

    public LinearLayout tampilbaris(double[] data)
    {
        LinearLayout.LayoutParams lpp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpp.setMargins(1, 1, 1, 1);

        LinearLayout llv = new LinearLayout(this);
        llv.setOrientation(LinearLayout.VERTICAL);

        LinearLayout llh = new LinearLayout(this);
        llh.setOrientation(LinearLayout.HORIZONTAL);
        llv.addView(llh);

        for (int i=0; i<data.length; i++)
        {
            TextView textview = new TextView(this);
            int maxLength = 8;
            if (maxLength > String.valueOf(data[i]).length()) { maxLength = String.valueOf(data[i]).length(); }
            textview.setText(String.valueOf(data[i]).substring(0, maxLength));
            textview.setWidth(100);
            textview.setTypeface(Typeface.DEFAULT_BOLD);
            textview.setBackgroundColor(Color.parseColor("#ffffff"));
            textview.setLayoutParams(lpp);
            textview.setPadding(2, 2, 2, 2);
            llh.addView(textview);
        }

        llv.setBackgroundColor(Color.parseColor("#0000ff"));
        llv.setLayoutParams(lpp);
        llv.setPadding(1, 1, 1, 1);

        return llv;
    }

    public LinearLayout tampilkolom(String[] data)
    {
        LinearLayout.LayoutParams lpp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpp.setMargins(1, 1, 1, 1);

        LinearLayout llv = new LinearLayout(this);
        llv.setOrientation(LinearLayout.VERTICAL);
        for (int i=0; i<data.length; i++)
        {
            LinearLayout llh = new LinearLayout(this);
            llh.setOrientation(LinearLayout.HORIZONTAL);
            llv.addView(llh);

            TextView textview = new TextView(this);
            int maxLength = 10;
            if (maxLength > data[i].length()) { maxLength = data[i].length(); }
            textview.setText(data[i].substring(0, maxLength));
            textview.setWidth(100);
            textview.setTypeface(Typeface.DEFAULT_BOLD);
            textview.setBackgroundColor(Color.parseColor("#ffffff"));
            textview.setLayoutParams(lpp);
            textview.setPadding(2, 2, 2, 2);
            llh.addView(textview);
        }

        llv.setBackgroundColor(Color.parseColor("#0000ff"));
        llv.setLayoutParams(lpp);
        llv.setPadding(1, 1, 1, 1);

        return llv;
    }

    public LinearLayout tampilkolom(double[] data)
    {
        LinearLayout.LayoutParams lpp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lpp.setMargins(1, 1, 1, 1);

        LinearLayout llv = new LinearLayout(this);
        llv.setOrientation(LinearLayout.VERTICAL);
        for (int i=0; i<data.length; i++)
        {
            LinearLayout llh = new LinearLayout(this);
            llh.setOrientation(LinearLayout.HORIZONTAL);
            llv.addView(llh);

            TextView textview = new TextView(this);
            int maxLength = 8;
            if (maxLength > String.valueOf(data[i]).length()) { maxLength = String.valueOf(data[i]).length(); }
            textview.setText(String.valueOf(data[i]).substring(0, maxLength));
            textview.setWidth(100);
            textview.setTypeface(Typeface.DEFAULT_BOLD);
            textview.setBackgroundColor(Color.parseColor("#ffffff"));
            textview.setLayoutParams(lpp);
            textview.setPadding(2, 2, 2, 2);
            llh.addView(textview);
        }

        llv.setBackgroundColor(Color.parseColor("#0000ff"));
        llv.setLayoutParams(lpp);
        llv.setPadding(1, 1, 1, 1);

        return llv;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_analisa_saw);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dbHelper = new SQLHelper(this);

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        cursor = db.rawQuery("SELECT * FROM alternatif",null);

        alternatif = new String[cursor.getCount()];
        id_alternatif = new String[cursor.getCount()];

        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            alternatif[cc] = cursor.getString(1).toString();
            id_alternatif[cc] = cursor.getString(0).toString();
        }

        cursor = db.rawQuery("SELECT * FROM kriteria",null);

        kriteria = new String[cursor.getCount()];
        kepentingan = new double[cursor.getCount()];
        costbenefit = new String[cursor.getCount()];
        id_kriteria = new String[cursor.getCount()];

        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++)
        {
            cursor.moveToPosition(cc);
            kriteria[cc] = cursor.getString(1).toString();
            kepentingan[cc] = Double.parseDouble(cursor.getString(2).toString());
            costbenefit[cc] = cursor.getString(3).toString();
            id_kriteria[cc] = cursor.getString(0).toString();
        }

        alternatifkriteria = new double[alternatif.length][kriteria.length];

        for (int i=0;i<alternatif.length;i++)
        {
            for (int j=0;j<kriteria.length;j++)
            {
                cursor = db.rawQuery("SELECT * FROM alternatif_kriteria WHERE id_alternatif = '" + id_alternatif[i] + "' AND id_kriteria = '" + id_kriteria[j] + "'",null);

                cursor.moveToFirst();
                if (cursor.getCount() > 0)
                {
                    cursor.moveToPosition(0);
                    alternatifkriteria[i][j] = Double.parseDouble(cursor.getString(3).toString());
                }
            }
        }

        double[] pembagi = new double[kriteria.length];

        for (int i=0;i<kriteria.length;i++)
        {
            pembagi[i] = 0;
            if (costbenefit[i].equalsIgnoreCase("cost") == true)
            {
                for (int j=0;j<alternatif.length;j++)
                {
                    if (j == 0)
                    {
                        pembagi[i] = alternatifkriteria[j][i];
                    }
                    else
                    {
                        if (pembagi[i] > alternatifkriteria[j][i])
                        {
                            pembagi[i] = alternatifkriteria[j][i];
                        }
                    }
                }
            }
            else
            {
                for (int j=0;j<alternatif.length;j++)
                {
                    if (j == 0)
                    {
                        pembagi[i] = alternatifkriteria[j][i];
                    }
                    else
                    {
                        if (pembagi[i] < alternatifkriteria[j][i])
                        {
                            pembagi[i] = alternatifkriteria[j][i];
                        }
                    }
                }
            }
        }

        double[][] normalisasi = new double[alternatif.length][kriteria.length];

        for (int i=0;i<alternatif.length;i++)
        {
            for (int j=0;j<kriteria.length;j++)
            {
                if (costbenefit[j].equalsIgnoreCase("cost") == true)
                {
                    normalisasi[i][j] = pembagi[j] / alternatifkriteria[i][j];
                }
                else
                {
                    normalisasi[i][j] = alternatifkriteria[i][j] / pembagi[j];
                }
            }
        }

        double[] hasil = new double[alternatif.length];

        for (int i=0;i<alternatif.length;i++)
        {
            hasil[i] = 0;
            for (int j=0;j<kriteria.length;j++)
            {
                hasil[i] = hasil[i] + (normalisasi[i][j] * kepentingan[j]);
            }
        }

        String[] alternatifrangking = new String[alternatif.length];
        double[] hasilrangking = new double[alternatif.length];

        for (int i=0;i<alternatif.length;i++)
        {
            hasilrangking[i] = hasil[i];
            alternatifrangking[i] = alternatif[i];
        }

        for (int i=0;i<alternatif.length;i++)
        {
            for (int j=i;j<alternatif.length;j++)
            {
                if (hasilrangking[j] > hasilrangking[i])
                {
                    double tmphasil = hasilrangking[i];
                    String tmpalternatif = alternatifrangking[i];
                    hasilrangking[i] = hasilrangking[j];
                    alternatifrangking[i] = alternatifrangking[j];
                    hasilrangking[j] = tmphasil;
                    alternatifrangking[j] = tmpalternatif;
                }
            }
        }

        Display display = getWindowManager().getDefaultDisplay();

        ScrollView sv = (ScrollView)findViewById(R.id.svAnalisa); // new ScrollView(this);
        //ViewGroup.LayoutParams lp = new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
        //sv.setLayoutParams(lp);
        LinearLayout l = new LinearLayout(this);
        l.setOrientation(LinearLayout.VERTICAL);
        sv.addView(l);
        HorizontalScrollView hv = new HorizontalScrollView(this);
        ViewGroup.LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        hv.setLayoutParams(lp);
        l.addView(hv);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setMinimumWidth(700);


        final LinearLayout llhasil = new LinearLayout(this);

        Button btnshow = new Button(this);
        btnshow.setText("Hitung");
        btnshow.setBackgroundColor(Color.parseColor("#3B71CA"));
        btnshow.setTypeface(Typeface.DEFAULT_BOLD);
        btnshow.setTextColor(Color.parseColor("#FFFFFFFF"));
        btnshow.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT)); // Width(50);
        btnshow.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                llhasil.setVisibility(View.VISIBLE);
            }
        });
        ll.addView(btnshow);

        llhasil.setOrientation(LinearLayout.VERTICAL);
        llhasil.setVisibility(View.GONE);
        ll.addView(llhasil);

        TextView tvalternatif = new TextView(this);
        tvalternatif.setText("Alternatif :");
        tvalternatif.setTextColor(Color.parseColor("#0000ff"));
        tvalternatif.setTypeface(Typeface.DEFAULT_BOLD);
        //tvalternatif.setWidth(100);
        llhasil.addView(tvalternatif);
        LinearLayout llalternatif = tampilbaris(alternatif);
        llalternatif.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llalternatif);

        TextView tvkriteria = new TextView(this);
        tvkriteria.setText("Kriteria :");
        tvkriteria.setTextColor(Color.parseColor("#0000ff"));
        tvkriteria.setTypeface(Typeface.DEFAULT_BOLD);
        //tvkriteria.setWidth(100);
        llhasil.addView(tvkriteria);
        LinearLayout llkriteria = tampilbaris(kriteria);
        llkriteria.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llkriteria);

        TextView tvcostbenefit = new TextView(this);
        tvcostbenefit.setText("CostBenefit :");
        tvcostbenefit.setTextColor(Color.parseColor("#0000ff"));
        tvcostbenefit.setTypeface(Typeface.DEFAULT_BOLD);
        //tvcostbenefit.setWidth(100);
        llhasil.addView(tvcostbenefit);
        LinearLayout llcostbenefit = tampilbaris(costbenefit);
        llcostbenefit.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llcostbenefit);

        TextView tvkepentingan = new TextView(this);
        tvkepentingan.setText("Kepentingan :");
        tvkepentingan.setTextColor(Color.parseColor("#0000ff"));
        tvkepentingan.setTypeface(Typeface.DEFAULT_BOLD);
        //tvkepentingan.setWidth(100);
        llhasil.addView(tvkepentingan);
        LinearLayout llkepentingan = tampilbaris(kepentingan);
        llkepentingan.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llkepentingan);

        TextView tvalternatifkriteria = new TextView(this);
        tvalternatifkriteria.setText("Alternatif :");
        tvalternatifkriteria.setTextColor(Color.parseColor("#0000ff"));
        tvalternatifkriteria.setTypeface(Typeface.DEFAULT_BOLD);
        //tvalternatifkriteria.setWidth(100);
        llhasil.addView(tvalternatifkriteria);
        LinearLayout llalternatifkriteria = tampiltabel(alternatifkriteria);
        llalternatifkriteria.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llalternatifkriteria);

        TextView tvpembagi = new TextView(this);
        tvpembagi.setText("Pembagi :");
        tvpembagi.setTextColor(Color.parseColor("#0000ff"));
        tvpembagi.setTypeface(Typeface.DEFAULT_BOLD);
        //tvpembagi.setWidth(100);
        llhasil.addView(tvpembagi);
        LinearLayout llpembagi = tampilbaris(pembagi);
        llpembagi.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llpembagi);

        TextView tvnormalisasi = new TextView(this);
        tvnormalisasi.setText("Normalisasi :");
        tvnormalisasi.setTextColor(Color.parseColor("#0000ff"));
        tvnormalisasi.setTypeface(Typeface.DEFAULT_BOLD);
        //tvnormalisasi.setWidth(100);
        llhasil.addView(tvnormalisasi);
        LinearLayout llnormalisasi = tampiltabel(normalisasi);
        llnormalisasi.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llnormalisasi);

        TextView tvhasil = new TextView(this);
        tvhasil.setText("Hasil :");
        tvhasil.setTextColor(Color.parseColor("#0000ff"));
        tvhasil.setTypeface(Typeface.DEFAULT_BOLD);
        //tvhasil.setWidth(100);
        llhasil.addView(tvhasil);
        LinearLayout llhasil2 = tampilkolom(hasil);
        llhasil2.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llhasil2);

        TextView tvalternatifranking = new TextView(this);
        tvalternatifranking.setText("Alternatif Ranking :");
        tvalternatifranking.setTextColor(Color.parseColor("#0000ff"));
        tvalternatifranking.setTypeface(Typeface.DEFAULT_BOLD);
        //tvalternatifranking.setWidth(100);
        llhasil.addView(tvalternatifranking);
        LinearLayout llalternatifranking = tampilkolom(alternatifrangking);
        llalternatifranking.setOrientation(LinearLayout.VERTICAL);
        llhasil.addView(llalternatifranking);

        TextView tvalternatifterbaik = new TextView(this);
        tvalternatifterbaik.setText("Alternatif Terbaik = " + alternatifrangking[0] + " dengan nilai terbesar = " + Double.valueOf(hasilrangking[0]));
        tvalternatifterbaik.setTextColor(Color.parseColor("#0000ff"));
        tvalternatifterbaik.setTypeface(Typeface.DEFAULT_BOLD);
        //tvalternatifterbaik.setWidth(300);
        llhasil.addView(tvalternatifterbaik);

        hv.addView(ll);
        //this.setContentView(sv);

        Button btncek = new Button(this);
        btncek.setText("Lihat Laporan SAW");
        btncek.setBackgroundColor(Color.parseColor("#3B71CA"));
        btncek.setTypeface(Typeface.DEFAULT_BOLD);
        btncek.setTextColor(Color.parseColor("#FFFFFFFF"));
        btncek.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)); // Width(50);
        llhasil.addView(btncek);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } return false;
    }


}

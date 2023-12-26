package com.saw_android;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Calendar;

//public class AnalisaActivity extends AppCompatActivity {
public class SawStatisActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_saw_statis);

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView viewdate = findViewById(R.id.viewdate);
        viewdate.setText(currentDate);

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

        ScrollView sv = (ScrollView)findViewById(R.id.svSAW);
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

        TextView tvhasilrankingfinal = new TextView(this);
        tvhasilrankingfinal.setText("Hasil SAW");
        tvhasilrankingfinal.setTextColor(Color.parseColor("#0000ff"));
        tvhasilrankingfinal.setTypeface(Typeface.DEFAULT_BOLD);

        ViewGroup.LayoutParams lpp = new LayoutParams(display.getWidth(), LayoutParams.WRAP_CONTENT);
        tvhasilrankingfinal.setLayoutParams(lpp);
        ll.addView(tvhasilrankingfinal);

        LinearLayout llalternatifrankingfinal = new LinearLayout(this);

        LinearLayout.LayoutParams lppp = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lppp.setMargins(1, 1, 1, 1);

        llalternatifrankingfinal.setOrientation(LinearLayout.VERTICAL);

        LinearLayout llhjudul = new LinearLayout(this);
        llhjudul.setOrientation(LinearLayout.HORIZONTAL);
        llalternatifrankingfinal.addView(llhjudul);

        TextView textviewAlternatifJudul = new TextView(this);
        textviewAlternatifJudul.setText("Alternatif");
        textviewAlternatifJudul.setWidth(100);
        textviewAlternatifJudul.setTypeface(Typeface.DEFAULT_BOLD);
        textviewAlternatifJudul.setBackgroundColor(Color.parseColor("#ffffff"));
        textviewAlternatifJudul.setLayoutParams(lppp);
        textviewAlternatifJudul.setPadding(2, 2, 2, 2);
        llhjudul.addView(textviewAlternatifJudul);

        TextView textviewHasilJudul = new TextView(this);
        textviewHasilJudul.setText("Nilai");
        textviewHasilJudul.setWidth(100);
        textviewHasilJudul.setTypeface(Typeface.DEFAULT_BOLD);
        textviewHasilJudul.setBackgroundColor(Color.parseColor("#ffffff"));
        textviewHasilJudul.setLayoutParams(lppp);
        textviewHasilJudul.setPadding(2, 2, 2, 2);
        llhjudul.addView(textviewHasilJudul);

        for (int i=0; i<hasilrangking.length; i++)
        {
            LinearLayout llh = new LinearLayout(this);
            llh.setOrientation(LinearLayout.HORIZONTAL);
            llalternatifrankingfinal.addView(llh);

            TextView textviewAlternatifRanking = new TextView(this);
            int maxLength = 10;
            if (maxLength > alternatifrangking[i].length()) { maxLength = alternatifrangking[i].length(); }
            textviewAlternatifRanking.setText(alternatifrangking[i].substring(0, maxLength));
            textviewAlternatifRanking.setWidth(100);
            textviewAlternatifRanking.setTypeface(Typeface.DEFAULT_BOLD);
            textviewAlternatifRanking.setBackgroundColor(Color.parseColor("#ffffff"));
            textviewAlternatifRanking.setLayoutParams(lppp);
            textviewAlternatifRanking.setPadding(2, 2, 2, 2);
            llh.addView(textviewAlternatifRanking);

            TextView textviewHasilRanking = new TextView(this);
            maxLength = 8;
            if (maxLength > String.valueOf(hasilrangking[i]).length()) { maxLength = String.valueOf(hasilrangking[i]).length(); }
            textviewHasilRanking.setText(String.valueOf(hasilrangking[i]).substring(0, maxLength));
            textviewHasilRanking.setWidth(100);
            textviewHasilRanking.setTypeface(Typeface.DEFAULT_BOLD);
            textviewHasilRanking.setBackgroundColor(Color.parseColor("#ffffff"));
            textviewHasilRanking.setLayoutParams(lppp);
            textviewHasilRanking.setPadding(2, 2, 2, 2);
            llh.addView(textviewHasilRanking);
        }

        llalternatifrankingfinal.setBackgroundColor(Color.parseColor("#0000ff"));
        llalternatifrankingfinal.setLayoutParams(lppp);
        llalternatifrankingfinal.setPadding(1, 1, 1, 1);

        llalternatifrankingfinal.setOrientation(LinearLayout.VERTICAL);
        ll.addView(llalternatifrankingfinal);

        TextView tvalternatifterbaikfinal = new TextView(this);
        tvalternatifterbaikfinal.setText("Alternatif Terbaik = " + alternatifrangking[0] + " dengan nilai terbesar = " + Double.valueOf(hasilrangking[0]));
        tvalternatifterbaikfinal.setTextColor(Color.parseColor("#0000ff"));
        tvalternatifterbaikfinal.setTypeface(Typeface.DEFAULT_BOLD);

        ll.addView(tvalternatifterbaikfinal);

        hv.addView(ll);
    }

}

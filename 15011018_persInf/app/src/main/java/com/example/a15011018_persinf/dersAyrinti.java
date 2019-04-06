package com.example.a15011018_persinf;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class dersAyrinti extends AppCompatActivity {
    ArrayList<Ders> dersler = new ArrayList<>();
    TextView dersAdi ,hocaAdi, notOrt, ogrSayisi;
    String dersAdiString, hocaAdiString, notOrtString, ogrSayisiString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ders_ayrinti);

        Intent intent = getIntent();
        hocaAdiString = intent.getStringExtra("hocaAdi");
        dersAdiString = intent.getStringExtra("dersAdi");
        notOrtString     = intent.getStringExtra("notOrt");
        ogrSayisiString  = intent.getStringExtra("ogrSayisi");

        dersAdi   = (TextView) findViewById(R.id.ayrintiEditTextDersAdi);
        hocaAdi   = (TextView) findViewById(R.id.ayrintiEditTextDersHocasi);
        notOrt    = (TextView) findViewById(R.id.ayrintiEditTextDersNotOrt);
        ogrSayisi = (TextView) findViewById(R.id.ayrintiEditTextOgrSayisi);

        dersAdi.setText(dersAdiString);
        hocaAdi.setText(hocaAdiString);
        notOrt.setText(notOrtString);
        ogrSayisi.setText(ogrSayisiString);
    }
}

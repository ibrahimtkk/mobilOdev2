package com.example.a15011018_persinf;


import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;


public class derslerimActivity extends AppCompatActivity {
    private ArrayList<Ders> dersler;
    private String uri="drawable/m_amac_guvensan";
    private static final String TAG = "derslerimActivity";
    private Drawable imageDrawable;
    private ArrayList<Drawable> drawableArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_derslerim);
        Log.d(TAG, "onCreate: started.");

        /* Ders ekleme */
        dersler = new ArrayList<>();
        dersler.add(new Ders("BBG1", "BA", "85", "38"));
        dersler.add(new Ders("BBG2", "AA", "75", "43"));
        dersler.add(new Ders("Sayısal Analiz", "AA", "90", "65"));
        dersler.add(new Ders("Yapay Zeka", "AA", "50", "42"));
        dersler.add(new Ders("Derin Öğrenme", "BA", "50", "43"));
        dersler.add(new Ders("Robotik", "BB", "30", "35"));
        dersler.add(new Ders("Veri Yapıları", "BA", "150", "30"));

        initImageBitmaps();

    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        int imageResource, i;
        drawableArrayList = new ArrayList<>();

        for (i=0; i<dersler.size(); i++) {
            imageResource = getResources().getIdentifier(dersler.get(i).getUri(), null, getPackageName());
            imageDrawable = ResourcesCompat.getDrawable(getResources(), imageResource, null);
            drawableArrayList.add(imageDrawable);
        }


        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerViewDersler);
        MyAdapter adapter = new MyAdapter(this, drawableArrayList, dersler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

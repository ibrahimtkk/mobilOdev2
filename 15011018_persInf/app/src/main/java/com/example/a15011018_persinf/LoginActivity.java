package com.example.a15011018_persinf;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    EditText kullaniciAdi, parola;
    Button giris;
    TextView alertTextView;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        kullaniciAdi = (EditText) findViewById(R.id.editTextKullaniciAdi);
        parola = (EditText) findViewById(R.id.editTextParola);
        giris = (Button) findViewById(R.id.buttonGiris);
        giris.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("degerler: -", kullaniciAdi.getText().toString());
        Log.d("degerler: -", parola.getText().toString());
        if ( kullaniciAdi.getText().toString().equals("admin") &&  parola.getText().toString().equals("password") ) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Kullanıcı Adı veya Parola Hatalı", Toast.LENGTH_SHORT).show();
            //alertTextView = (TextView) findViewById(R.id.AlertTextView);
            //AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
            //builder.setCancelable(true);
            //builder.setTitle("Hata");
            //builder.setMessage("Kullanıcı Adı veya Parola Hatalı");
            //builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            //    @Override
            //    public void onClick(DialogInterface dialog, int which) {
            //        alertTextView.setVisibility(View.VISIBLE);
            //    }
            //});
            //builder.show();
        }
    }


}

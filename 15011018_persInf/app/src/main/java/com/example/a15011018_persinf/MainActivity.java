package com.example.a15011018_persinf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText isim, soyisim, kimlikNo, telNo, eMail;
    private Button kaydet, resimSec, temizle;
    private ArrayList<String> bilgiler = new ArrayList<String>();
    private ImageView imageView;
    private static final int PICK_IMAGE=100;
    SharedPreferences sharedPreferences;
    Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isim      = (EditText) findViewById(R.id.editTextIsim);
        soyisim   = (EditText) findViewById(R.id.editTextSoyisim);
        eMail     = (EditText) findViewById(R.id.editTextEmail);
        kimlikNo  = (EditText) findViewById(R.id.editTextKimlikNo);
        telNo     = (EditText) findViewById(R.id.editTextTelNo);
        imageView = (ImageView) findViewById(R.id.imageViewResimSec);

        kaydet   = (Button) findViewById(R.id.buttonKaydet);
        resimSec = (Button) findViewById(R.id.buttonResimSec);
        temizle  = (Button) findViewById(R.id.buttonTemizle);

        resimSec.setOnClickListener(this);
        kaydet.setOnClickListener(this);
        temizle.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonKaydet) {
            Intent intent = new Intent(MainActivity.this, ikinciActivity.class);

            bilgiler.add(isim.getText().toString());
            bilgiler.add(soyisim.getText().toString());
            bilgiler.add(eMail.getText().toString());
            bilgiler.add(kimlikNo.getText().toString());
            bilgiler.add(telNo.getText().toString());

            imageView.setDrawingCacheEnabled(true);
            Bitmap bitmap = imageView.getDrawingCache();

            intent.putExtra("bitmap", bitmap);
            intent.putExtra("bilgilerString", bilgiler);

            startActivity(intent);




        }
        else if (v.getId() == R.id.buttonResimSec){
            openGallery();
        }
        else if (v.getId() == R.id.buttonTemizle){
            isim.setText("");
            soyisim.setText("");
            eMail.setText("");
            kimlikNo.setText("");
            telNo.setText("");
        }
    }

    private void openGallery(){
        //Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode== RESULT_OK){
            imageUri = data.getData();
            Picasso
                    .with(this)
                    .load(imageUri)
                    .noPlaceholder()
                    .centerCrop()
                    .fit()
                    .into(imageView);
            //imageView.setImageURI(imageUri);
        }
    }
}

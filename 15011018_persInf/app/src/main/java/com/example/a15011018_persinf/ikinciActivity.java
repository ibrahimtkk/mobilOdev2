package com.example.a15011018_persinf;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ikinciActivity extends AppCompatActivity implements View.OnClickListener {

    //Integer yasFarki;
    ArrayList bilg = new ArrayList<>();
    TextView isim, soyisim, eMail, kimlikNo, telNo;
    ImageButton phone, mail;
    Button derslerim, temizle;
    ImageView imageView;
    Bitmap bitmap;
    //Calendar cal = Calendar.getInstance();
    //DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    //Date date = new Date();
    //String[] todayDateString, bDateString, bosluksuzDateString;
    /* dateFormat.format(date): 2019/03/26 00:36:25 */
    /* Log.d("MainActivity22: ", dateFormat.format(date)); */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci);

        isim     = (TextView) findViewById(R.id.textViewIsim2);
        soyisim  = (TextView) findViewById(R.id.textViewSoyisim2);
        eMail    = (TextView) findViewById(R.id.textViewEmail2);
        kimlikNo = (TextView) findViewById(R.id.textViewKimlikNo2);
        telNo    = (TextView) findViewById(R.id.textViewTelNo2);

        imageView = (ImageView) findViewById(R.id.imageViewIkinci);

        phone   = (ImageButton) findViewById(R.id.imageButtonPhone);
        mail    = (ImageButton) findViewById(R.id.imageButtonEmail);

        derslerim = (Button) findViewById(R.id.buttonDerslerim);


        derslerim.setOnClickListener(this);
        phone.setOnClickListener(this);
        mail.setOnClickListener(this);

        Intent intent = getIntent();
        bilg = intent.getStringArrayListExtra("bilgilerString");
        bitmap = (Bitmap) intent.getParcelableExtra("bitmap");
        imageView.setImageBitmap(bitmap);

        //bosluksuzDateString = dateFormat.format(date).split(" ");
        //todayDateString = bosluksuzDateString[0].split("/");
        //bDateString = bilg.get(3).toString().split("/");

        //Log.d("Main: ", todayDateString[2]);
        //Log.d("Main2: ", bDateString[2]);
        //yasFarki = Integer.parseInt(todayDateString[2]) - Integer.parseInt(bDateString[2]);
        //Log.d("Main3: ", bilg.get(5).toString());



        isim.setText( bilg.get(0).toString() );
        soyisim.setText( bilg.get(1).toString() );
        eMail.setText( bilg.get(2).toString() );
        kimlikNo.setText( bilg.get(3).toString() );
        telNo.setText( bilg.get(4).toString() );

    }


    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.imageButtonPhone) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + bilg.get(4).toString()));
            startActivity(intent);
        }
        else if (v.getId() == R.id.buttonDerslerim){
            Intent intent = new Intent(ikinciActivity.this, derslerimActivity.class);
            intent.putExtra("bilgilerString", "mesela");
            Log.d("gecerken", "geçti");
            startActivity(intent);
        }
        else if (v.getId() == R.id.imageButtonEmail){
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, eMail.getText());
            intent.putExtra(Intent.EXTRA_SUBJECT, "Mobil Odev2");
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Send mail..."));
            finish();
        }

    }
}

package com.example.user.imsswebtarjeton;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {

    AdView madView;
    InterstitialAd mInterstitialAd;
    ImageButton[] buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        madView = findViewById(R.id.adView4);
        AdRequest adRequest = new AdRequest.Builder().build();
        madView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1984616735532779/3485796591");
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest1);


        //INSTANCIA de los id's de los buttons
        final int iDs[] = {R.id.imageButton,R.id.imageButton2,R.id.imageButton3,R.id.imageButton4,R.id.imageButton5,R.id.imageButton6};

        //INSTANCIA para los buttons
        buttons = new ImageButton[6];
        for(int i =0; i<6; i++)
            buttons[i] = (ImageButton) findViewById(iDs[i]);

        //SET del onClickListener de cada button
        for(int i =0; i<6; i++)
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(view.getId()){ //Obtenemos el ID del button que ha sido clickeado
                        case R.id.imageButton:
                            Intent intent1 = new Intent(com.example.user.imsswebtarjeton.MainActivity.this,Contrato.class);
                            startActivity(intent1);
                            break;
                        case R.id.imageButton2:
                            Intent intentaeS = new Intent(com.example.user.imsswebtarjeton.MainActivity.this,Calendario.class);
                            startActivity(intentaeS);
                            break;
                        case R.id.imageButton3:
                            Intent intentds = new Intent(com.example.user.imsswebtarjeton.MainActivity.this,Conveniot.class);

                            startActivity(intentds);
                            break;

                        case R.id.imageButton4:
                            Intent intentdsss = new Intent(com.example.user.imsswebtarjeton.MainActivity.this,Sueldo.class);
                            startActivity(intentdsss);
                            break;

                        case R.id.imageButton6:
                            Intent intentdsss2 = new Intent(com.example.user.imsswebtarjeton.MainActivity.this,Concepto.class);
                            startActivity(intentdsss2);
                            break;

                        case R.id.imageButton5:

                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                            }else {
                                Intent intentae = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.sntss.org.mx/requerimientos/leyes-y-reglamentos-gfee"));
                                startActivity(intentae);}
                            break;





                    }
                }
            });


    }

}


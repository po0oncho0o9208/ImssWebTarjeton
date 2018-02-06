package com.example.user.imsswebtarjeton;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class MenuPrincipal extends AppCompatActivity {
    InterstitialAd mInterstitialAd;
    AdView mAdView;
    Button[] buttons;
    SharedPreferences preferences;


    public void createSimpleDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("En esta aplicacion no se piden datos, solo te lleva a la pagina\n" +
                "oficial del IMSS para descargar el tarjeton tanto activos como jubilados\n" +
                "Tambien obtendras algunos documentos de consulta");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "LEIDO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createSimpleDialog();

        setContentView(R.layout.activity_menu_principal);

        mAdView = findViewById(R.id.adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-1984616735532779/3485796591");
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest1);






    //INSTANCIA de los id's de los buttons
        final int iDs[] = {R.id.activ,R.id.jubilad,R.id.docum,R.id.seguir};

        //INSTANCIA para los buttons
        buttons = new Button[4];
        for(int i =0; i<4; i++)
            buttons[i] = (Button)findViewById(iDs[i]);

        //SET del onClickListener de cada button
        for(int i =0; i<4; i++)
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch(view.getId()){ //Obtenemos el ID del button que ha sido clickeado
                        case R.id.activ:
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                            }else {
                                Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rh.imss.gob.mx/tarjetondigital/"));
                                startActivity(intent1);}
                            break;
                        case R.id.jubilad:
                            if (mInterstitialAd.isLoaded()){
                                mInterstitialAd.show();
                            }else {
                                Intent intentae = new Intent(Intent.ACTION_VIEW, Uri.parse("http://rh.imss.gob.mx/tarjetonjubilados/(S(afzkevxvymx14vcajnskmjbf))/default.aspx"));
                                startActivity(intentae);}
                            break;


                        case R.id.docum:
                            Intent intentds1s = new Intent(MenuPrincipal.this,MainActivity.class);
                            startActivity(intentds1s);
                            break;

                        case R.id.seguir:
                            Intent intentae = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/tarjetondigitalimss/"));
                            startActivity(intentae);
                            break;



                    }
                }
            });




    }


}



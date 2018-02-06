package com.example.user.imsswebtarjeton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class Concepto extends AppCompatActivity {
    PDFView pdfView;
    AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concepto);
        mAdView = findViewById(R.id.adView9);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        pdfView = (PDFView)findViewById(R.id.pdfView);
        //  pdfView.fromFile("Convenio.pdf").load();
        pdfView.fromAsset("concepto.pdf").load();


        //PDFView.fromAsset("Conveni.pdf").load();
    }
}

package com.uinmalang.ahmadriza.apik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Makanan extends AppCompatActivity {

    int berat=0;
    double[] kalori;

    TextView lblPokok;
    TextView lblLauk;
    TextView lblRingan;
    TextView lblSayur;
    TextView lblBuah;
    TextView lblMinum;


    int kategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        kalori=new double[3];
        Bundle  extras = getIntent().getExtras();
        if (extras!=null){
            kalori=extras.getDoubleArray("Kalori");
        }

        //init view
        lblPokok=(TextView)findViewById(R.id.lblPokok);
        lblLauk=(TextView)findViewById(R.id.lblLauk);
        lblRingan=(TextView)findViewById(R.id.lblRingan);
        lblBuah=(TextView)findViewById(R.id.lblBuah);
        lblSayur=(TextView)findViewById(R.id.lblSayur);
        lblMinum=(TextView)findViewById(R.id.lblMinum);

        //action listener
        lblPokok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                i.putExtra("KATEGORI",0);
                startActivity(i);
                finish();
            }
        });

        lblLauk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                i.putExtra("KATEGORI",1);
                startActivity(i);
                finish();
            }
        });

        lblRingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SearchMakanan.class);
                i.putExtra("KATEGORI",2);
                startActivity(i);
                finish();
            }
        });





    }

}

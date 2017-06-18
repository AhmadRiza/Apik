package com.uinmalang.ahmadriza.apik;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.ContextThemeWrapper;
import android.widget.Button;
import android.view.View;

public class Home extends AppCompatActivity {
    Button btnCekKalori;
    Button btnHitung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //inisialisasi
        btnCekKalori=(Button)findViewById(R.id.btnCekKalori);
        btnHitung =(Button)findViewById(R.id.btnHitungKalori);

        btnCekKalori.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),FormUser.class);
                startActivity(i);
            }

        });

        btnHitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),Makanan.class);
                startActivity(i);
            }
        });

    }


    //Tombol Back kalo di pencet
    @Override
    public void onBackPressed(){
        ContextThemeWrapper ctw = new ContextThemeWrapper(this,R.style.Theme_AlertDialog_Title);
        new AlertDialog.Builder(ctw).setIcon(android.R.drawable.ic_dialog_alert).
                setTitle("Keluar").setMessage("Apa anda yakin akan keluar?").
                setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent= new Intent(Intent.ACTION_MAIN);
                intent.addCategory(intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
                System.exit(0);
            }
        }).setNegativeButton("Tidak",null).show();
    }
}

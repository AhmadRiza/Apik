package com.uinmalang.ahmadriza.apik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.uinmalang.ahmadriza.apik.Calculator.CalorieNeed;

public class FormUser extends AppCompatActivity {

    TextView txtBerat;
    TextView txtTinggi;
    TextView txtUmur;
    ImageView imgL;
    ImageView imgP;
    ImageView imgRingan;
    ImageView imgSedang;
    ImageView imgBerat;
    CheckBox chkL;
    CheckBox chkP;
    CheckBox chkRingan;
    CheckBox chkSedang;
    CheckBox chkBerat;
    Button btnLanjut;

    private int umur=0,berat=0,tinggi=0;
    private char gender=0;
    private String aktivitas="";
    private String kategoriTubuh="";
    private String kebutuhanKalori="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

        //initial view
        txtBerat = (TextView) findViewById(R.id.txtWeight);
        txtTinggi = (TextView) findViewById(R.id.txtHeight);
        txtUmur = (TextView) findViewById(R.id.txtAge);
        imgL = (ImageView) findViewById(R.id.imgL);
        imgP = (ImageView) findViewById(R.id.imgP);
        imgRingan = (ImageView) findViewById(R.id.imgRingan);
        imgSedang = (ImageView) findViewById(R.id.imgSedang);
        imgBerat = (ImageView) findViewById(R.id.imgBerat);
        chkRingan=(CheckBox) findViewById(R.id.chkRingan);
        chkSedang=(CheckBox) findViewById(R.id.chkSedang);
        chkBerat=(CheckBox) findViewById(R.id.chkBerat);
        chkP=(CheckBox) findViewById(R.id.chkP);
        chkL=(CheckBox) findViewById(R.id.chkL);
        btnLanjut=(Button) findViewById(R.id.btnLanjut);

        //gambar cowok ddi tekan
        imgL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkL.setChecked(true);
                chkP.setChecked(false);
                gender = 'L';
            }
        });

        //gambar cewek ddi tekan
        imgP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkL.setChecked(false);
                chkP.setChecked(true);
                gender = 'P';
            }
        });

        //gambar low ddi tekan
        imgRingan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkRingan.setChecked(true);
                chkSedang.setChecked(false);
                chkBerat.setChecked(false);
                aktivitas="ringan";
            }
        });

        //gambar med ddi tekan
        imgSedang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkRingan.setChecked(false);
                chkSedang.setChecked(true);
                chkBerat.setChecked(false);
                aktivitas="sedang";
            }
        });

        //gambar hi ddi tekan
        imgBerat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chkRingan.setChecked(false);
                chkSedang.setChecked(false);
                chkBerat.setChecked(true);
                aktivitas="berat";
            }
        });

        //tombol lanjut ditekan di tekan
        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate()){
                    CalorieNeed CN = new CalorieNeed(berat,tinggi,umur,gender,aktivitas);
                    kategoriTubuh=CN.getBodyCategory();
                    kebutuhanKalori=CN.getCalorieNeed();
                }else{
                    //TODO make warning dialog number exception

                    return;
                }
                //throws Result ke activity Result
                Intent intent = new Intent(getApplicationContext(), Result.class);
                Bundle extras = new Bundle();
                extras.putString("KATEGORI_TUBUH",kategoriTubuh);
                extras.putString("KEBUTUHAN_KALORI",kebutuhanKalori);
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean validate(){
        if (txtUmur.getText().toString().equals("")||
                txtBerat.getText().toString().equals("")||
                txtTinggi.getText().toString().equals("")||
                gender==0||aktivitas.equals("")
                ){
            return false;
        }

        try {
            berat = Integer.parseInt(txtBerat.getText().toString());
            tinggi = Integer.parseInt(txtTinggi.getText().toString());
            umur = Integer.parseInt(txtUmur.getText().toString());
            return true;
        }catch (NumberFormatException e){
            return false;
        }

    }




}

package com.uinmalang.ahmadriza.apik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
public class FormUser extends AppCompatActivity {


    public String gender="",nama="",aktivitas="";
    public int umur=0,berat=0,tinggi=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_user);

    }


}

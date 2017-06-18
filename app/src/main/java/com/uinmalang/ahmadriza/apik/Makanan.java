package com.uinmalang.ahmadriza.apik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Makanan extends AppCompatActivity {

    Spinner spnMknPokok;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_makanan);

        initSpinmknPokok();

        spnMknPokok.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

                Toast.makeText(parent.getContext(), "Output..." + item, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void initSpinmknPokok(){
        spnMknPokok = (Spinner) findViewById(R.id.spinnerMknPokok);

        List<String> mknPokok=new ArrayList<>();
        mknPokok.add("Nasi Beras");
        mknPokok.add("Nasi Jagung");
        mknPokok.add("Roti");
        mknPokok.add("Kentang");
        mknPokok.add("Singkong");
        mknPokok.add("Ubi Jalar");

//        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,mknPokok);
        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.makanan_pokok, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMknPokok.setAdapter(dataAdapter);

    }
}

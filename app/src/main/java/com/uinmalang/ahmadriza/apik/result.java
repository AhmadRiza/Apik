package com.uinmalang.ahmadriza.apik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    TextView txtCategory;
    TextView txtCalories;
    Button btnShare;

    String kategori="",kalori="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        //init view
        txtCategory = (TextView) findViewById(R.id.txtCategory);
        txtCalories = (TextView) findViewById(R.id.txtCalories);
        btnShare = (Button) findViewById(R.id.btnShare);

        //get passed data
        Bundle  extras = getIntent().getExtras();
        if (extras!=null){
            kategori = extras.getString("KATEGORI_TUBUH");
            kalori = extras.getString("KEBUTUHAN_KALORI");
        }

        if (kategori.equals("Kurus")){
            txtCategory.setTextColor(getResources().getColor(R.color.warning));
        }else if (kategori.equals("Gemuk")){
            txtCategory.setTextColor(getResources().getColor(R.color.danger));
        }else{
            txtCategory.setTextColor(getResources().getColor(R.color.colorAccent));
        }

        txtCategory.setText(kategori);
        txtCalories.setText(kalori);

        //share button click
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO buat share method
            }
        });
    }

}

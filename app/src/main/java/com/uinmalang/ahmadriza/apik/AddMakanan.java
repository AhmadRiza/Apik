package com.uinmalang.ahmadriza.apik;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.uinmalang.ahmadriza.apik.Model.Makanan;

public class AddMakanan extends AppCompatActivity {

    Bundle globalExtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_makanan);

        //get Passed data
        globalExtras = getIntent().getExtras();

        Button btnNewMakanan = (Button) findViewById(R.id.btnNewMakanan);
        final EditText txtNewNama = (EditText) findViewById(R.id.txtNewNama);
        final EditText txtNewKalori = (EditText) findViewById(R.id.txtNewKalori);

        btnNewMakanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newNama = "";
                double newKalori = 0;
                try{
                    newNama = txtNewNama.getText().toString().trim();
                    newKalori = Double.parseDouble(txtNewKalori.getText().toString());
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }

                if (newNama.equals("")||newKalori==0){
                    Log.e("INPUT","EMPTY!");
                    return;
                }

                globalExtras.putString(SearchMakanan.KEY_NEW_NAMA,newNama);
                globalExtras.putDouble(SearchMakanan.KEY_NEW_KALORI,newKalori);

                Intent intent = new Intent(getApplicationContext(), SearchMakanan.class);
                intent.putExtras(globalExtras);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

    }

}

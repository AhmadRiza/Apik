package com.uinmalang.ahmadriza.apik;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.uinmalang.ahmadriza.apik.DbHelper.DbHelper;
import com.uinmalang.ahmadriza.apik.Model.Makanan;

import java.io.IOException;
import java.util.List;

public class SearchMakanan extends AppCompatActivity {
    ListView listMakanan;
    EditText txtSearch;
    DbHelper db;

    String key="";
    int kategori;
    double kalori;
    List<Makanan> listRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_makanan);

        listMakanan = (ListView)findViewById(R.id.list_makanan);
        txtSearch = (EditText) findViewById(R.id.txtSearch);

        //init DB
        DbHelper db = new DbHelper(this);
        try {
            db.createDataBase();
        }catch (IOException e){
            e.printStackTrace();
        }

        //showres
        listRes=db.getMakanan(kategori,"");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        txtSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                updateVar();
                updateView();
                return true;
            }

        });
    }

    private void updateVar(){
        key=txtSearch.getText().toString();
    }

    private void updateView(){

        /*
        if (lstRanking.size()>0){
            CustomAdapter adapter = new CustomAdapter(this, lstRanking);
            lstView.setAdapter(adapter);
        }
         */
        if (listRes.size()>0){

        }
    }

}

package com.uinmalang.ahmadriza.apik.DbHelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.uinmalang.ahmadriza.apik.Model.Makanan;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmad Riza on 20/06/2017.
 */

/**
 * this is procedure to use this class
 *
     DbHelper db = new DbHelper(this);
     try {
        db.createDataBase();
     }catch (IOException e){
        e.printStackTrace();
     }
 */

public class DbHelper extends SQLiteOpenHelper {
    private static String DB_NAME = "Apik.db";
    private static String DB_PATH = "";
    private SQLiteDatabase mDataBase;
    private Context mContext=null;

    public DbHelper(Context context) {
        super(context, DB_NAME, null, 1);
        DB_PATH = context.getApplicationInfo().dataDir+"/databases/";
        openDataBase();
        Log.e("DB_PATH ",DB_PATH);
        this.mContext=context;
    }

    public void openDataBase(){
        String myPath = DB_PATH+DB_NAME;
        mDataBase=SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READWRITE);
    }

    public void copyDatabase() throws IOException{
        try {
            InputStream myInput= mContext.getAssets().open(DB_NAME);
            String outputFileName=DB_PATH+DB_NAME;
            OutputStream myOutput=new FileOutputStream(outputFileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0)
                myOutput.write(buffer,0,length);
            myOutput.flush();
            myInput.close();
            myOutput.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private boolean checkDataBase(){
        SQLiteDatabase tempDB = null;
        try {
            String myPath=DB_PATH+DB_NAME;
            tempDB=SQLiteDatabase.openDatabase(myPath,null, SQLiteDatabase.OPEN_READWRITE);
        }catch (SQLiteException e){
            e.printStackTrace();
        }
        if (tempDB!=null)
            tempDB.close();
        return tempDB!=null?true:false;
    }

    public void createDataBase() throws IOException{
        boolean isExsist=checkDataBase();
        if (isExsist){
            this.getReadableDatabase();
            try {
                copyDatabase();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void close() {
        if (mDataBase !=null)
            mDataBase.close();
        super.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * CRUD below
     */
    //TODO make crud method
    /**
     * READ MAKANAN
     * @param category
     * @param key
     * @return list makanan
     */
    public List<Makanan> getMakanan(int category, String key){
        List<Makanan> listMakanan=new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();//load data base
        Cursor c;
        //build search
        String where="WHERE jenis="+category+" ";
        if (!key.equals("")){
            where += "AND nama LIKE '%"+key+"%' ";
        }
        String query="SELECT nama FROM Makanan "+ where +" ORDER BY nama ASC";
        try {
            c=db.rawQuery(query,null);
            if (c==null){
                return null;
            }
            c.moveToFirst();
            do {
                String nama = c.getString(c.getColumnIndex("nama"));
                Double kalori=c.getDouble(c.getColumnIndex("kalori"));
                Makanan makanan = new Makanan(nama,kalori);
                listMakanan.add(makanan);
            }while (c.moveToNext());
            c.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        db.close();
        return listMakanan;
    }

    /**
     * CREATE MAKANAN
     * @param nama
     * @param jenis
     * @param kalori
     */
    public void insert(String nama,int jenis, double kalori){
        SQLiteDatabase db = this.getWritableDatabase();
        String query ="INSERT INTO Makanan (nama,jenis,kalori) VALUES ('"+nama+"',"+jenis+","+kalori+")";
        try {
            db.rawQuery(query,null);
        }catch (Exception e){
            e.printStackTrace();
        }
        db.close();
    }

}

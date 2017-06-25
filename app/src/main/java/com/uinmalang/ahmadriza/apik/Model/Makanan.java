package com.uinmalang.ahmadriza.apik.Model;

/**
 * Created by Ahmad Riza on 20/06/2017.
 */

public class Makanan {
    private String nama;
    private double kalori;

    public Makanan(String nama, double kalori) {
        this.nama = nama;
        this.kalori = kalori;
    }

    public String getNama() {
        return nama;
    }

    public double getKalori() {
        return kalori;
    }
}

package com.example.qlct_n3.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HoaDon")
public class HoaDon {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    @ColumnInfo(name = "TongTien")
    private long TongTien;
    @ColumnInfo(name = "Mota")
    private String Mota;
    @ColumnInfo(name = "SoLuong")
    private int SoLuong;
    @ColumnInfo(name = "Ngay")
    private int Ngay;

    public HoaDon(int Id, long TongTien, String Mota, int SoLuong, int Ngay) {
        this.Id = Id;
        this.TongTien = TongTien;
        this.Mota = Mota;
        this.SoLuong = SoLuong;
        this.Ngay = Ngay;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public long getTongTien() {
        return TongTien;
    }

    public void setTongTien(long TongTien) {
        this.TongTien = TongTien;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getNgay() {
        return Ngay;
    }

    public void setNgay(int Ngay) {
        this.Ngay = Ngay;
    }
}


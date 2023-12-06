package com.example.qlct_n3.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "HoaDon")
public class HoaDon {
    @PrimaryKey(autoGenerate = true)
    private int Id;

    @ColumnInfo(name = "TongTien")
    private Long TongTien;

    @ColumnInfo(name = "Mota")
    private String Mota;

    @ColumnInfo(name = "SoLuong")
    private Integer SoLuong;

    @ColumnInfo(name = "Ngay")
    private Integer Ngay;

    public HoaDon() {
    }

    public HoaDon(int Id, Long TongTien, String Mota, Integer SoLuong, Integer Ngay) {
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

    public Long getTongTien() {
        return TongTien;
    }

    public void setTongTien(Long TongTien) {
        this.TongTien = TongTien;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Integer getNgay() {
        return Ngay;
    }

    public void setNgay(Integer Ngay) {
        this.Ngay = Ngay;
    }
}



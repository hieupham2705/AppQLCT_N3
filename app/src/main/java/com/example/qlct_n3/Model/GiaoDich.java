package com.example.qlct_n3.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "GiaoDich", foreignKeys = @ForeignKey(
        entity = DanhMuc.class,
        parentColumns = "IdDanhMuc",
        childColumns = "Id",
        onDelete = ForeignKey.CASCADE
))
public class GiaoDich {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    private Integer NgayGiaoDich;
    @ColumnInfo(name = "ThangGiaoDich")
    private Integer ThangGiaoDich;
    @ColumnInfo(name = "NamGiaoDich")
    private Integer NamGiaoDich;
    @ColumnInfo(name = "Tien")
    private Long Tien;
    @ColumnInfo(name = "GhiChu")
    private String GhiChu;
    @ColumnInfo(name = "ThuChi")
    private Boolean ThuChi;
    // khoa ngoai
    @ColumnInfo(name = "IdDanhMuc")
    private Long IdDanhMuc;

    public GiaoDich(int Id, Integer NgayGiaoDich, Integer ThangGiaoDich, Integer NamGiaoDich, Long Tien, String GhiChu, Boolean ThuChi, Long IdDanhMuc) {
        this.Id = Id;
        this.NgayGiaoDich = NgayGiaoDich;
        this.ThangGiaoDich = ThangGiaoDich;
        this.NamGiaoDich = NamGiaoDich;
        this.Tien = Tien;
        this.GhiChu = GhiChu;
        this.ThuChi = ThuChi;
        this.IdDanhMuc = IdDanhMuc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Integer getNgayGiaoDich() {
        return NgayGiaoDich;
    }

    public void setNgayGiaoDich(Integer NgayGiaoDich) {
        this.NgayGiaoDich = NgayGiaoDich;
    }

    public Integer getThangGiaoDich() {
        return ThangGiaoDich;
    }

    public void setThangGiaoDich(Integer ThangGiaoDich) {
        this.ThangGiaoDich = ThangGiaoDich;
    }

    public Integer getNamGiaoDich() {
        return NamGiaoDich;
    }

    public void setNamGiaoDich(Integer NamGiaoDich) {
        this.NamGiaoDich = NamGiaoDich;
    }

    public Long getTien() {
        return Tien;
    }

    public void setTien(Long Tien) {
        this.Tien = Tien;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Boolean getThuChi() {
        return ThuChi;
    }

    public void setThuChi(Boolean ThuChi) {
        this.ThuChi = ThuChi;
    }

    public Long getIdDanhMuc() {
        return IdDanhMuc;
    }

    public void setIdDanhMuc(Long IdDanhMuc) {
        this.IdDanhMuc = IdDanhMuc;
    }
}


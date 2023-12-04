package com.example.qlct_n3.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "NguoiDung", foreignKeys = @ForeignKey(
        entity = HoaDon.class,
        parentColumns = "IdHoaDon",
        childColumns = "Id",
        onDelete = ForeignKey.CASCADE
))
public class NguoiDung {

    @PrimaryKey(autoGenerate = true)
    private int Id;
    @ColumnInfo(name = "Ten")
    private String Ten;
    @ColumnInfo(name = "Sdt")
    private String Sdt;
    @ColumnInfo(name = "KhoanChi")
    private String KhoanChi;
    @ColumnInfo(name = "TrangThai")
    private String TrangThai;
    // khoa ngoai
    @ColumnInfo(name = "IdHoaDon")
    private int IdHoaDon;

    public NguoiDung(int Id, String Ten, String Sdt, String KhoanChi, String TrangThai, int IdHoaDon) {
        this.Id = Id;
        this.Ten = Ten;
        this.Sdt = Sdt;
        this.KhoanChi = KhoanChi;
        this.TrangThai = TrangThai;
        this.IdHoaDon = IdHoaDon;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public String getKhoanChi() {
        return KhoanChi;
    }

    public void setKhoanChi(String KhoanChi) {
        this.KhoanChi = KhoanChi;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(int IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }
}


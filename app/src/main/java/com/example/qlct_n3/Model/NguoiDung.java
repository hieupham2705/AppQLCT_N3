package com.example.qlct_n3.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import com.example.qlct_n3.Model.DanhMuc;

@Entity(tableName = "NguoiDung", foreignKeys = @ForeignKey(
        entity = HoaDon.class,
        parentColumns = "Id",
        childColumns = "IdHoaDon",
        onDelete = ForeignKey.NO_ACTION
))
public class NguoiDung {

    @PrimaryKey(autoGenerate = true)
    private int id;
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
    private Integer IdHoaDon;

    public NguoiDung(int id, String Ten, String Sdt, String KhoanChi, String TrangThai, Integer IdHoaDon) {
        this.id = id;
        this.Ten = Ten;
        this.Sdt = Sdt;
        this.KhoanChi = KhoanChi;
        this.TrangThai = TrangThai;
        this.IdHoaDon = IdHoaDon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Integer getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(Integer IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }
}



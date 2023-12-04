package com.example.qlct_n3.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DanhMuc")
public class DanhMuc {
    @PrimaryKey(autoGenerate = true)
    private int Id;
    
    @ColumnInfo(name = "Icon")
    private String Icon;
    
    @ColumnInfo(name = "TenDanhMuc")
    private String TenDanhMuc;

    public DanhMuc(int Id, String Icon, String TenDanhMuc) {
        this.Id = Id;
        this.Icon = Icon;
        this.TenDanhMuc = TenDanhMuc;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getIcon() {
        return Icon;
    }

    public void setIcon(String Icon) {
        this.Icon = Icon;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }
}


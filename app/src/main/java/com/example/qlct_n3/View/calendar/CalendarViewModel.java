package com.example.qlct_n3.View.calendar;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.qlct_n3.Model.DanhMuc;
import com.example.qlct_n3.Model.GiaoDich;
import com.example.qlct_n3.base.DataBaseManager;

import java.util.List;

public class CalendarViewModel extends ViewModel {
    private MutableLiveData<Long> _idGiaoDich = new MutableLiveData<>();

    public LiveData<Long> idGiaoDich() {
        return _idGiaoDich;
    }
    private MutableLiveData<List<GiaoDich>> _giaoDichNTN = new MutableLiveData<>();

    public LiveData<List<GiaoDich>> giaoDichNTN() {
        return _giaoDichNTN;
    }

    private MutableLiveData<List<Long>> _giaoDichChiThang = new MutableLiveData<>();

    public LiveData<List<Long>> giaoDichChiThang() {
        return _giaoDichChiThang;
    }

    private MutableLiveData<List<Long>> _giaoDichThuThang = new MutableLiveData<>();

    public LiveData<List<Long>> giaoDichThuThang() {
        return _giaoDichThuThang;
    }

    private MutableLiveData<DanhMuc> _danhmuc = new MutableLiveData<>();

    public LiveData<DanhMuc> danhMuc() {
        return _danhmuc;
    }

    public void getGiaoDichNTN(Context context, int day, int month, int year) {
        _giaoDichNTN.setValue(DataBaseManager.getInstance(context).getItemDAO()
                .timKiemGiaoDichChiTheoNgayThangNam(day, month, year));
    }

    public void getGiaoDichChiThang(Context context, int month) {
        _giaoDichChiThang.setValue(DataBaseManager.getInstance(context).getItemDAO()
                .timKiemGiaoDichChiTheoThang(month));
    }

    public void getGiaoDichThuThang(Context context, int month) {
        _giaoDichThuThang.setValue(DataBaseManager.getInstance(context).getItemDAO()
                .timKiemGiaoDichThuTheoThang(month));
    }

    public void delete(Context context, GiaoDich giaoDich) {
        DataBaseManager.getInstance(context).getItemDAO().xoaGiaoDich(giaoDich);
    }

    public void getDanhMuc(Context context, int id) {
         _danhmuc.setValue(DataBaseManager.getInstance(context).getItemDAO().timKiemDanhMuc(id));
    }
    public void setIdGiaoDich(Context context, Long id) {
         _idGiaoDich.setValue(id);
    }
}

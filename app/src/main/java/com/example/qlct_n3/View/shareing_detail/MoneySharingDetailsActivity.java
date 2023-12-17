package com.example.qlct_n3.View.shareing_detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;

import com.example.Constants;
import com.example.qlct_n3.Model.HoaDon;
import com.example.qlct_n3.Model.NguoiDung;
import com.example.qlct_n3.R;
import com.example.qlct_n3.databinding.ActivityMoneySharingDetailsBinding;

import java.util.ArrayList;
import java.util.List;

public class MoneySharingDetailsActivity extends AppCompatActivity {
    private static final String TAG = "MoneySharingDetailsActi";
    private Long idHoaDon;
    ActivityMoneySharingDetailsBinding binding;
    MoneySharingDetailsViewModel viewModel;
    ShareMoneyDetailAdapter adapter;
    List<NguoiDung> listNguoiDung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoneySharingDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new ShareMoneyDetailAdapter(this, new ShareMoneyDetailAdapter.ClickListener() {
            @Override
            public void onClickDone(NguoiDung nguoiDung) {
                Done(nguoiDung);
            }
        });
        viewModel = new ViewModelProvider(this).get(MoneySharingDetailsViewModel.class);
        listNguoiDung = new ArrayList<>();
        idHoaDon = getIntent().getLongExtra("id", -1);
        binding.recyclerview.setAdapter(adapter);
        onClick();
        getData();
    }

    private void getData() {
        if (idHoaDon != -1) {
            viewModel.getAllMember(idHoaDon, this);
            viewModel.getHoaDon(idHoaDon, this);
            viewModel.nguoiDungs().observe(this, new Observer<List<NguoiDung>>() {
                @Override
                public void onChanged(List<NguoiDung> list) {
                    adapter.setAdapter(list);
                }
            });
            viewModel.hoaDon().observe(this, new Observer<HoaDon>() {
                @Override
                public void onChanged(HoaDon hoaDon) {
                    binding.tvQuantity.setText(hoaDon.getSoLuong() + "");
                    binding.tvTotalMoney.setText(hoaDon.getTongTien() + "");
                    binding.tvDescribe.setText(hoaDon.getMota() + "");
                    binding.tvDetails.setText(hoaDon.getNgay() + "");
                }
            });
        }
    }
    private void onClick() {
        binding.imbtnBack.setOnClickListener(view -> {
            finish();
        });
        binding.btnBack.setOnClickListener(view -> {
            finish();
        });
    }

    private void Done(NguoiDung nguoiDung) {
        nguoiDung.setTrangThai(true);
        nguoiDung.setKhoanChi(0L);
        viewModel.editMember(nguoiDung, this);
        getData();
    }
}
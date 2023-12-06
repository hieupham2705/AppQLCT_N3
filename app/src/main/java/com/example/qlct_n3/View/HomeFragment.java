package com.example.qlct_n3.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.qlct_n3.Model.DanhMuc;
import com.example.qlct_n3.R;
import com.example.qlct_n3.base.DataBaseManager;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class HomeFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        MutableLiveData<List<DanhMuc>> list = new MutableLiveData<>();
        list.setValue(DataBaseManager.getInstance(requireContext()).getItemDAO().timKiemDanhMucThu());
        return inflater.inflate(R.layout.fragment_home, container, false);

    }
}
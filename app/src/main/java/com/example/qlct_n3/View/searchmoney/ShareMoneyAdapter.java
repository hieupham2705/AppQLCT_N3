package com.example.qlct_n3.View.searchmoney;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlct_n3.Model.NguoiDung;
import com.example.qlct_n3.databinding.ItemDirectoryBinding;
import com.example.qlct_n3.databinding.ItemMoneySharingDetailsBinding;

import java.util.ArrayList;
import java.util.List;

public class ShareMoneyAdapter extends RecyclerView.Adapter<ShareMoneyAdapter.ViewHolder> {
    private List<NguoiDung> listAdapter = new ArrayList<>();
    @NonNull
    @Override
    public ShareMoneyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMoneySharingDetailsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ShareMoneyAdapter.ViewHolder holder, int position) {
        holder.binding.tvMoney.setText(listAdapter.get(position).getKhoanChi().toString()+"đ");
        holder.binding.tvName.setText(listAdapter.get(position).getTen());
    }
    @Override
    public int getItemCount() {
        return listAdapter.size();
    }
    public void setAdapter(List<NguoiDung> list){
        listAdapter.clear();
        listAdapter.addAll(list);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ItemMoneySharingDetailsBinding binding;

        public ViewHolder(ItemMoneySharingDetailsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}

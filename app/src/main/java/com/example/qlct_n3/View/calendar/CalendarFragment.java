package com.example.qlct_n3.View.calendar;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.qlct_n3.Model.GiaoDich;
import com.example.qlct_n3.Model.SpendingInCalendar;
import com.example.qlct_n3.R;
import com.example.qlct_n3.databinding.FragmentCalendarBinding;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalendarFragment extends Fragment {
    private FragmentCalendarBinding binding;
    private static final String TAG = "CalendarFragment";
    private List<GiaoDich> listSpending;
    private List<SpendingInCalendar> listAdapter;
    private CalendarAdapter adapter;
    private Calendar calendar;
    private CalendarViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calendar = Calendar.getInstance();
        listAdapter = new ArrayList<>();
        listSpending = new ArrayList<>();
        viewModel = new ViewModelProvider(this).get(CalendarViewModel.class);
        binding = FragmentCalendarBinding.inflate(getLayoutInflater());
        adapter = new CalendarAdapter(new CalendarAdapter.ClickListener() {
            @Override
            public void onClickDelete() {
                clickDelete();
            }
        }, requireContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding.calendarView2.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                Log.e(TAG, "onCreateView: " + i1);
                calendar.set(i, i1, i2);
                getData(i, i1 + 1, i2);
            }
        });

        binding.recyclerview.setAdapter(adapter);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        getData(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH) + 1,
                calendar.get(Calendar.DAY_OF_MONTH)
        );
        super.onStart();
    }

    @Override
    public void onResume() {
        getData(
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH) + 1,
            calendar.get(Calendar.DAY_OF_MONTH)
        );
        super.onResume();
    }

    private void getData(int year, int month, int day) {
        viewModel.getGiaoDichNTN(requireContext(), day, month, year);
        viewModel.getGiaoDichChiThang(requireContext(), month);
        viewModel.getGiaoDichThuThang(requireContext(), month);
        viewModel.giaoDichNTN().observe(this, new Observer<List<GiaoDich>>() {
            @Override
            public void onChanged(List<GiaoDich> giaoDiches) {
                listAdapter.clear();
                listSpending.clear();
                listSpending.addAll(giaoDiches);
                for (GiaoDich giaoDich : giaoDiches) {
                    SpendingInCalendar spendingInCalendar = new SpendingInCalendar(giaoDich.getIdDanhMuc(), giaoDich.getIdDanhMuc(), giaoDich.getId(), giaoDich.getTien(), giaoDich.getThuChi());
                    listAdapter.add(spendingInCalendar);
                }
                adapter.setAdapter(day + "/" + month + "/" + year, listAdapter);
            }
        });
        viewModel.giaoDichChiThang().observe(this, new Observer<List<Long>>() {
            @Override
            public void onChanged(List<Long> longs) {
                long totalSpending = longs.stream().reduce(0L, Long::sum);
                binding.tvSpendingMoney.setText(totalSpending + " đ");
                viewModel.giaoDichThuThang().observe(getViewLifecycleOwner(), new Observer<List<Long>>() {
                    @Override
                    public void onChanged(List<Long> longs) {
                        long totalRevenue = longs.stream().reduce(0L, Long::sum);
                        binding.tvRevenue.setText(totalRevenue + " đ");
                        binding.tvTotal.setText((totalRevenue - totalSpending) + " đ");
                    }
                });
            }
        });

    }

    private void clickDelete() {
        showYesNoDialog();
    }

    private void showYesNoDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Câu hỏi")
                .setMessage(
                        "Bạn có chắc chắn muốn xóa mục? Thao tác này không thể\n" +
                                "hoàn tác lại."
                )
                .setPositiveButton("Yes", (dialog, which) -> {
                    try {
                        viewModel.delete(requireContext(), listSpending.get(adapter.getIndex()));
                        getData(
                                calendar.get(Calendar.YEAR),
                                calendar.get(Calendar.MONTH) + 1,
                                calendar.get(Calendar.DAY_OF_MONTH)
                        );
                    } catch (Exception e) {
                        Log.e(TAG, "showYesNoDialog: " + e.getMessage());

                    }

                    dialog.dismiss();
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss();
                });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
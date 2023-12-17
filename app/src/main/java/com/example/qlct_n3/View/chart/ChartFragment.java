package com.example.qlct_n3.View.chart;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anychart.anychart.AnyChart;
import com.anychart.anychart.DataEntry;
import com.anychart.anychart.Pie;
import com.anychart.anychart.ValueDataEntry;
import com.example.qlct_n3.Model.GiaoDich;
import com.example.qlct_n3.Model.SpendingInChart;
import com.example.qlct_n3.R;
import com.example.qlct_n3.base.DataBaseManager;
import com.example.qlct_n3.databinding.FragmentChartBinding;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class ChartFragment extends Fragment {
    private static final String TAG = "ChartFragment";
    private ChartViewModel viewModel;
    private FragmentChartBinding binding;
    private ChartAdapter adapter;
    private Calendar calendar;
    private int rv;
    private int spd;
    private Pie pie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentChartBinding.inflate(getLayoutInflater());
        viewModel = new ViewModelProvider(this).get(ChartViewModel.class);
        adapter = new ChartAdapter();
        calendar = Calendar.getInstance();
        rv = 0;
        spd = 0;
        pie = AnyChart.pie();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loadView();
        return binding.getRoot();
    }

    private void loadView() {
        binding.recyclerview.setAdapter(adapter);
        binding.tapLayout.addTab(binding.tapLayout.newTab().setText("Chi tiêu"));
        binding.tapLayout.addTab(binding.tapLayout.newTab().setText("Thu nhập"));
        createDataChart();
        binding.tvMonth.setText("Tháng " + (calendar.get(Calendar.MONTH) + 1));

        binding.tapLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        spendingAdapter();
                        break;
                    default:
                        revenueAdapter();
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        spendingAdapter();
                        break;
                    default:
                        revenueAdapter();
                        break;
                }
            }
        });

        binding.imvBackNonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH, -1);
                String selectedDate = String.valueOf(calendar.get(Calendar.MONTH) + 1);
                binding.tvMonth.setText("Tháng " + selectedDate);
                check();
            }
        });

        binding.imvIncreaseMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar.add(Calendar.MONTH, 1);
                String selectedDate = String.valueOf(calendar.get(Calendar.MONTH) + 1);
                binding.tvMonth.setText("Tháng " + selectedDate);
                check();
            }
        });
    }

    private void spendingAdapter() {
        List<DataEntry> dataEntries = new ArrayList<>();
        List<SpendingInChart> spendingInChart = new ArrayList<>();
        adapter.setAdapter(spendingInChart);
        viewModel.get_SpendingInChartChi(requireContext(), calendar.get(Calendar.MONTH) + 1);
        viewModel.SpendingInChartChi().observe(getViewLifecycleOwner(), new Observer<List<SpendingInChart>>() {
            @Override
            public void onChanged(List<SpendingInChart> spendingInCharts) {
                spd = 0;
                if (spendingInCharts.isEmpty()) {
                    binding.anyChart.setVisibility(View.GONE);
                    binding.tvNothing.setVisibility(View.VISIBLE);
                } else {
                    Map<String, List<SpendingInChart>> listMap = spendingInCharts.stream().collect(Collectors.groupingBy(SpendingInChart::getTenDanhMuc));
                    listMap.forEach((_tenDanhMuc, list) -> {
                        SpendingInChart s = new SpendingInChart(
                                list.stream().mapToLong(SpendingInChart::getTien).sum(),
                                _tenDanhMuc,
                                list.get(0).getIcon()
                        );
                        spendingInChart.add(s);
                        dataEntries.add(new ValueDataEntry(s.getTenDanhMuc(), s.getTien()));
                        spd -= s.getTien();
                    });
                    pie.setData(dataEntries);
                    binding.anyChart.setVisibility(View.VISIBLE);
                    binding.tvNothing.setVisibility(View.GONE);
                    adapter.setAdapter(spendingInChart);
                }
                updateTotal();
            }
        });
    }

    private void revenueAdapter() {
        List<DataEntry> dataEntries = new ArrayList<>();
        List<SpendingInChart> spendingInChart = new ArrayList<>();
        adapter.setAdapter(spendingInChart);
        viewModel.get_SpendingInChartThu(requireContext(), calendar.get(Calendar.MONTH) + 1);
        viewModel.SpendingInChartThu().observe(getViewLifecycleOwner(), new Observer<List<SpendingInChart>>() {
            @Override
            public void onChanged(List<SpendingInChart> spendingInCharts) {
                rv = 0;
                if (spendingInCharts.isEmpty()) {
                    binding.anyChart.setVisibility(View.GONE);
                    binding.tvNothing.setVisibility(View.VISIBLE);
                } else {
                    Map<String, List<SpendingInChart>> listMap = spendingInCharts.stream().collect(Collectors.groupingBy(SpendingInChart::getTenDanhMuc));
                    listMap.forEach((_tenDanhMuc, list) -> {
                        SpendingInChart s = new SpendingInChart(
                                list.stream().mapToLong(SpendingInChart::getTien).sum(),
                                _tenDanhMuc,
                                list.get(0).getIcon()
                        );
                        spendingInChart.add(s);
                        dataEntries.add(new ValueDataEntry(s.getTenDanhMuc(), s.getTien()));
                        rv += s.getTien();
                    });
                    pie.setData(dataEntries);
                    binding.anyChart.setVisibility(View.VISIBLE);
                    binding.tvNothing.setVisibility(View.GONE);
                    Log.e(TAG, "revenueAdapter: " + spendingInChart.size());
                    adapter.setAdapter(spendingInChart);
                }
                updateTotal();
            }
        });
    }

    @Override
    public void onResume() {
        check();
        super.onResume();
    }

    private void createDataChart() {
        revenueAdapter();
        spendingAdapter();
        binding.anyChart.setChart(pie);
    }

    private void check() {
        switch (binding.tapLayout.getSelectedTabPosition()) {
            case 0:
                revenueAdapter();
                spendingAdapter();
                break;
            default:
                spendingAdapter();
                revenueAdapter();
                break;
        }
    }

    private void updateTotal() {
        binding.tvSpending.setText(spd + " đ");
        binding.tvRevenue.setText(rv + " đ");
        binding.tvTotal.setText((spd + rv) + " đ");
    }
}
package com.mahdizareei.mztimepicker.timePicker;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TimePicker;

import androidx.annotation.NonNull;

import com.mahdizareei.mztimepicker.R;
import com.mahdizareei.mztimepicker.ui.BaseFragment;


public class ToTime extends BaseFragment {

    private TimePicker timePicker;
    public static String hour = "--", minute = "--";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        try {
            View view = inflater.inflate(R.layout.fragment_to_time, container, false);
            initView(view);
            initAction();
            return view;
        } catch (NullPointerException e) {
            Log.i("error", "onCreateView: ");
        } catch (Exception e) {
            Log.i("error", "onCreateView: ");
        }
        return null;
    }

    private void initView(View view) {
        timePicker = view.findViewById(R.id.timePicker);
    }

    private void initAction() {
        timePicker.setOnTimeChangedListener((timePicker, i, i1) -> {
            hour = String.valueOf(i);
            minute = String.valueOf(i1);
            if (hour.length() == 1) {
                hour = "0" + hour;
            }
            if (minute.length() == 1) {
                minute = "0" + minute;
            }
        });
        timePicker.setIs24HourView(true);
    }

}

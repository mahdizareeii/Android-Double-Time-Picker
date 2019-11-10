package com.mahdizareei.mztimepicker;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdizareei.mztimepicker.interfaces.OnTimeSelectedListener;
import com.mahdizareei.mztimepicker.timePicker.TimePickerDialogFragment;
import com.mahdizareei.mztimepicker.utils.FragmentFactory;

import static com.mahdizareei.mztimepicker.utils.FragmentFactory.FragmentName.TIME_PICKER_FRAGMENT;

public class MZTimePicker {

    private Context context;
    private OnTimeSelectedListener onTimeSelectedListener;
    private TimePickerDialogFragment timePickerDialogFragment;

    public MZTimePicker(Context context, OnTimeSelectedListener onTimeSelectedListener) {
        this.context = context;
        this.onTimeSelectedListener = onTimeSelectedListener;
    }

    public void showTimePicker() {
        FragmentFactory fragmentFactory = new FragmentFactory((AppCompatActivity) context);
        timePickerDialogFragment = (TimePickerDialogFragment) fragmentFactory.dialogFragmentBuild(TIME_PICKER_FRAGMENT, true);
        timePickerDialogFragment.setOnTimeSelectedListener((fromHour, fromMinute, toHour, toMinute) -> {
            onTimeSelectedListener.onTimeSelected(fromHour, fromMinute, toHour, toMinute);
        });
    }

    public void setFromTitle(String text) {
        timePickerDialogFragment.setFromTitle(text);
    }


    public void setToTitle(String text) {
        timePickerDialogFragment.setToTitle(text);
    }

    public void setTabFont(String fontName) {
        timePickerDialogFragment.setTabFont(fontName);
    }

}

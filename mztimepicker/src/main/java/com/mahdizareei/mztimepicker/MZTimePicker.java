package com.mahdizareei.mztimepicker;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.appcompat.app.AppCompatActivity;

import com.mahdizareei.mztimepicker.interfaces.OnTimeSelectedListener;
import com.mahdizareei.mztimepicker.models.TimeModel;
import com.mahdizareei.mztimepicker.models.TimePickerModel;
import com.mahdizareei.mztimepicker.timePicker.TimePickerDialogFragment;
import com.mahdizareei.mztimepicker.utils.FragmentFactory;

import static com.mahdizareei.mztimepicker.utils.FragmentFactory.FragmentName.TIME_PICKER_FRAGMENT;

public class MZTimePicker {

    private Context context;
    private OnTimeSelectedListener onTimeSelectedListener;
    private TimePickerDialogFragment timePickerDialogFragment;
    public static TimePickerModel timePickerModel;

    public MZTimePicker(Context context) {
        this.context = context;
        timePickerModel = new TimePickerModel();
    }

    public MZTimePicker BuildTimePicker(OnTimeSelectedListener onTimeSelected) {
        this.onTimeSelectedListener = onTimeSelected;

        FragmentFactory fragmentFactory = new FragmentFactory((AppCompatActivity) context);
        timePickerDialogFragment = (TimePickerDialogFragment) fragmentFactory.dialogFragmentBuild(TIME_PICKER_FRAGMENT, true);
        timePickerDialogFragment.setOnTimeSelectedListener(new OnTimeSelectedListener() {
            @Override
            public void onTimeSelected(TimeModel time1, TimeModel time2) {
                onTimeSelectedListener.onTimeSelected(time1, time2);
            }
        });
        return this;
    }

    public MZTimePicker setFromTitle(String text) {
        timePickerModel.setFromTitle(text);
        return this;
    }

    public MZTimePicker setToTitle(String text) {
        timePickerModel.setToTitle(text);
        return this;
    }

    public MZTimePicker setConfirmTimeText(String text) {
        timePickerModel.setConfirmText(text);
        return this;
    }

    public MZTimePicker setDeleteTimeText(String text) {
        timePickerModel.setDeleteText(text);
        return this;
    }

    public MZTimePicker setTabFont(String fontName) {
        timePickerModel.setFont(fontName);
        return this;
    }

    public MZTimePicker setTabColor(int color) {
        timePickerModel.setTabColor(color);
        return this;
    }

    public MZTimePicker setTabDrawable(Drawable drawable) {
        timePickerModel.setTabDrawable(drawable);
        return this;
    }

    public MZTimePicker setConfirmButtonColor(int color) {
        timePickerModel.setBtnConfirmColor(color);
        return this;
    }

    public MZTimePicker setDeleteButtonColor(int color) {
        timePickerModel.setBtnDeleteColor(color);
        return this;
    }
}

package com.mahdizareei.mztimepicker.timePicker;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mahdizareei.mztimepicker.R;
import com.mahdizareei.mztimepicker.adapter.TimePickerPagerAdapter;
import com.mahdizareei.mztimepicker.interfaces.OnTimeSelectedListener;
import com.mahdizareei.mztimepicker.models.TimeModel;

import java.util.Objects;

public class TimePickerDialogFragment extends DialogFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button confirm, delete;
    private OnTimeSelectedListener onTimeSelectedListener;
    private String from;
    private String to;
    private String confirmTxt;
    private String clearTxt;
    private String fontName;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);

        // request a window without the title
        Objects.requireNonNull(dialog.getWindow()).requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        try {
            View view = inflater.inflate(R.layout.dialog_time_picker, container, false);
            init(view);
            initAction();
            return view;
        } catch (NullPointerException e) {
            Log.i("error", "onCreateView: ");
        } catch (Exception e) {
            Log.i("error", "onCreateView: ");
        }
        return null;
    }

    private void init(View view) {
        tabLayout = view.findViewById(R.id.tabLayout);
        viewPager = view.findViewById(R.id.viewPager);
        confirm = view.findViewById(R.id.confirm);
        delete = view.findViewById(R.id.delete);
    }

    private void initAction() {
        TimePickerPagerAdapter adapter = new TimePickerPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FromTime(), from == null || from.isEmpty() ? "FROM" : from);
        adapter.addFragment(new ToTime(), to == null || to.isEmpty() ? "TO" : to);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        confirm.setText(confirmTxt == null || confirmTxt.isEmpty() ? getResources().getString(R.string.confirm) : confirmTxt);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tabLayout.getSelectedTabPosition() == 0) {
                    viewPager.setCurrentItem(1);
                } else {
                    String fromHour = FromTime.hour.equals("--") ? FromTime.hour = "00" : FromTime.hour;
                    String fromMinute = FromTime.minute.equals("--") ? FromTime.minute = "00" : FromTime.minute;
                    String toHour = ToTime.hour.equals("--") ? ToTime.hour = "00" : ToTime.hour;
                    String toMinute = ToTime.minute.equals("--") ? ToTime.minute = "00" : ToTime.minute;
                    onTimeSelectedListener.onTimeSelected(new TimeModel(fromHour, fromMinute), new TimeModel(toHour, toMinute));
                    Objects.requireNonNull(getDialog()).dismiss();
                    clearItems();
                }
            }
        });
        delete.setText(clearTxt == null || clearTxt.isEmpty() ? getResources().getString(R.string.delete) : clearTxt);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onTimeSelectedListener.onTimeSelected(new TimeModel("", ""), new TimeModel("", ""));
                Objects.requireNonNull(getDialog()).dismiss();
                clearItems();
            }
        });
        changeTabsFont(fontName, tabLayout, confirm, delete);
    }

    public void setOnTimeSelectedListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.onTimeSelectedListener = onTimeSelectedListener;
    }

    public void setFromTitle(String text) {
        this.from = text;
    }

    public void setToTitle(String text) {
        this.to = text;
    }

    public void setConfirmText(String text) {
        this.confirmTxt = text;
    }

    public void setClearText(String text) {
        this.clearTxt = text;
    }

    public void setTabFont(String fontName) {
        this.fontName = fontName;
    }

    private void clearItems() {
        FromTime.hour = "--";
        FromTime.minute = "--";
        ToTime.hour = "--";
        ToTime.minute = "--";
    }

    private void changeTabsFont(String fontName, TabLayout tabLayout, Button confirmButton, Button deleteButton) {
        if (fontName != null && !fontName.isEmpty()) {
            fontName = !fontName.contains(".ttf") ? fontName + ".ttf" : fontName;
            ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
            int tabsCount = vg.getChildCount();
            for (int j = 0; j < tabsCount; j++) {
                ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
                int tabChildsCount = vgTab.getChildCount();
                for (int i = 0; i < tabChildsCount; i++) {
                    View tabViewChild = vgTab.getChildAt(i);
                    if (tabViewChild instanceof TextView) {
                        setTypeFace(((TextView) tabViewChild), fontName);
                    }
                }
            }
            setTypeFace(confirmButton, fontName);
            setTypeFace(deleteButton, fontName);
        }
    }

    private void setTypeFace(TextView textView, String fontName) {
        try {
            Typeface typeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/" + fontName);
            textView.setTypeface(typeface);
        } catch (NullPointerException e) {
            Toast.makeText(getActivity(), "can not find the assets/fonts/" + fontName, Toast.LENGTH_SHORT).show();
        }
    }

}

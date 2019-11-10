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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.mahdizareei.mztimepicker.R;
import com.mahdizareei.mztimepicker.adapter.TimePickerPagerAdapter;
import com.mahdizareei.mztimepicker.interfaces.OnTimeSelectedListener;

import java.util.Objects;

public class TimePickerDialogFragment extends DialogFragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Button confirm;
    private OnTimeSelectedListener onTimeSelectedListener;
    private TimePickerPagerAdapter adapter;
    private String from = "from", to = "to";

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
    }

    private void initAction() {
        adapter = new TimePickerPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new FromTime(), from);
        adapter.addFragment(new ToTime(), to);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        confirm.setOnClickListener(view -> {
            onTimeSelectedListener.onTimeSelected(FromTime.hour, FromTime.minute, ToTime.hour, ToTime.minute);
            Objects.requireNonNull(getDialog()).dismiss();
        });
    }

    public void setOnTimeSelectedListener(OnTimeSelectedListener onTimeSelectedListener) {
        this.onTimeSelectedListener = onTimeSelectedListener;
    }

    public void setFromTitle(String text) {
        from = text;
    }


    public void setToTitle(String text) {
        to = text;
    }

    public void setTabFont(String fontName) {
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    Typeface typeface = Typeface.createFromAsset(Objects.requireNonNull(getActivity()).getAssets(), "fonts/" + fontName);
                    ((TextView) tabViewChild).setTypeface(typeface);
                }
            }
        }
    }

}

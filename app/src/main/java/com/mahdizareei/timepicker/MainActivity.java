package com.mahdizareei.timepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.mahdizareei.mztimepicker.MZTimePicker;
import com.mahdizareei.mztimepicker.interfaces.OnTimeSelectedListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MZTimePicker(this)
                .setClearText("لغو")
                .setConfirmText("تایید")
                .setToTitle("از زمان")
                .setFromTitle("تا زمان")
                .setTabFont("myfont.ttf")
                .BuildTimePicker(new OnTimeSelectedListener() {
                    @Override
                    public void onTimeSelected(String fromHour, String fromMinute, String toHour, String toMinute) {

                    }
                });
    }
}

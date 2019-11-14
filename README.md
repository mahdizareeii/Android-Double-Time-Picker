# MZTimePicker two timepicker for androidx

[![](https://jitpack.io/v/mahdizareeii/MZTimePicker.svg)](https://jitpack.io/#mahdizareeii/MZTimePicker)

<img src="https://camo.githubusercontent.com/f64898e4f33ba96755263de29f438a80e0fb35db/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d616e64726f69642d6c69676874677265792e737667" alt="API Level ≥9" data-canonical-src="https://img.shields.io/badge/platform-android-lightgrey.svg" style="max-width:100%;">

<img src="https://camo.githubusercontent.com/da8c5362a2c7f520f3e567f849d3eb9564f0ce24/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f616e64726f69642d415049253230254532253839254135322e332d626c75652e737667" alt="API ≥14" data-canonical-src="https://img.shields.io/badge/android-API%20%E2%89%A52.3-blue.svg" style="max-width:100%;">

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

	dependencies {
	        implementation 'com.github.mahdizareeii:MZTimePicker:1.5'
	}
	
how to use :

    MZTimePicker mzTimePicker = new MZTimePicker(this, new OnTimeSelectedListener() {
            @Override
            public void onTimeSelected(String fromHour, String fromMinute, String toHour, String toMinute) {
                Toast.makeText(MainActivity.this, fromHour + ":" + fromMinute + "  -  " + toHour + ":" + toMinute, Toast.LENGTH_SHORT).show();
            }
        });
	
    mzTimePicker.showTimePicker();

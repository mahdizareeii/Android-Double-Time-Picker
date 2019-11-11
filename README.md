# MZTimePicker two timepicker for androidx

[![](https://jitpack.io/v/mahdizareeii/MZTimePicker.svg)](https://jitpack.io/#mahdizareeii/MZTimePicker)

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

# MZTimePicker (double time picker) for androidx

[![](https://jitpack.io/v/mahdizareeii/MZTimePicker.svg)](https://jitpack.io/#mahdizareeii/MZTimePicker)

<p align="left">
  <img src="https://raw.githubusercontent.com/mahdizareeii/MZTimePicker/master/app/src/main/res/drawable/1.PNG" width="250" title="hover text">
  <img src="https://raw.githubusercontent.com/mahdizareeii/MZTimePicker/master/app/src/main/res/drawable/2.PNG" width="250" alt="accessibility text">
</p>

step 1: add the following codes in 'build.gradle(Project: yourproject)'

	allprojects {
		repositories {
			 google()
        	         jcenter()
                     maven { url 'https://jitpack.io' }
		}
	}
step 2: add the following codes in 'build.gradle(Madule: app)'

	dependencies {
	        implementation 'com.github.mahdizareeii:MZTimePicker:1.8'
	}
	
step 3: how to use

    new MZTimePicker(MainActivity.this).BuildTimePicker(new OnTimeSelectedListener() {
                    @Override
                    public void onTimeSelected(TimeModel time1, TimeModel time2) {
                        textView.setText(String.format("%s:%s | %s:%s", time1.getHour(), time1.getMinute(), time2.getHour(), time2.getMinute()));
                    }
                });
		
more settings :

    new MZTimePicker(MainActivity.this)
                        .setFromTitle("From") //set title
                        .setToTitle("To") //set title
                        .setDeleteTimeText("Clear") //set text
                        .setConfirmTimeText("Confirm") //set text
                        .setTabFont("myfont.ttf") //set font (assets/fonts/myfont.ttf)
                        .setTabColor(getResources().getColor(R.color.colorPrimary)) //set color
                        .setConfirmButtonColor(getResources().getColor(R.color.color1)) //set color
                        .setDeleteButtonColor(getResources().getColor(R.color.color1)) //set color
                        .setConfirmTextColor(getResources().getColor(R.color.color2)) //set color
                        .setDeleteTextColor(getResources().getColor(R.color.color2)) //set color
                        .BuildTimePicker(new OnTimeSelectedListener() {
                            @Override
                            public void onTimeSelected(TimeModel time1, TimeModel time2) {
                                textView.setText(String.format("%s:%s | %s:%s", time1.getHour(), time1.getMinute(), time2.getHour(), time2.getMinute()));
                            }
                        });

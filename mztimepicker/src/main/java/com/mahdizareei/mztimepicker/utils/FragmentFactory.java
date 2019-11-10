package com.mahdizareei.mztimepicker.utils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.timepicker.mahdizareei.timePicker.TimePickerDialogFragment;

import java.util.Objects;

public class FragmentFactory {

    private AppCompatActivity appCompatActivity;

    private boolean addToStack = true;
    private int container;

    private TimePickerDialogFragment timePickerDialogFragment;


    public enum CallType {
        add,
        replace
    }

    public enum FragmentName {
        TIME_PICKER_FRAGMENT,
    }

    public FragmentFactory(AppCompatActivity appCompatActivity) {
        this.appCompatActivity = appCompatActivity;
        this.container = android.R.id.content;
    }

    public FragmentFactory(Activity activity) {
        this.appCompatActivity = (AppCompatActivity) activity;
    }

    public void setContainer(int resId) {
        this.container = resId;
    }

    public Fragment getFragment(FragmentName flag) {
        switch (flag) {
            case TIME_PICKER_FRAGMENT:
                if (timePickerDialogFragment == null)
                    timePickerDialogFragment = new TimePickerDialogFragment();
                return timePickerDialogFragment;

        }
        return null;
    }

    public DialogFragment dialogFragmentBuild(FragmentName flag, Bundle param, boolean cancelable) {
        hideKeyboard(appCompatActivity);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();

        DialogFragment fragment = (DialogFragment) getFragment(flag);
        if (fragment == null)
            return null;
        fragment.setArguments(param);
        fragment.setCancelable(cancelable);
        fragment.show(fragmentManager, flag.toString());
        fragmentManager.executePendingTransactions();
        return fragment;
    }

    public DialogFragment dialogFragmentBuild(FragmentName flag, boolean cancelable) {
        hideKeyboard(appCompatActivity);
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();

        DialogFragment fragment = (DialogFragment) getFragment(flag);
        if (fragment == null)
            return null;

        fragment.setCancelable(cancelable);
        fragment.show(fragmentManager, flag.toString());
        fragmentManager.executePendingTransactions();

        return fragment;

    }

    public Fragment fragmentBuild(FragmentName flag, CallType callType) {
        callTypeMethod(callType, getFragment(flag), flag);
        return getFragment(flag);
    }

    public Fragment fragmentBuild(FragmentName flag, CallType callType, int resId) {
        this.container = resId;
        return fragmentBuild(flag, callType);
    }

    public Fragment fragmentBuild(FragmentName flag, Bundle params, CallType callType) {
        Fragment fragment = getFragment(flag);
        if (fragment == null)
            return null;

        fragment.setArguments(params);
        callTypeMethod(callType, fragment, flag);

        return fragment;

    }

    public Fragment fragmentBuild(FragmentName flag, Bundle params, CallType callType, int resId) {
        this.container = resId;
        return fragmentBuild(flag, params, callType);
    }


    public void addTostack(boolean b) {
        addToStack = b;
    }

    private void callTypeMethod(CallType callType, Fragment fragment, FragmentName flag) {
        switch (callType) {
            case add:
                fragmentBuildAdd(fragment, flag);
                break;
            case replace:
                fragmentBuildReplace(fragment, flag);
                break;
        }
    }

    private void fragmentBuildAdd(Fragment fragment, FragmentName flag) {
        hideKeyboard(appCompatActivity);
        FragmentTransaction fragmentTransaction = appCompatActivity.getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .add(container, fragment, flag.toString());

        if (addToStack)
            fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();


    }

    public void displayFragment(Fragment fragment, String tag) {
        FragmentManager fm = appCompatActivity.getSupportFragmentManager();
        boolean a = tag.equals(Objects.requireNonNull(fragment).getTag());
    }

    private Fragment getLastFragment() {
        int index = appCompatActivity.getFragmentManager().getBackStackEntryCount();
        FragmentManager.BackStackEntry backEntry = (FragmentManager.BackStackEntry) appCompatActivity.getFragmentManager().getBackStackEntryAt(index);
        String tag = backEntry.getName();
        return appCompatActivity.getSupportFragmentManager().findFragmentByTag(tag);

    }

    private void fragmentBuildReplace(Fragment fragment, FragmentName flag) {
        hideKeyboard(appCompatActivity);

        FragmentTransaction fragmentTransaction = appCompatActivity.getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(container, fragment);

        if (addToStack)
            fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();

    }

    public void hideKeyboard(AppCompatActivity activity) {
        try {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(AppCompatActivity.INPUT_METHOD_SERVICE);
            //Find the currently focused view, so we can grab the correct window token from it.
            View view = activity.getCurrentFocus();
            //If no view currently has focus, create a new one, just so we can grab a window token from it
            if (view == null) {
                view = new View(activity);
            }
            if (imm != null) imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } catch (NullPointerException e) {

            Log.i("error", "hideKeyboard: ");
        } catch (Exception e) {
            Log.i("error", "hideKeyboard: ");
        }
    }

}

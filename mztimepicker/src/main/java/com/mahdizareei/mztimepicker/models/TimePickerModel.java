package com.mahdizareei.mztimepicker.models;

import android.graphics.drawable.Drawable;

public class TimePickerModel {

    private String fromTitle;
    private String toTitle;
    private String confirmText;
    private String deleteText;
    private String setFont;
    private Drawable tabDrawable;
    private Integer tabColor;
    private Integer btnConfirmColor;
    private Integer btnDeleteColor;

    public String getFromTitle() {
        return fromTitle;
    }

    public void setFromTitle(String fromTitle) {
        this.fromTitle = fromTitle;
    }

    public String getToTitle() {
        return toTitle;
    }

    public void setToTitle(String toTitle) {
        this.toTitle = toTitle;
    }

    public String getConfirmText() {
        return confirmText;
    }

    public void setConfirmText(String confirmText) {
        this.confirmText = confirmText;
    }

    public String getDeleteText() {
        return deleteText;
    }

    public void setDeleteText(String deleteText) {
        this.deleteText = deleteText;
    }

    public String getFont() {
        return setFont;
    }

    public void setFont(String setFont) {
        this.setFont = setFont;
    }

    public Drawable getTabDrawable() {
        return tabDrawable;
    }

    public void setTabDrawable(Drawable tabDrawable) {
        this.tabDrawable = tabDrawable;
    }

    public Integer getTabColor() {
        return tabColor;
    }

    public void setTabColor(int tabColor) {
        this.tabColor = tabColor;
    }

    public Integer getBtnConfirmColor() {
        return btnConfirmColor;
    }

    public void setBtnConfirmColor(int btnConfirmColor) {
        this.btnConfirmColor = btnConfirmColor;
    }

    public Integer getBtnDeleteColor() {
        return btnDeleteColor;
    }

    public void setBtnDeleteColor(int btnDeleteColor) {
        this.btnDeleteColor = btnDeleteColor;
    }
}

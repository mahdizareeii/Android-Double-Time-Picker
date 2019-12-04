package com.mahdizareei.mztimepicker.models;

public class TimePickerModel {

    private String fromTitle;
    private String toTitle;
    private String confirmText;
    private String deleteText;
    private String setFont;

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

    public void setFont(String fontName) {
        this.setFont = fontName;
    }
}

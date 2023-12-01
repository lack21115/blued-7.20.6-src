package com.blued.android.module.yy_china.model;

import java.text.DecimalFormat;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YyPkLevelListModel.class */
public class YyPkLevelListModel {
    private String level;
    private String level_img;
    private String pk_count;
    private String score;
    private String win_count;
    private String win_rate;

    public String getLevel() {
        return this.level;
    }

    public String getLevel_img() {
        return this.level_img;
    }

    public String getPk_count() {
        return this.pk_count;
    }

    public String getScore() {
        return this.score;
    }

    public String getWin_count() {
        return this.win_count;
    }

    public String getWin_rate() {
        DecimalFormat decimalFormat = new DecimalFormat("######0.00");
        return decimalFormat.format(new Float(this.win_rate).floatValue() * 100.0f) + "%";
    }

    public void setLevel(String str) {
        this.level = str;
    }

    public void setLevel_img(String str) {
        this.level_img = str;
    }

    public void setPk_count(String str) {
        this.pk_count = str;
    }

    public void setScore(String str) {
        this.score = str;
    }

    public void setWin_count(String str) {
        this.win_count = str;
    }

    public void setWin_rate(String str) {
        this.win_rate = str;
    }
}

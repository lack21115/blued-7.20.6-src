package com.blued.android.module.yy_china.model;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YyPkRecordListModel.class */
public class YyPkRecordListModel {
    private String name;
    private String score;
    private long time;

    public String getName() {
        return this.name;
    }

    public String getScore() {
        return this.score;
    }

    public long getTime() {
        return this.time * 1000;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setScore(String str) {
        this.score = str;
    }
}

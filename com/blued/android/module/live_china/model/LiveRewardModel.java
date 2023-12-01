package com.blued.android.module.live_china.model;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRewardModel.class */
public class LiveRewardModel {
    public double beans;
    public String condition;
    public long end_second;
    public boolean hasAgreePwd;
    public boolean hasPwdTip;
    public String hongbao_id;
    public int is_anim;
    public int is_prize;
    public String pwd;
    public long remaining_millisecond;
    public String size;
    public long start_second;
    public int status;

    public LiveRewardModel() {
        this.condition = "1";
    }

    public LiveRewardModel(String str, long j, long j2, int i, String str2) {
        this.condition = "1";
        this.hongbao_id = str;
        this.start_second = j;
        this.end_second = j2;
        this.is_anim = i;
        this.condition = str2;
    }

    public LiveRewardModel(String str, long j, long j2, int i, String str2, double d, int i2, long j3, String str3, String str4) {
        this.condition = "1";
        this.hongbao_id = str;
        this.start_second = j;
        this.end_second = j2;
        this.status = i;
        this.size = str2;
        this.beans = d;
        this.is_anim = i2;
        this.remaining_millisecond = j3;
        this.condition = str3;
        this.pwd = str4;
    }
}

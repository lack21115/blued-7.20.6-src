package com.blued.android.module.common.login.model;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BannerADRequest.class */
public class BannerADRequest {
    public long aid;
    public int app;
    public Excitation excitation;
    public String video_id;

    public BannerADRequest(int i, long j, String str, Excitation excitation) {
        this.app = i;
        this.aid = j;
        this.video_id = str;
        this.excitation = excitation;
    }
}

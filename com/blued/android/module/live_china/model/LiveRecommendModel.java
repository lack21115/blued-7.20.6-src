package com.blued.android.module.live_china.model;

import com.blued.android.module.common.user.model.BluedLoginResult;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRecommendModel.class */
public class LiveRecommendModel {
    public String anchor_tag;
    public String avatar;
    public int followed;
    public boolean isShowed;
    public int level;
    public String lid;
    public int link_type;
    public String livePlay;
    public int liveType = ((int) System.currentTimeMillis()) % 2;
    public String name;
    public String pic_url;
    public int pk;
    public int realtime_count;
    public int screen_pattern;
    public String source;
    public String uid;
    public int vbadge;

    public LiveRecommendModel(BluedLoginResult bluedLoginResult) {
        this.avatar = bluedLoginResult.avatar;
        this.name = bluedLoginResult.name;
        this.vbadge = bluedLoginResult.vbadge;
        this.uid = bluedLoginResult.uid;
    }
}

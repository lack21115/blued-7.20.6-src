package com.blued.community.model;

import com.blued.android.module.common.user.model.BluedLoginResult;

/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/LiveRecommendModel.class */
public class LiveRecommendModel {
    public String avatar;
    public boolean isShowed;
    public String lid;
    public int link_type;
    public String livePlay;
    public int liveType = ((int) System.currentTimeMillis()) % 2;
    public String name;
    public int pk;
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

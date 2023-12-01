package com.blued.android.module.live_china.model;

import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomAnchorModel.class */
public class LiveRoomAnchorModel extends LiveRoomUserModel implements Serializable {
    private static final long serialVersionUID = 1;

    public LiveRoomAnchorModel() {
    }

    public LiveRoomAnchorModel(String str, String str2, String str3, int i) {
        this.uid = str;
        this.name = str2;
        this.avatar = str3;
        this.vbadge = i;
    }

    public LiveRoomAnchorModel(String str, String str2, String str3, int i, int i2) {
        this.uid = str;
        this.name = str2;
        this.avatar = str3;
        this.vbadge = i;
        this.rich_level = i2;
    }
}

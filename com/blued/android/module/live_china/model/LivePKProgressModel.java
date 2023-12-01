package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePKProgressModel.class */
public class LivePKProgressModel implements Serializable {
    public int score;
    public List<LivePKProgressUserModel> target_top;
    public List<LivePKProgressUserModel> top;
    public int total;
    public long uid;

    public String toString() {
        return "LivePKProgressModel{uid=" + this.uid + ", score=" + this.score + ", total=" + this.total + ", top=" + this.top + ", target_top=" + this.target_top + '}';
    }
}

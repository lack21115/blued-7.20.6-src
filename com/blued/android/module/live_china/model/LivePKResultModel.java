package com.blued.android.module.live_china.model;

import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePKResultModel.class */
public class LivePKResultModel {
    public long countdown;
    public int pk_type;
    public List<LivePKPlayerModel> records;
    public int type;
    public long winner;

    public String toString() {
        return "LivePKResultModel{records=" + this.records + ", countdown=" + this.countdown + ", winner=" + this.winner + ", type=" + this.type + '}';
    }
}

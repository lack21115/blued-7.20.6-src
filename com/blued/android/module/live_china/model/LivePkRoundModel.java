package com.blued.android.module.live_china.model;

import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePkRoundModel.class */
public class LivePkRoundModel {
    public int count;
    public long countdown;
    public boolean last;
    public boolean pk_status;
    public List<LivePKPlayerModel> records;

    public String toString() {
        return "LivePkRoundModel{count=" + this.count + ", records=" + this.records + ", countdown=" + this.countdown + ", pk_status=" + this.pk_status + '}';
    }
}

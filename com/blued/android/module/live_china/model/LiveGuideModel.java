package com.blued.android.module.live_china.model;

import java.io.Serializable;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGuideModel.class */
public class LiveGuideModel implements Serializable {
    public String content;
    public long count;
    public long countdown;
    public String extra;
    public long frequency;
    public int id;
    public boolean is_grpc = false;
    public boolean is_send;
    public int show_type;
    public long strategy;
    public int sub_type;
    public Runnable task;
    public int type;
    public String url;

    public String getGuideType() {
        return this.type + "-" + this.sub_type;
    }

    public long getNextTime() {
        long j = this.strategy;
        if (j == 0 || j == 3) {
            return 0L;
        }
        if (this.count < 0) {
            return -1L;
        }
        long j2 = this.countdown;
        return j2 > 0 ? j2 : this.frequency;
    }
}

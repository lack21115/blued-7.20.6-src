package com.heytap.mcssdk.mode;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/mcssdk/mode/AppLimitBean.class */
public class AppLimitBean {
    private int count;
    private long lastedTime;

    public AppLimitBean(long j, int i) {
        this.lastedTime = j;
        this.count = i;
    }

    public int getCount() {
        return this.count;
    }

    public long getLastedTime() {
        return this.lastedTime;
    }

    public void setCount(int i) {
        this.count = i;
    }

    public void setLastedTime(long j) {
        this.lastedTime = j;
    }
}

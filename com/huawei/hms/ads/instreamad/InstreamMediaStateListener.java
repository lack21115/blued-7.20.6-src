package com.huawei.hms.ads.instreamad;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/instreamad/InstreamMediaStateListener.class */
public interface InstreamMediaStateListener {
    void onMediaCompletion(int i);

    void onMediaError(int i, int i2, int i3);

    void onMediaPause(int i);

    void onMediaProgress(int i, int i2);

    void onMediaStart(int i);

    void onMediaStop(int i);
}

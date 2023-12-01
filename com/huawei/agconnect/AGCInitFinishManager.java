package com.huawei.agconnect;

import com.huawei.agconnect.core.a.a;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/AGCInitFinishManager.class */
public abstract class AGCInitFinishManager {
    private static final AGCInitFinishManager INSTANCE = new a();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/AGCInitFinishManager$AGCInitFinishCallback.class */
    public interface AGCInitFinishCallback {
        void onFinish();
    }

    public static AGCInitFinishManager getInstance() {
        return INSTANCE;
    }

    public abstract void addAGCInitFinishCallback(AGCInitFinishCallback aGCInitFinishCallback);
}

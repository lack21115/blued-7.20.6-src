package com.huawei.agconnect.core.a;

import com.huawei.agconnect.AGCInitFinishManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/agconnect/core/a/a.class */
public class a extends AGCInitFinishManager {

    /* renamed from: a  reason: collision with root package name */
    private static final List<AGCInitFinishManager.AGCInitFinishCallback> f22345a = new CopyOnWriteArrayList();

    public static void a() {
        for (AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback : f22345a) {
            aGCInitFinishCallback.onFinish();
        }
    }

    @Override // com.huawei.agconnect.AGCInitFinishManager
    public void addAGCInitFinishCallback(AGCInitFinishManager.AGCInitFinishCallback aGCInitFinishCallback) {
        if (aGCInitFinishCallback != null) {
            f22345a.add(aGCInitFinishCallback);
        }
    }
}

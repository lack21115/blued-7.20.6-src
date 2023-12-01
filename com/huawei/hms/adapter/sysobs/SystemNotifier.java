package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/sysobs/SystemNotifier.class */
public interface SystemNotifier {
    void notifyNoticeObservers(int i);

    void notifyObservers(int i);

    void notifyObservers(Intent intent, String str);

    void registerObserver(SystemObserver systemObserver);

    void unRegisterObserver(SystemObserver systemObserver);
}

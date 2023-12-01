package com.huawei.hms.adapter.sysobs;

import android.content.Intent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/sysobs/SystemManager.class */
public final class SystemManager {

    /* renamed from: a  reason: collision with root package name */
    public static SystemManager f22423a = new SystemManager();
    public static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static SystemNotifier f22424c = new a();

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/sysobs/SystemManager$a.class */
    public static final class a implements SystemNotifier {

        /* renamed from: a  reason: collision with root package name */
        public final List<SystemObserver> f22425a = new ArrayList();

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyNoticeObservers(int i) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f22425a.iterator();
                while (it.hasNext()) {
                    if (it.next().onNoticeResult(i)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(int i) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f22425a.iterator();
                while (it.hasNext()) {
                    if (it.next().onUpdateResult(i)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void notifyObservers(Intent intent, String str) {
            synchronized (SystemManager.b) {
                Iterator<SystemObserver> it = this.f22425a.iterator();
                while (it.hasNext()) {
                    if (it.next().onSolutionResult(intent, str)) {
                        it.remove();
                    }
                }
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void registerObserver(SystemObserver systemObserver) {
            if (systemObserver == null || this.f22425a.contains(systemObserver)) {
                return;
            }
            synchronized (SystemManager.b) {
                this.f22425a.add(systemObserver);
            }
        }

        @Override // com.huawei.hms.adapter.sysobs.SystemNotifier
        public void unRegisterObserver(SystemObserver systemObserver) {
            synchronized (SystemManager.b) {
                this.f22425a.remove(systemObserver);
            }
        }
    }

    public static SystemManager getInstance() {
        return f22423a;
    }

    public static SystemNotifier getSystemNotifier() {
        return f22424c;
    }

    public void notifyNoticeResult(int i) {
        f22424c.notifyNoticeObservers(i);
    }

    public void notifyResolutionResult(Intent intent, String str) {
        f22424c.notifyObservers(intent, str);
    }

    public void notifyUpdateResult(int i) {
        f22424c.notifyObservers(i);
    }
}

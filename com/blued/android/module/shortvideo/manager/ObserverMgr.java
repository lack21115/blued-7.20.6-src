package com.blued.android.module.shortvideo.manager;

import com.blued.android.module.shortvideo.model.EventType;
import com.blued.android.module.shortvideo.observer.EventObserver;
import com.blued.android.module.shortvideo.observer.ReturnObserver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/manager/ObserverMgr.class */
public class ObserverMgr {

    /* renamed from: a  reason: collision with root package name */
    private static ObserverMgr f15746a;
    private List<EventObserver> b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<ReturnObserver> f15747c = new ArrayList();

    private ObserverMgr() {
    }

    public static ObserverMgr a() {
        if (f15746a == null) {
            synchronized (ObserverMgr.class) {
                try {
                    if (f15746a == null) {
                        f15746a = new ObserverMgr();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f15746a;
    }

    public void a(EventType.VALUE value) {
        for (EventObserver eventObserver : this.b) {
            eventObserver.a(value);
        }
    }

    public void a(EventType.VALUE value, boolean z) {
        for (ReturnObserver returnObserver : this.f15747c) {
            returnObserver.a(value, z);
        }
    }

    public boolean a(EventObserver eventObserver) {
        if (this.b.contains(eventObserver)) {
            return false;
        }
        return this.b.add(eventObserver);
    }

    public boolean a(ReturnObserver returnObserver) {
        if (this.f15747c.contains(returnObserver)) {
            return false;
        }
        return this.f15747c.add(returnObserver);
    }

    public boolean b(EventObserver eventObserver) {
        if (this.b.contains(eventObserver)) {
            return this.b.remove(eventObserver);
        }
        return false;
    }

    public boolean b(ReturnObserver returnObserver) {
        if (this.f15747c.contains(returnObserver)) {
            return this.f15747c.remove(returnObserver);
        }
        return false;
    }
}

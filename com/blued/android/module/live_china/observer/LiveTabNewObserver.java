package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveTabNewObserver.class */
public class LiveTabNewObserver {
    private static LiveTabNewObserver a = new LiveTabNewObserver();
    private ArrayList<ILiveTabRefreshObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveTabNewObserver$ILiveTabRefreshObserver.class */
    public interface ILiveTabRefreshObserver {
        void ag_();

        void d();

        void e();
    }

    public static LiveTabNewObserver a() {
        return a;
    }

    public void a(ILiveTabRefreshObserver iLiveTabRefreshObserver) {
        synchronized (this) {
            if (iLiveTabRefreshObserver != null) {
                this.b.add(iLiveTabRefreshObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<ILiveTabRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveTabRefreshObserver next = it.next();
                if (next != null) {
                    next.d();
                }
            }
        }
    }

    public void b(ILiveTabRefreshObserver iLiveTabRefreshObserver) {
        synchronized (this) {
            if (iLiveTabRefreshObserver != null) {
                this.b.remove(iLiveTabRefreshObserver);
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<ILiveTabRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveTabRefreshObserver next = it.next();
                if (next != null) {
                    next.e();
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            Iterator<ILiveTabRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveTabRefreshObserver next = it.next();
                if (next != null) {
                    next.ag_();
                }
            }
        }
    }
}

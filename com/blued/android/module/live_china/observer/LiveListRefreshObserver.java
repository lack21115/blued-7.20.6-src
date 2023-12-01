package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveListRefreshObserver.class */
public class LiveListRefreshObserver {
    private static LiveListRefreshObserver a = new LiveListRefreshObserver();
    private ArrayList<ILiveListRefreshObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveListRefreshObserver$ILiveListRefreshObserver.class */
    public interface ILiveListRefreshObserver {
        void a();
    }

    private LiveListRefreshObserver() {
    }

    public static LiveListRefreshObserver a() {
        return a;
    }

    public void a(ILiveListRefreshObserver iLiveListRefreshObserver) {
        synchronized (this) {
            if (iLiveListRefreshObserver != null) {
                this.b.add(iLiveListRefreshObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<ILiveListRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveListRefreshObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void b(ILiveListRefreshObserver iLiveListRefreshObserver) {
        synchronized (this) {
            if (iLiveListRefreshObserver != null) {
                this.b.remove(iLiveListRefreshObserver);
            }
        }
    }
}

package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveRewardStatusObserver.class */
public class LiveRewardStatusObserver {
    private static LiveRewardStatusObserver a = new LiveRewardStatusObserver();
    private ArrayList<ILiveRewardStatusObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveRewardStatusObserver$ILiveRewardStatusObserver.class */
    public interface ILiveRewardStatusObserver {
        void a(int i);
    }

    private LiveRewardStatusObserver() {
    }

    public static LiveRewardStatusObserver a() {
        return a;
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<ILiveRewardStatusObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRewardStatusObserver next = it.next();
                if (next != null) {
                    next.a(i);
                }
            }
        }
    }

    public void a(ILiveRewardStatusObserver iLiveRewardStatusObserver) {
        synchronized (this) {
            if (iLiveRewardStatusObserver != null) {
                this.b.add(iLiveRewardStatusObserver);
            }
        }
    }

    public void b(ILiveRewardStatusObserver iLiveRewardStatusObserver) {
        synchronized (this) {
            if (iLiveRewardStatusObserver != null) {
                this.b.remove(iLiveRewardStatusObserver);
            }
        }
    }
}

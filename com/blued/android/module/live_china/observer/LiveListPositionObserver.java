package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveListPositionObserver.class */
public class LiveListPositionObserver {
    private static LiveListPositionObserver a = new LiveListPositionObserver();
    private ArrayList<ILiveListPositionObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveListPositionObserver$ILiveListPositionObserver.class */
    public interface ILiveListPositionObserver {
        void a(int i, long j);
    }

    private LiveListPositionObserver() {
    }

    public static LiveListPositionObserver a() {
        return a;
    }

    public void a(int i, long j) {
        synchronized (this) {
            Iterator<ILiveListPositionObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveListPositionObserver next = it.next();
                if (next != null) {
                    next.a(i, j);
                }
            }
        }
    }

    public void a(ILiveListPositionObserver iLiveListPositionObserver) {
        synchronized (this) {
            if (iLiveListPositionObserver != null) {
                this.b.add(iLiveListPositionObserver);
            }
        }
    }

    public void b(ILiveListPositionObserver iLiveListPositionObserver) {
        synchronized (this) {
            if (iLiveListPositionObserver != null) {
                this.b.remove(iLiveListPositionObserver);
            }
        }
    }
}

package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveSwipeRefreshObserver.class */
public class LiveSwipeRefreshObserver {
    private static LiveSwipeRefreshObserver a = new LiveSwipeRefreshObserver();
    private ArrayList<IEnableRefeshObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveSwipeRefreshObserver$IEnableRefeshObserver.class */
    public interface IEnableRefeshObserver {
        void b();

        void c();
    }

    public static LiveSwipeRefreshObserver a() {
        return a;
    }

    public void a(IEnableRefeshObserver iEnableRefeshObserver) {
        synchronized (this) {
            if (iEnableRefeshObserver != null) {
                this.b.add(iEnableRefeshObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IEnableRefeshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IEnableRefeshObserver next = it.next();
                if (next != null) {
                    next.b();
                }
            }
        }
    }

    public void b(IEnableRefeshObserver iEnableRefeshObserver) {
        synchronized (this) {
            if (iEnableRefeshObserver != null) {
                this.b.remove(iEnableRefeshObserver);
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<IEnableRefeshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IEnableRefeshObserver next = it.next();
                if (next != null) {
                    next.c();
                }
            }
        }
    }
}

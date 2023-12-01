package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveFansObserver.class */
public class LiveFansObserver {
    private static LiveFansObserver a = new LiveFansObserver();
    private ArrayList<ILiveFansObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveFansObserver$ILiveFansObserver.class */
    public interface ILiveFansObserver {
        void R();

        void S();

        void T();

        void h(int i);
    }

    private LiveFansObserver() {
    }

    public static LiveFansObserver a() {
        return a;
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<ILiveFansObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveFansObserver next = it.next();
                if (next != null) {
                    next.h(i);
                }
            }
        }
    }

    public void a(ILiveFansObserver iLiveFansObserver) {
        synchronized (this) {
            if (iLiveFansObserver != null) {
                this.b.add(iLiveFansObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<ILiveFansObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveFansObserver next = it.next();
                if (next != null) {
                    next.R();
                }
            }
        }
    }

    public void b(ILiveFansObserver iLiveFansObserver) {
        synchronized (this) {
            if (iLiveFansObserver != null) {
                this.b.remove(iLiveFansObserver);
            }
        }
    }

    public void c() {
        synchronized (this) {
            Iterator<ILiveFansObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveFansObserver next = it.next();
                if (next != null) {
                    next.S();
                }
            }
        }
    }

    public void d() {
        synchronized (this) {
            Iterator<ILiveFansObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveFansObserver next = it.next();
                if (next != null) {
                    next.T();
                }
            }
        }
    }
}

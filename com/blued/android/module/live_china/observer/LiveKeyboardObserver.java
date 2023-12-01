package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveKeyboardObserver.class */
public class LiveKeyboardObserver {
    private static LiveKeyboardObserver a = new LiveKeyboardObserver();
    private ArrayList<ILiveKeyboardObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveKeyboardObserver$ILiveKeyboardObserver.class */
    public interface ILiveKeyboardObserver {
        void g();

        void h();
    }

    private LiveKeyboardObserver() {
    }

    public static LiveKeyboardObserver a() {
        return a;
    }

    public void a(ILiveKeyboardObserver iLiveKeyboardObserver) {
        synchronized (this) {
            if (iLiveKeyboardObserver != null) {
                this.b.add(iLiveKeyboardObserver);
            }
        }
    }

    public void b() {
        ILiveKeyboardObserver next;
        synchronized (this) {
            Iterator<ILiveKeyboardObserver> it = this.b.iterator();
            if (it.hasNext() && (next = it.next()) != null) {
                next.g();
            }
        }
    }

    public void b(ILiveKeyboardObserver iLiveKeyboardObserver) {
        synchronized (this) {
            if (iLiveKeyboardObserver != null) {
                this.b.remove(iLiveKeyboardObserver);
            }
        }
    }

    public void c() {
        ILiveKeyboardObserver next;
        synchronized (this) {
            Iterator<ILiveKeyboardObserver> it = this.b.iterator();
            if (it.hasNext() && (next = it.next()) != null) {
                next.h();
            }
        }
    }
}

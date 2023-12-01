package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/BeansRefreshObserver.class */
public class BeansRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    private static BeansRefreshObserver f13943a = new BeansRefreshObserver();
    private ArrayList<IBeansRefreshObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/BeansRefreshObserver$IBeansRefreshObserver.class */
    public interface IBeansRefreshObserver {
        void a(double d, double d2);
    }

    private BeansRefreshObserver() {
    }

    public static BeansRefreshObserver a() {
        return f13943a;
    }

    public void a(double d, double d2) {
        synchronized (this) {
            Iterator<IBeansRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IBeansRefreshObserver next = it.next();
                if (next != null) {
                    next.a(d, d2);
                }
            }
        }
    }

    public void a(IBeansRefreshObserver iBeansRefreshObserver) {
        synchronized (this) {
            if (iBeansRefreshObserver != null) {
                this.b.add(iBeansRefreshObserver);
            }
        }
    }

    public void b(IBeansRefreshObserver iBeansRefreshObserver) {
        synchronized (this) {
            if (iBeansRefreshObserver != null) {
                this.b.remove(iBeansRefreshObserver);
            }
        }
    }
}

package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/ZanRefreshObserver.class */
public class ZanRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    private static ZanRefreshObserver f13959a = new ZanRefreshObserver();
    private ArrayList<IZanRefreshObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/ZanRefreshObserver$IZanRefreshObserver.class */
    public interface IZanRefreshObserver {
        void a(String[] strArr);
    }

    private ZanRefreshObserver() {
    }

    public static ZanRefreshObserver a() {
        return f13959a;
    }

    public void a(IZanRefreshObserver iZanRefreshObserver) {
        synchronized (this) {
            if (iZanRefreshObserver != null) {
                this.b.add(iZanRefreshObserver);
            }
        }
    }

    public void a(String[] strArr) {
        synchronized (this) {
            Iterator<IZanRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IZanRefreshObserver next = it.next();
                if (next != null) {
                    next.a(strArr);
                }
            }
        }
    }

    public void b(IZanRefreshObserver iZanRefreshObserver) {
        synchronized (this) {
            if (iZanRefreshObserver != null) {
                this.b.remove(iZanRefreshObserver);
            }
        }
    }
}

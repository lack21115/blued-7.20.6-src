package com.blued.android.module.live_china.manager;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayARObserver.class */
public class PlayARObserver {

    /* renamed from: a  reason: collision with root package name */
    private static PlayARObserver f13676a = new PlayARObserver();
    private ArrayList<IPlayARObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayARObserver$IPlayARObserver.class */
    public interface IPlayARObserver {
        void av();
    }

    private PlayARObserver() {
    }

    public static PlayARObserver a() {
        return f13676a;
    }

    public void a(IPlayARObserver iPlayARObserver) {
        synchronized (this) {
            if (iPlayARObserver != null) {
                this.b.add(iPlayARObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IPlayARObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPlayARObserver next = it.next();
                if (next != null) {
                    next.av();
                }
            }
        }
    }

    public void b(IPlayARObserver iPlayARObserver) {
        synchronized (this) {
            if (iPlayARObserver != null) {
                this.b.remove(iPlayARObserver);
            }
        }
    }
}

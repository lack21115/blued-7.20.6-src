package com.blued.android.module.live_china.manager;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayGifObserver.class */
public class PlayGifObserver {
    private static PlayGifObserver a = new PlayGifObserver();
    private ArrayList<IPlayGifObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/manager/PlayGifObserver$IPlayGifObserver.class */
    public interface IPlayGifObserver {
        void F();
    }

    private PlayGifObserver() {
    }

    public static PlayGifObserver a() {
        return a;
    }

    public void a(IPlayGifObserver iPlayGifObserver) {
        synchronized (this) {
            if (iPlayGifObserver != null) {
                this.b.add(iPlayGifObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IPlayGifObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPlayGifObserver next = it.next();
                if (next != null) {
                    next.F();
                }
            }
        }
    }

    public void b(IPlayGifObserver iPlayGifObserver) {
        synchronized (this) {
            if (iPlayGifObserver != null) {
                this.b.remove(iPlayGifObserver);
            }
        }
    }
}

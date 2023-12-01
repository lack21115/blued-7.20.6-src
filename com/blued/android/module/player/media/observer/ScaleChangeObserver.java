package com.blued.android.module.player.media.observer;

import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/observer/ScaleChangeObserver.class */
public class ScaleChangeObserver {
    private static ScaleChangeObserver a = new ScaleChangeObserver();
    private ArrayList<IScaleChangeObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/observer/ScaleChangeObserver$IScaleChangeObserver.class */
    public interface IScaleChangeObserver {
    }

    private ScaleChangeObserver() {
    }

    public static ScaleChangeObserver a() {
        return a;
    }

    public void a(IScaleChangeObserver iScaleChangeObserver) {
        synchronized (this) {
            if (iScaleChangeObserver != null) {
                this.b.add(iScaleChangeObserver);
            }
        }
    }

    public void b(IScaleChangeObserver iScaleChangeObserver) {
        synchronized (this) {
            if (iScaleChangeObserver != null) {
                this.b.remove(iScaleChangeObserver);
            }
        }
    }
}

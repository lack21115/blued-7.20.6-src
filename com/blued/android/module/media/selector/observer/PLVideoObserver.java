package com.blued.android.module.media.selector.observer;

import java.util.ArrayList;

@Deprecated
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/observer/PLVideoObserver.class */
public class PLVideoObserver {
    private static PLVideoObserver a = new PLVideoObserver();
    private ArrayList<IPLVideoObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/observer/PLVideoObserver$IPLVideoObserver.class */
    public interface IPLVideoObserver {
    }

    public static PLVideoObserver a() {
        return a;
    }

    public void a(IPLVideoObserver iPLVideoObserver) {
        synchronized (this) {
            if (iPLVideoObserver != null) {
                this.b.add(iPLVideoObserver);
            }
        }
    }

    public void b(IPLVideoObserver iPLVideoObserver) {
        synchronized (this) {
            if (iPLVideoObserver != null) {
                this.b.remove(iPLVideoObserver);
            }
        }
    }
}

package com.blued.android.module.media.selector.observer;

import java.util.ArrayList;

@Deprecated
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/observer/PLVideoObserver.class */
public class PLVideoObserver {

    /* renamed from: a  reason: collision with root package name */
    private static PLVideoObserver f15568a = new PLVideoObserver();
    private ArrayList<IPLVideoObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/media/selector/observer/PLVideoObserver$IPLVideoObserver.class */
    public interface IPLVideoObserver {
    }

    public static PLVideoObserver a() {
        return f15568a;
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

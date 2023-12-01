package com.blued.android.module.player.media.observer;

import java.util.ArrayList;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/observer/LiveSysNetworkObserver.class */
public class LiveSysNetworkObserver {

    /* renamed from: a  reason: collision with root package name */
    private static LiveSysNetworkObserver f15655a = new LiveSysNetworkObserver();
    private ArrayList<ILiveSysNetworkObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/player/media/observer/LiveSysNetworkObserver$ILiveSysNetworkObserver.class */
    public interface ILiveSysNetworkObserver {
    }

    private LiveSysNetworkObserver() {
    }

    public static LiveSysNetworkObserver a() {
        return f15655a;
    }

    public void a(ILiveSysNetworkObserver iLiveSysNetworkObserver) {
        synchronized (this) {
            if (iLiveSysNetworkObserver != null) {
                this.b.add(iLiveSysNetworkObserver);
            }
        }
    }

    public void b(ILiveSysNetworkObserver iLiveSysNetworkObserver) {
        synchronized (this) {
            if (iLiveSysNetworkObserver != null) {
                this.b.remove(iLiveSysNetworkObserver);
            }
        }
    }
}

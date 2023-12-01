package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveSysNetworkObserver.class */
public class LiveSysNetworkObserver {
    private static LiveSysNetworkObserver a = new LiveSysNetworkObserver();
    private ArrayList<ILiveSysNetworkObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveSysNetworkObserver$ILiveSysNetworkObserver.class */
    public interface ILiveSysNetworkObserver {
        void O();
    }

    private LiveSysNetworkObserver() {
    }

    public static LiveSysNetworkObserver a() {
        return a;
    }

    public void a(ILiveSysNetworkObserver iLiveSysNetworkObserver) {
        synchronized (this) {
            if (iLiveSysNetworkObserver != null) {
                this.b.add(iLiveSysNetworkObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<ILiveSysNetworkObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveSysNetworkObserver next = it.next();
                if (next != null) {
                    next.O();
                }
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

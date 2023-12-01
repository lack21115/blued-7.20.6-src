package com.blued.android.module.shortvideo.manager;

import com.blued.android.module.shortvideo.contract.SysNetworkListener;
import java.util.ArrayList;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/manager/NetWorkObserverManager.class */
public class NetWorkObserverManager {
    private static final NetWorkObserverManager a = new NetWorkObserverManager();
    private ArrayList<SysNetworkListener> b = new ArrayList<>();

    private NetWorkObserverManager() {
    }

    public static NetWorkObserverManager a() {
        return a;
    }

    public void a(SysNetworkListener sysNetworkListener) {
        synchronized (this) {
            if (sysNetworkListener != null) {
                this.b.add(sysNetworkListener);
            }
        }
    }

    public void b(SysNetworkListener sysNetworkListener) {
        synchronized (this) {
            if (sysNetworkListener != null) {
                this.b.remove(sysNetworkListener);
            }
        }
    }
}

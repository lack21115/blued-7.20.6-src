package com.soft.blued.ui.video.manager;

import com.blued.android.module.common.listener.SysNetworkListener;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/video/manager/NetWorkObserverManager.class */
public class NetWorkObserverManager {

    /* renamed from: a  reason: collision with root package name */
    private static final NetWorkObserverManager f34465a = new NetWorkObserverManager();
    private ArrayList<SysNetworkListener> b = new ArrayList<>();

    private NetWorkObserverManager() {
    }

    public static NetWorkObserverManager a() {
        return f34465a;
    }

    public void a(boolean z) {
        synchronized (this) {
            Iterator<SysNetworkListener> it = this.b.iterator();
            while (it.hasNext()) {
                SysNetworkListener next = it.next();
                if (next != null) {
                    next.a(z);
                }
            }
        }
    }

    public void b(boolean z) {
        synchronized (this) {
            Iterator<SysNetworkListener> it = this.b.iterator();
            while (it.hasNext()) {
                SysNetworkListener next = it.next();
                if (next != null) {
                    next.b(z);
                }
            }
        }
    }
}

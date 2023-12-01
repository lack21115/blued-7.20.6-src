package com.soft.blued.ui.user.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.soft.blued.utils.Logger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/VIPBuyResultObserver.class */
public class VIPBuyResultObserver {

    /* renamed from: a  reason: collision with root package name */
    private static VIPBuyResultObserver f20557a = new VIPBuyResultObserver();
    private ArrayList<IVIPBuyResultObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/VIPBuyResultObserver$IVIPBuyResultObserver.class */
    public interface IVIPBuyResultObserver {
        void a(int i, boolean z);
    }

    private VIPBuyResultObserver() {
    }

    public static VIPBuyResultObserver a() {
        return f20557a;
    }

    public void a(int i, boolean z) {
        synchronized (this) {
            Iterator<IVIPBuyResultObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IVIPBuyResultObserver next = it.next();
                if (next != null) {
                    next.a(i, z);
                }
            }
        }
    }

    public void a(IVIPBuyResultObserver iVIPBuyResultObserver) {
        synchronized (this) {
            if (iVIPBuyResultObserver != null) {
                if (!this.b.contains(iVIPBuyResultObserver)) {
                    this.b.add(iVIPBuyResultObserver);
                }
            }
            Logger.e("VIPBuyResultObserver", "add===" + this.b.size());
        }
    }

    public void a(final IVIPBuyResultObserver iVIPBuyResultObserver, Lifecycle lifecycle) {
        synchronized (this) {
            if (iVIPBuyResultObserver != null && lifecycle != null) {
                this.b.add(iVIPBuyResultObserver);
                lifecycle.addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.user.observer.VIPBuyResultObserver.1
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    public void onDestroy() {
                        VIPBuyResultObserver.this.b.remove(iVIPBuyResultObserver);
                    }
                });
            }
        }
    }

    public void b(IVIPBuyResultObserver iVIPBuyResultObserver) {
        synchronized (this) {
            if (iVIPBuyResultObserver != null) {
                this.b.remove(iVIPBuyResultObserver);
            }
            Logger.e("VIPBuyResultObserver", "remove===" + this.b.size());
        }
    }
}

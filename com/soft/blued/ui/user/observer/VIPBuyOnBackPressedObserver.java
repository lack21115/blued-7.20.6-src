package com.soft.blued.ui.user.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/VIPBuyOnBackPressedObserver.class */
public class VIPBuyOnBackPressedObserver {

    /* renamed from: a  reason: collision with root package name */
    private static VIPBuyOnBackPressedObserver f20555a = new VIPBuyOnBackPressedObserver();
    private ArrayList<IVIPBuyOnBackPressedObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/VIPBuyOnBackPressedObserver$IVIPBuyOnBackPressedObserver.class */
    public interface IVIPBuyOnBackPressedObserver {
        boolean onBackPressed();
    }

    private VIPBuyOnBackPressedObserver() {
    }

    public static VIPBuyOnBackPressedObserver a() {
        return f20555a;
    }

    public void a(final IVIPBuyOnBackPressedObserver iVIPBuyOnBackPressedObserver, Lifecycle lifecycle) {
        synchronized (this) {
            if (iVIPBuyOnBackPressedObserver != null && lifecycle != null) {
                this.b.add(iVIPBuyOnBackPressedObserver);
                lifecycle.addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.user.observer.VIPBuyOnBackPressedObserver.1
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    public void onDestroy() {
                        VIPBuyOnBackPressedObserver.this.b.remove(iVIPBuyOnBackPressedObserver);
                    }
                });
            }
        }
    }

    public boolean b() {
        synchronized (this) {
            Iterator<IVIPBuyOnBackPressedObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IVIPBuyOnBackPressedObserver next = it.next();
                if (next != null) {
                    next.onBackPressed();
                }
            }
        }
        return false;
    }
}

package com.soft.blued.ui.find.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.soft.blued.ui.find.model.CallMeStatusData;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/CallHelloObserver.class */
public class CallHelloObserver {

    /* renamed from: a  reason: collision with root package name */
    private static CallHelloObserver f16926a = new CallHelloObserver();
    private ArrayList<ICallHelloObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/CallHelloObserver$ICallHelloObserver.class */
    public interface ICallHelloObserver {
        void a(CallMeStatusData callMeStatusData);

        void a(boolean z, String str);

        void b(int i);
    }

    private CallHelloObserver() {
    }

    public static CallHelloObserver a() {
        return f16926a;
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<ICallHelloObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ICallHelloObserver next = it.next();
                if (next != null) {
                    next.b(i);
                }
            }
        }
    }

    public void a(CallMeStatusData callMeStatusData) {
        synchronized (this) {
            Iterator<ICallHelloObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ICallHelloObserver next = it.next();
                if (next != null) {
                    next.a(callMeStatusData);
                }
            }
        }
    }

    public void a(final ICallHelloObserver iCallHelloObserver, Lifecycle lifecycle) {
        synchronized (this) {
            if (iCallHelloObserver != null && lifecycle != null) {
                this.b.add(iCallHelloObserver);
                lifecycle.addObserver(new LifecycleObserver() { // from class: com.soft.blued.ui.find.observer.CallHelloObserver.1
                    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
                    public void onDestroy() {
                        CallHelloObserver.this.b.remove(iCallHelloObserver);
                    }
                });
            }
        }
    }

    public void a(boolean z, String str) {
        synchronized (this) {
            Iterator<ICallHelloObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ICallHelloObserver next = it.next();
                if (next != null) {
                    next.a(z, str);
                }
            }
        }
    }
}

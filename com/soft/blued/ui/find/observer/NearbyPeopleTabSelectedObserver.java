package com.soft.blued.ui.find.observer;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyPeopleTabSelectedObserver.class */
public class NearbyPeopleTabSelectedObserver {

    /* renamed from: a  reason: collision with root package name */
    private static NearbyPeopleTabSelectedObserver f16933a = new NearbyPeopleTabSelectedObserver();
    private ArrayList<INearbyPeopleTabSelectedObserver> b = new ArrayList<>();

    /* renamed from: com.soft.blued.ui.find.observer.NearbyPeopleTabSelectedObserver$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyPeopleTabSelectedObserver$1.class */
    class AnonymousClass1 implements LifecycleObserver {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ INearbyPeopleTabSelectedObserver f16934a;
        final /* synthetic */ NearbyPeopleTabSelectedObserver b;

        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public void onDestroy() {
            this.b.b.remove(this.f16934a);
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyPeopleTabSelectedObserver$INearbyPeopleTabSelectedObserver.class */
    public interface INearbyPeopleTabSelectedObserver {
        void b(String str);
    }

    private NearbyPeopleTabSelectedObserver() {
    }

    public static NearbyPeopleTabSelectedObserver a() {
        return f16933a;
    }

    public void a(INearbyPeopleTabSelectedObserver iNearbyPeopleTabSelectedObserver) {
        synchronized (this) {
            if (iNearbyPeopleTabSelectedObserver != null) {
                this.b.add(iNearbyPeopleTabSelectedObserver);
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            Iterator<INearbyPeopleTabSelectedObserver> it = this.b.iterator();
            while (it.hasNext()) {
                INearbyPeopleTabSelectedObserver next = it.next();
                if (next != null) {
                    next.b(str);
                }
            }
        }
    }

    public void b(INearbyPeopleTabSelectedObserver iNearbyPeopleTabSelectedObserver) {
        synchronized (this) {
            if (iNearbyPeopleTabSelectedObserver != null) {
                this.b.remove(iNearbyPeopleTabSelectedObserver);
            }
        }
    }
}

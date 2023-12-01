package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyPeoplePushTypeObserver.class */
public class NearbyPeoplePushTypeObserver {

    /* renamed from: a  reason: collision with root package name */
    private static NearbyPeoplePushTypeObserver f16932a = new NearbyPeoplePushTypeObserver();
    private ArrayList<INearbyPeoplePushTypeObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/NearbyPeoplePushTypeObserver$INearbyPeoplePushTypeObserver.class */
    public interface INearbyPeoplePushTypeObserver {
        void a(String str);
    }

    private NearbyPeoplePushTypeObserver() {
    }

    public static NearbyPeoplePushTypeObserver a() {
        return f16932a;
    }

    public void a(INearbyPeoplePushTypeObserver iNearbyPeoplePushTypeObserver) {
        synchronized (this) {
            if (this.b != null) {
                this.b.add(iNearbyPeoplePushTypeObserver);
            }
        }
    }

    public void a(String str) {
        synchronized (this) {
            Iterator<INearbyPeoplePushTypeObserver> it = this.b.iterator();
            while (it.hasNext()) {
                INearbyPeoplePushTypeObserver next = it.next();
                if (next != null) {
                    next.a(str);
                }
            }
        }
    }

    public void b(INearbyPeoplePushTypeObserver iNearbyPeoplePushTypeObserver) {
        ArrayList<INearbyPeoplePushTypeObserver> arrayList = this.b;
        if (arrayList != null) {
            arrayList.remove(iNearbyPeoplePushTypeObserver);
        }
    }
}

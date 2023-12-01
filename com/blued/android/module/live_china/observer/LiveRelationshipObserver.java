package com.blued.android.module.live_china.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveRelationshipObserver.class */
public class LiveRelationshipObserver {
    private static LiveRelationshipObserver a = new LiveRelationshipObserver();
    private ArrayList<ILiveRelationshipObserver> b = new ArrayList<>();

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/observer/LiveRelationshipObserver$ILiveRelationshipObserver.class */
    public interface ILiveRelationshipObserver {
        void b(String str, String str2);
    }

    private LiveRelationshipObserver() {
    }

    public static LiveRelationshipObserver a() {
        return a;
    }

    public void a(ILiveRelationshipObserver iLiveRelationshipObserver) {
        synchronized (this) {
            if (iLiveRelationshipObserver != null) {
                this.b.add(iLiveRelationshipObserver);
            }
        }
    }

    public void a(String str, String str2) {
        synchronized (this) {
            Iterator<ILiveRelationshipObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ILiveRelationshipObserver next = it.next();
                if (next != null) {
                    next.b(str, str2);
                }
            }
        }
    }

    public void b(ILiveRelationshipObserver iLiveRelationshipObserver) {
        synchronized (this) {
            if (iLiveRelationshipObserver != null) {
                this.b.remove(iLiveRelationshipObserver);
            }
        }
    }
}

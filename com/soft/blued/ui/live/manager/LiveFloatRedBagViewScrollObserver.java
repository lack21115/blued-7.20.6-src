package com.soft.blued.ui.live.manager;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/manager/LiveFloatRedBagViewScrollObserver.class */
public class LiveFloatRedBagViewScrollObserver {

    /* renamed from: a  reason: collision with root package name */
    private static LiveFloatRedBagViewScrollObserver f31243a = new LiveFloatRedBagViewScrollObserver();
    private ArrayList<IFloatRedBagViewScrollObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/manager/LiveFloatRedBagViewScrollObserver$IFloatRedBagViewScrollObserver.class */
    public interface IFloatRedBagViewScrollObserver {
        void a(RecyclerView recyclerView, int i, int i2);
    }

    public static LiveFloatRedBagViewScrollObserver a() {
        return f31243a;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        synchronized (this) {
            Iterator<IFloatRedBagViewScrollObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IFloatRedBagViewScrollObserver next = it.next();
                if (next != null) {
                    next.a(recyclerView, i, i2);
                }
            }
        }
    }

    public void a(IFloatRedBagViewScrollObserver iFloatRedBagViewScrollObserver) {
        synchronized (this) {
            if (iFloatRedBagViewScrollObserver != null) {
                this.b.add(iFloatRedBagViewScrollObserver);
            }
        }
    }

    public void b(IFloatRedBagViewScrollObserver iFloatRedBagViewScrollObserver) {
        synchronized (this) {
            if (iFloatRedBagViewScrollObserver != null) {
                this.b.remove(iFloatRedBagViewScrollObserver);
            }
        }
    }
}

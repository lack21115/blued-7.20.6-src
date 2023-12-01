package com.soft.blued.ui.live.manager;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/manager/LiveHotViewScrollObserver.class */
public class LiveHotViewScrollObserver {

    /* renamed from: a  reason: collision with root package name */
    private static LiveHotViewScrollObserver f31244a = new LiveHotViewScrollObserver();
    private ArrayList<IScrollObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/manager/LiveHotViewScrollObserver$IScrollObserver.class */
    public interface IScrollObserver {
        void a(RecyclerView recyclerView, int i, int i2);
    }

    public static LiveHotViewScrollObserver a() {
        return f31244a;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        synchronized (this) {
            Iterator<IScrollObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IScrollObserver next = it.next();
                if (next != null) {
                    next.a(recyclerView, i, i2);
                }
            }
        }
    }

    public void a(IScrollObserver iScrollObserver) {
        synchronized (this) {
            if (iScrollObserver != null) {
                this.b.add(iScrollObserver);
            }
        }
    }

    public void b(IScrollObserver iScrollObserver) {
        synchronized (this) {
            if (iScrollObserver != null) {
                this.b.remove(iScrollObserver);
            }
        }
    }
}

package com.soft.blued.ui.find.observer;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/FloatRedBagViewScrollObserver.class */
public class FloatRedBagViewScrollObserver {

    /* renamed from: a  reason: collision with root package name */
    private static FloatRedBagViewScrollObserver f16928a = new FloatRedBagViewScrollObserver();
    private ArrayList<IFloatRedBagViewScrollObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/FloatRedBagViewScrollObserver$IFloatRedBagViewScrollObserver.class */
    public interface IFloatRedBagViewScrollObserver {
        void a(RecyclerView recyclerView, int i, int i2);
    }

    private FloatRedBagViewScrollObserver() {
    }

    public static FloatRedBagViewScrollObserver a() {
        return f16928a;
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

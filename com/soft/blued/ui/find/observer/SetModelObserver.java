package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/SetModelObserver.class */
public class SetModelObserver {

    /* renamed from: a  reason: collision with root package name */
    private static SetModelObserver f16939a = new SetModelObserver();
    private ArrayList<ISetModelObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/SetModelObserver$ISetModelObserver.class */
    public interface ISetModelObserver {
        void a(int i);
    }

    private SetModelObserver() {
    }

    public static SetModelObserver a() {
        return f16939a;
    }

    public void a(int i) {
        synchronized (this) {
            Iterator<ISetModelObserver> it = this.b.iterator();
            while (it.hasNext()) {
                ISetModelObserver next = it.next();
                if (next != null) {
                    next.a(i);
                }
            }
        }
    }

    public void a(ISetModelObserver iSetModelObserver) {
        synchronized (this) {
            if (iSetModelObserver != null) {
                this.b.add(iSetModelObserver);
            }
        }
    }

    public void b(ISetModelObserver iSetModelObserver) {
        synchronized (this) {
            if (iSetModelObserver != null) {
                this.b.remove(iSetModelObserver);
            }
        }
    }
}

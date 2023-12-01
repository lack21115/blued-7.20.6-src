package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/SwipeRefreshObserver.class */
public class SwipeRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    private static SwipeRefreshObserver f16940a = new SwipeRefreshObserver();
    private ArrayList<IEnableRefeshObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/SwipeRefreshObserver$IEnableRefeshObserver.class */
    public interface IEnableRefeshObserver {
        void a();
    }

    private SwipeRefreshObserver() {
    }

    public static SwipeRefreshObserver a() {
        return f16940a;
    }

    public void b() {
        synchronized (this) {
            Iterator<IEnableRefeshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IEnableRefeshObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }
}

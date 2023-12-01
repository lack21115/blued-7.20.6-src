package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/HomeADDataObserver.class */
public class HomeADDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static HomeADDataObserver f16929a = new HomeADDataObserver();
    private ArrayList<IHomeADDataObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/HomeADDataObserver$IHomeADDataObserver.class */
    public interface IHomeADDataObserver {
        void a();
    }

    private HomeADDataObserver() {
    }

    public static HomeADDataObserver a() {
        return f16929a;
    }

    public void b() {
        synchronized (this) {
            Iterator<IHomeADDataObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IHomeADDataObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }
}

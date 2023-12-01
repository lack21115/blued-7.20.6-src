package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/AdFloatObserver.class */
public class AdFloatObserver {

    /* renamed from: a  reason: collision with root package name */
    private static AdFloatObserver f16924a = new AdFloatObserver();
    private ArrayList<IAdFloatObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/AdFloatObserver$IAdFloatObserver.class */
    public interface IAdFloatObserver {
        void ae_();
    }

    private AdFloatObserver() {
    }

    public static AdFloatObserver a() {
        return f16924a;
    }

    public void a(IAdFloatObserver iAdFloatObserver) {
        synchronized (this) {
            if (iAdFloatObserver != null) {
                this.b.add(iAdFloatObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IAdFloatObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IAdFloatObserver next = it.next();
                if (next != null) {
                    next.ae_();
                }
            }
        }
    }

    public void b(IAdFloatObserver iAdFloatObserver) {
        synchronized (this) {
            if (iAdFloatObserver != null) {
                this.b.remove(iAdFloatObserver);
            }
        }
    }
}

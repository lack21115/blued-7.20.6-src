package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/PersonalVerifyObserver.class */
public class PersonalVerifyObserver {

    /* renamed from: a  reason: collision with root package name */
    private static PersonalVerifyObserver f16938a = new PersonalVerifyObserver();
    private ArrayList<IPersonalVerifyObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/PersonalVerifyObserver$IPersonalVerifyObserver.class */
    public interface IPersonalVerifyObserver {
        void a();
    }

    private PersonalVerifyObserver() {
    }

    public static PersonalVerifyObserver a() {
        return f16938a;
    }

    public void a(IPersonalVerifyObserver iPersonalVerifyObserver) {
        synchronized (this) {
            if (iPersonalVerifyObserver != null) {
                this.b.add(iPersonalVerifyObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IPersonalVerifyObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IPersonalVerifyObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void b(IPersonalVerifyObserver iPersonalVerifyObserver) {
        synchronized (this) {
            if (iPersonalVerifyObserver != null) {
                this.b.remove(iPersonalVerifyObserver);
            }
        }
    }
}

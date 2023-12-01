package com.soft.blued.ui.find.observer;

import java.util.ArrayList;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/BlackListDataObserver.class */
public class BlackListDataObserver {

    /* renamed from: a  reason: collision with root package name */
    private static BlackListDataObserver f30615a = new BlackListDataObserver();
    private ArrayList<IBlackListDataObserver> b = new ArrayList<>();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/BlackListDataObserver$IBlackListDataObserver.class */
    public interface IBlackListDataObserver {
    }

    private BlackListDataObserver() {
    }

    public static BlackListDataObserver a() {
        return f30615a;
    }

    public void a(IBlackListDataObserver iBlackListDataObserver) {
        synchronized (this) {
            if (iBlackListDataObserver != null) {
                this.b.add(iBlackListDataObserver);
            }
        }
    }

    public void b(IBlackListDataObserver iBlackListDataObserver) {
        synchronized (this) {
            if (iBlackListDataObserver != null) {
                this.b.remove(iBlackListDataObserver);
            }
        }
    }
}

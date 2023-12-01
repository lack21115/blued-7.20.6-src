package com.soft.blued.utils;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/CommonDataRefreshObserver.class */
public class CommonDataRefreshObserver {

    /* renamed from: a  reason: collision with root package name */
    private static CommonDataRefreshObserver f21042a = new CommonDataRefreshObserver();
    private ArrayList<IDataRefreshObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/utils/CommonDataRefreshObserver$IDataRefreshObserver.class */
    public interface IDataRefreshObserver {
        void a();
    }

    private CommonDataRefreshObserver() {
    }

    public static CommonDataRefreshObserver a() {
        return f21042a;
    }

    public void a(IDataRefreshObserver iDataRefreshObserver) {
        synchronized (this) {
            if (iDataRefreshObserver != null) {
                this.b.add(iDataRefreshObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IDataRefreshObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IDataRefreshObserver next = it.next();
                if (next != null) {
                    next.a();
                }
            }
        }
    }

    public void b(IDataRefreshObserver iDataRefreshObserver) {
        synchronized (this) {
            if (iDataRefreshObserver != null) {
                this.b.remove(iDataRefreshObserver);
            }
        }
    }
}

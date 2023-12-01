package com.soft.blued.ui.welcome.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/observer/ADDownloadObserver.class */
public class ADDownloadObserver {

    /* renamed from: a  reason: collision with root package name */
    private static ADDownloadObserver f34665a = new ADDownloadObserver();
    private ArrayList<IADDownloadObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/welcome/observer/ADDownloadObserver$IADDownloadObserver.class */
    public interface IADDownloadObserver {
        void m();
    }

    private ADDownloadObserver() {
    }

    public static ADDownloadObserver a() {
        return f34665a;
    }

    public void a(IADDownloadObserver iADDownloadObserver) {
        synchronized (this) {
            if (iADDownloadObserver != null) {
                this.b.add(iADDownloadObserver);
            }
        }
    }

    public void b() {
        synchronized (this) {
            Iterator<IADDownloadObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IADDownloadObserver next = it.next();
                if (next != null) {
                    next.m();
                }
            }
        }
    }

    public void b(IADDownloadObserver iADDownloadObserver) {
        synchronized (this) {
            if (iADDownloadObserver != null) {
                this.b.remove(iADDownloadObserver);
            }
        }
    }
}

package com.soft.blued.ui.user.observer;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/ReportObserver.class */
public class ReportObserver {

    /* renamed from: a  reason: collision with root package name */
    private static ReportObserver f34242a = new ReportObserver();
    private ArrayList<IReportObserver> b = new ArrayList<>();

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/observer/ReportObserver$IReportObserver.class */
    public interface IReportObserver {
        void a(boolean z);
    }

    private ReportObserver() {
    }

    public static ReportObserver a() {
        return f34242a;
    }

    public void a(IReportObserver iReportObserver) {
        synchronized (this) {
            if (iReportObserver != null) {
                this.b.add(iReportObserver);
            }
        }
    }

    public void a(boolean z) {
        synchronized (this) {
            Iterator<IReportObserver> it = this.b.iterator();
            while (it.hasNext()) {
                IReportObserver next = it.next();
                if (next != null) {
                    next.a(z);
                }
            }
        }
    }

    public void b(IReportObserver iReportObserver) {
        synchronized (this) {
            if (iReportObserver != null) {
                this.b.remove(iReportObserver);
            }
        }
    }
}

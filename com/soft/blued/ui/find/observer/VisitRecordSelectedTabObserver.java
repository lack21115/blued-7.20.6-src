package com.soft.blued.ui.find.observer;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/VisitRecordSelectedTabObserver.class */
public class VisitRecordSelectedTabObserver {

    /* renamed from: a  reason: collision with root package name */
    private static VisitRecordSelectedTabObserver f30632a = new VisitRecordSelectedTabObserver();
    private List<IVisitRecordSelectedTabObserver> b = new ArrayList();

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/observer/VisitRecordSelectedTabObserver$IVisitRecordSelectedTabObserver.class */
    public interface IVisitRecordSelectedTabObserver {
        void a(int i);
    }

    private VisitRecordSelectedTabObserver() {
    }

    public static VisitRecordSelectedTabObserver a() {
        return f30632a;
    }

    public void a(int i) {
        synchronized (this) {
            for (IVisitRecordSelectedTabObserver iVisitRecordSelectedTabObserver : this.b) {
                if (iVisitRecordSelectedTabObserver != null) {
                    iVisitRecordSelectedTabObserver.a(i);
                }
            }
        }
    }

    public void a(IVisitRecordSelectedTabObserver iVisitRecordSelectedTabObserver) {
        synchronized (this) {
            if (iVisitRecordSelectedTabObserver != null) {
                this.b.add(iVisitRecordSelectedTabObserver);
            }
        }
    }

    public void b(IVisitRecordSelectedTabObserver iVisitRecordSelectedTabObserver) {
        synchronized (this) {
            if (iVisitRecordSelectedTabObserver != null) {
                this.b.remove(iVisitRecordSelectedTabObserver);
            }
        }
    }
}

package com.alibaba.mtl.appmonitor;

import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.log.e.i;

/* loaded from: source-6737240-dex2jar.jar:com/alibaba/mtl/appmonitor/TransactionDelegate.class */
public class TransactionDelegate {
    private static void a(Transaction transaction) {
        if (transaction == null || transaction.b == null) {
            return;
        }
        e.a().a(transaction.r, transaction.f4451a, transaction.o, transaction.p, DimensionValueSet.create().addValues(transaction.b));
    }

    public static void begin(Transaction transaction, String str) {
        try {
            if (AppMonitorDelegate.i && transaction != null) {
                i.a("TransactionDelegate", "statEvent begin. module: ", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                if (f.STAT.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, transaction.o, transaction.p)) {
                        e.a().a(transaction.r, transaction.f4451a, transaction.o, transaction.p, str);
                        a(transaction);
                    }
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m2144a(th);
        }
    }

    public static void end(Transaction transaction, String str) {
        try {
            if (AppMonitorDelegate.i && transaction != null) {
                i.a("TransactionDelegate", "statEvent end. module: ", transaction.o, " monitorPoint: ", transaction.p, " measureName: ", str);
                if (f.STAT.isOpen()) {
                    if (AppMonitorDelegate.IS_DEBUG || j.a(f.STAT, transaction.o, transaction.p)) {
                        a(transaction);
                        e.a().a(transaction.r, str, false);
                    }
                }
            }
        } catch (Throwable th) {
            com.alibaba.mtl.appmonitor.b.b.m2144a(th);
        }
    }
}

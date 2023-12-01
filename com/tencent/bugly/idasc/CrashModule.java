package com.tencent.bugly.idasc;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.proguard.aa;
import com.tencent.bugly.idasc.proguard.al;
import com.tencent.bugly.idasc.proguard.at;
import com.tencent.bugly.idasc.proguard.o;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/idasc/CrashModule.class */
public class CrashModule extends o {
    public static final int MODULE_ID = 1004;

    /* renamed from: c  reason: collision with root package name */
    private static int f35187c;
    private static CrashModule e = new CrashModule();

    /* renamed from: a  reason: collision with root package name */
    private long f35188a;
    private BuglyStrategy.a b;
    private boolean d = false;

    private void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (this) {
            if (buglyStrategy == null) {
                return;
            }
            String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                aa.a(context).t = libBuglySOFilePath;
                al.a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.b = buglyStrategy.getCrashHandleCallback();
                al.a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                long appReportDelay = buglyStrategy.getAppReportDelay();
                this.f35188a = appReportDelay;
                al.a("setted delay: %d", Long.valueOf(appReportDelay));
            }
        }
    }

    public static CrashModule getInstance() {
        e.id = 1004;
        return e;
    }

    @Override // com.tencent.bugly.idasc.proguard.o
    public String[] getTables() {
        return new String[]{"t_cr"};
    }

    public boolean hasInitialized() {
        boolean z;
        synchronized (this) {
            z = this.d;
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00bb A[Catch: all -> 0x0161, TryCatch #0 {, blocks: (B:6:0x0006, B:9:0x0010, B:11:0x0058, B:13:0x0083, B:18:0x00a7, B:20:0x00bb, B:23:0x00c7, B:26:0x00d1, B:30:0x00ec, B:33:0x00f6, B:37:0x0111, B:40:0x011c, B:41:0x0125, B:34:0x0108, B:27:0x00e3, B:14:0x008e, B:16:0x0097, B:17:0x009d), top: B:53:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ec A[Catch: all -> 0x0161, TRY_ENTER, TryCatch #0 {, blocks: (B:6:0x0006, B:9:0x0010, B:11:0x0058, B:13:0x0083, B:18:0x00a7, B:20:0x00bb, B:23:0x00c7, B:26:0x00d1, B:30:0x00ec, B:33:0x00f6, B:37:0x0111, B:40:0x011c, B:41:0x0125, B:34:0x0108, B:27:0x00e3, B:14:0x008e, B:16:0x0097, B:17:0x009d), top: B:53:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0111 A[Catch: all -> 0x0161, TRY_ENTER, TryCatch #0 {, blocks: (B:6:0x0006, B:9:0x0010, B:11:0x0058, B:13:0x0083, B:18:0x00a7, B:20:0x00bb, B:23:0x00c7, B:26:0x00d1, B:30:0x00ec, B:33:0x00f6, B:37:0x0111, B:40:0x011c, B:41:0x0125, B:34:0x0108, B:27:0x00e3, B:14:0x008e, B:16:0x0097, B:17:0x009d), top: B:53:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c A[Catch: all -> 0x0161, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0006, B:9:0x0010, B:11:0x0058, B:13:0x0083, B:18:0x00a7, B:20:0x00bb, B:23:0x00c7, B:26:0x00d1, B:30:0x00ec, B:33:0x00f6, B:37:0x0111, B:40:0x011c, B:41:0x0125, B:34:0x0108, B:27:0x00e3, B:14:0x008e, B:16:0x0097, B:17:0x009d), top: B:53:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0169  */
    @Override // com.tencent.bugly.idasc.proguard.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(android.content.Context r5, boolean r6, com.tencent.bugly.idasc.BuglyStrategy r7) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.idasc.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.idasc.proguard.o
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        at a2;
        if (strategyBean == null || (a2 = at.a()) == null) {
            return;
        }
        a2.t.a(strategyBean);
        a2.u.onStrategyChanged(strategyBean);
        a2.x.b();
    }
}

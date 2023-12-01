package com.tencent.bugly;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.x;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/bugly/CrashModule.class */
public class CrashModule extends a {
    public static final int MODULE_ID = 1004;

    /* renamed from: c  reason: collision with root package name */
    private static int f35106c;
    private static CrashModule e = new CrashModule();

    /* renamed from: a  reason: collision with root package name */
    private long f35107a;
    private BuglyStrategy.a b;
    private boolean d = false;

    private void a(Context context, BuglyStrategy buglyStrategy) {
        synchronized (this) {
            if (buglyStrategy == null) {
                return;
            }
            String libBuglySOFilePath = buglyStrategy.getLibBuglySOFilePath();
            if (!TextUtils.isEmpty(libBuglySOFilePath)) {
                com.tencent.bugly.crashreport.common.info.a.a(context).n = libBuglySOFilePath;
                x.a("setted libBugly.so file path :%s", libBuglySOFilePath);
            }
            if (buglyStrategy.getCrashHandleCallback() != null) {
                this.b = buglyStrategy.getCrashHandleCallback();
                x.a("setted CrashHanldeCallback", new Object[0]);
            }
            if (buglyStrategy.getAppReportDelay() > 0) {
                long appReportDelay = buglyStrategy.getAppReportDelay();
                this.f35107a = appReportDelay;
                x.a("setted delay: %d", Long.valueOf(appReportDelay));
            }
        }
    }

    public static CrashModule getInstance() {
        e.id = 1004;
        return e;
    }

    @Override // com.tencent.bugly.a
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

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2 A[Catch: all -> 0x0117, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:6:0x0006, B:9:0x0010, B:11:0x005d, B:14:0x0073, B:16:0x007a, B:18:0x0081, B:20:0x0088, B:23:0x0092, B:27:0x00ad, B:30:0x00b7, B:34:0x00d2, B:35:0x00db, B:31:0x00c9, B:24:0x00a4), top: B:47:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011f  */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(android.content.Context r8, boolean r9, com.tencent.bugly.BuglyStrategy r10) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.CrashModule.init(android.content.Context, boolean, com.tencent.bugly.BuglyStrategy):void");
    }

    @Override // com.tencent.bugly.a
    public void onServerStrategyChanged(StrategyBean strategyBean) {
        c a2;
        if (strategyBean == null || (a2 = c.a()) == null) {
            return;
        }
        a2.a(strategyBean);
    }
}

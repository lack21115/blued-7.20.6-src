package com.umeng.analytics.vshelper;

import android.app.Activity;
import android.os.Bundle;
import com.umeng.analytics.pro.bm;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/vshelper/b.class */
public class b implements bm {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40811a = "RealTimeDebugSwitch";
    private static volatile int b;

    public static boolean d() {
        return b > 0;
    }

    @Override // com.umeng.analytics.pro.bm
    public void a() {
    }

    @Override // com.umeng.analytics.pro.bm
    public void a(Activity activity) {
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a4  */
    @Override // com.umeng.analytics.pro.bm
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.app.Activity r6, android.os.Bundle r7) {
        /*
            Method dump skipped, instructions count: 490
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.vshelper.b.a(android.app.Activity, android.os.Bundle):void");
    }

    @Override // com.umeng.analytics.pro.bm
    public void b() {
    }

    @Override // com.umeng.analytics.pro.bm
    public void b(Activity activity) {
    }

    @Override // com.umeng.analytics.pro.bm
    public void b(Activity activity, Bundle bundle) {
    }

    @Override // com.umeng.analytics.pro.bm
    public void c() {
    }

    @Override // com.umeng.analytics.pro.bm
    public void c(Activity activity) {
        b++;
    }

    @Override // com.umeng.analytics.pro.bm
    public void d(Activity activity) {
        b--;
    }

    @Override // com.umeng.analytics.pro.bm
    public void e(Activity activity) {
    }
}

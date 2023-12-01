package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/af.class */
public class af implements aa {

    /* renamed from: a  reason: collision with root package name */
    private int f40616a;

    public af(int i) {
        this.f40616a = 0;
        this.f40616a = i;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        long j = 0;
        try {
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            j = 0;
            if (a2 != null) {
                long j2 = a2.getLong(aq.f40628a, 0L);
                j = j2;
                j = j2;
                if (j2 >= this.f40616a) {
                    return true;
                }
            }
        } catch (Throwable th) {
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j + " ; config: " + this.f40616a);
        return false;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }
}

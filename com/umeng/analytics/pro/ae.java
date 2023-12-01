package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ae.class */
public class ae implements aa {

    /* renamed from: a  reason: collision with root package name */
    private String f26924a;
    private long b;

    public ae(String str, long j) {
        this.f26924a = "";
        this.b = 0L;
        this.f26924a = str;
        this.b = j;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            String str = aq.b + this.f26924a;
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                long currentTimeMillis = System.currentTimeMillis() - a2.getLong(str, 0L);
                if (currentTimeMillis > this.b * 1000) {
                    return true;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.b * 1000));
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
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

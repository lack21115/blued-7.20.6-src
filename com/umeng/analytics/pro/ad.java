package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/ad.class */
public class ad implements aa {

    /* renamed from: a  reason: collision with root package name */
    private Set<Integer> f40614a;

    public ad(Set<Integer> set) {
        this.f40614a = null;
        this.f40614a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            int i = Calendar.getInstance().get(11);
            if (this.f40614a == null || !this.f40614a.contains(Integer.valueOf(i))) {
                String str = "";
                for (Integer num : this.f40614a) {
                    str = str + num + ",";
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "HourOn skipped. hour of day: " + i + "; config: " + str);
                return false;
            }
            return true;
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

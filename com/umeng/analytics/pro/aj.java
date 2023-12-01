package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/aj.class */
public class aj implements aa {

    /* renamed from: a  reason: collision with root package name */
    private Set<Integer> f40620a;

    public aj(Set<Integer> set) {
        this.f40620a = null;
        this.f40620a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i = calendar.get(7) - 1;
            int i2 = i != 0 ? i : 7;
            if (this.f40620a == null || !this.f40620a.contains(Integer.valueOf(i2))) {
                String str = "";
                for (Integer num : this.f40620a) {
                    str = str + num + ",";
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "WeekOn skipped. day of week: " + i2 + "; config: " + str);
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

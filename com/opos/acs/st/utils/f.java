package com.opos.acs.st.utils;

import android.content.Context;
import java.lang.reflect.Field;
import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/opos/acs/st/utils/f.class */
public final class f extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    private long f24467a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f24468c;
    private Context d;

    public f(Context context, long j, long j2, long j3) {
        this.f24467a = 60000L;
        this.b = 60000L;
        this.f24468c = 60000L;
        this.d = context;
        this.f24467a = j;
        this.b = j2;
        this.f24468c = j3;
    }

    private void a(long j) {
        a(TimerTask.class, this, "period", Long.valueOf(j));
    }

    private static boolean a(Class<?> cls, Object obj, String str, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
            return true;
        } catch (Exception e) {
            d.a("ReportTimerTask", "setDeclaredField!", e);
            return false;
        }
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        long j;
        d.a("ReportTimerTask", "schedule report task now!!!");
        Context context = this.d;
        if (context != null) {
            if (!com.opos.cmn.an.h.c.a.d(context)) {
                d.a("ReportTimerTask", "schedule task no net!");
                return;
            }
            h.b(this.d);
            long j2 = this.f24467a;
            if (j2 != 0) {
                long j3 = this.b;
                if (j3 == 0 || j2 == j3) {
                    return;
                }
                if (h.d(this.d) && this.f24468c == this.f24467a) {
                    a(this.b);
                    j = this.b;
                } else if (h.d(this.d) || this.f24468c != this.b) {
                    return;
                } else {
                    a(this.f24467a);
                    j = this.f24467a;
                }
                this.f24468c = j;
            }
        }
    }
}

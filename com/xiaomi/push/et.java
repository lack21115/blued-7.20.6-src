package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.xiaomi.push.es;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/et.class */
public class et implements es.a {

    /* renamed from: a  reason: collision with other field name */
    protected Context f360a;

    /* renamed from: a  reason: collision with other field name */
    private PendingIntent f359a = null;

    /* renamed from: a  reason: collision with root package name */
    private volatile long f27693a = 0;

    public et(Context context) {
        this.f360a = null;
        this.f360a = context;
    }

    private void a(AlarmManager alarmManager, long j, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j), pendingIntent);
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.d("[Alarm] invoke setExact method meet error. ".concat(String.valueOf(e)));
        }
    }

    @Override // com.xiaomi.push.es.a
    public void a() {
        if (this.f359a != null) {
            try {
                ((AlarmManager) this.f360a.getSystemService("alarm")).cancel(this.f359a);
            } catch (Exception e) {
            } catch (Throwable th) {
                this.f359a = null;
                com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
                this.f27693a = 0L;
                throw th;
            }
            this.f359a = null;
            com.xiaomi.channel.commonutils.logger.b.c("[Alarm] unregister timer");
            this.f27693a = 0L;
        }
        this.f27693a = 0L;
    }

    public void a(Intent intent, long j) {
        AlarmManager alarmManager = (AlarmManager) this.f360a.getSystemService("alarm");
        this.f359a = Build.VERSION.SDK_INT >= 31 ? PendingIntent.getBroadcast(this.f360a, 0, intent, 33554432) : PendingIntent.getBroadcast(this.f360a, 0, intent, 0);
        if (Build.VERSION.SDK_INT >= 31 && !j.m8998a(this.f360a)) {
            alarmManager.set(2, j, this.f359a);
        } else if (Build.VERSION.SDK_INT >= 23) {
            bi.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j), this.f359a);
        } else {
            a(alarmManager, j, this.f359a);
        }
        com.xiaomi.channel.commonutils.logger.b.c("[Alarm] register timer ".concat(String.valueOf(j)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r7.f27693a < r0) goto L18;
     */
    @Override // com.xiaomi.push.es.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r8) {
        /*
            r7 = this;
            r0 = r7
            android.content.Context r0 = r0.f360a
            com.xiaomi.push.service.o r0 = com.xiaomi.push.service.o.a(r0)
            long r0 = r0.m9141a()
            r9 = r0
            r0 = r8
            if (r0 != 0) goto L19
            r0 = r7
            long r0 = r0.f27693a
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L19
            return
        L19:
            r0 = r8
            if (r0 == 0) goto L21
            r0 = r7
            r0.a()
        L21:
            long r0 = android.os.SystemClock.elapsedRealtime()
            r11 = r0
            r0 = r8
            if (r0 != 0) goto L57
            r0 = r7
            long r0 = r0.f27693a
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L36
            goto L57
        L36:
            r0 = r7
            long r0 = r0.f27693a
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L66
            r0 = r7
            r1 = r7
            long r1 = r1.f27693a
            r2 = r9
            long r1 = r1 + r2
            r0.f27693a = r1
            r0 = r7
            long r0 = r0.f27693a
            r1 = r11
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L66
            goto L5e
        L57:
            r0 = r9
            r1 = r11
            r2 = r9
            long r1 = r1 % r2
            long r0 = r0 - r1
            r9 = r0
        L5e:
            r0 = r7
            r1 = r11
            r2 = r9
            long r1 = r1 + r2
            r0.f27693a = r1
        L66:
            android.content.Intent r0 = new android.content.Intent
            r1 = r0
            java.lang.String r2 = com.xiaomi.push.service.bk.p
            r1.<init>(r2)
            r13 = r0
            r0 = r13
            r1 = r7
            android.content.Context r1 = r1.f360a
            java.lang.String r1 = r1.getPackageName()
            android.content.Intent r0 = r0.setPackage(r1)
            r0 = r7
            r1 = r13
            r2 = r7
            long r2 = r2.f27693a
            r0.a(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.et.a(boolean):void");
    }

    @Override // com.xiaomi.push.es.a
    /* renamed from: a */
    public boolean mo8682a() {
        return this.f27693a != 0;
    }
}

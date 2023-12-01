package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.xiaomi.push.ai;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dp.class */
public class dp {

    /* renamed from: a  reason: collision with root package name */
    private static volatile dp f41341a;

    /* renamed from: a  reason: collision with other field name */
    private Context f308a;

    /* renamed from: a  reason: collision with other field name */
    private a f309a;

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/dp$a.class */
    public interface a {
        void a();
    }

    private dp(Context context) {
        this.f308a = context;
    }

    public static int a(int i) {
        return Math.max(60, i);
    }

    public static dp a(Context context) {
        if (f41341a == null) {
            synchronized (dp.class) {
                try {
                    if (f41341a == null) {
                        f41341a = new dp(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41341a;
    }

    private void a(com.xiaomi.push.service.ba baVar, ai aiVar, boolean z) {
        if (baVar.a(hl.UploadSwitch.a(), true)) {
            dt dtVar = new dt(this.f308a);
            if (z) {
                aiVar.a((ai.a) dtVar, a(baVar.a(hl.UploadFrequency.a(), 86400)));
            } else {
                aiVar.m11502a((ai.a) dtVar);
            }
        }
    }

    private boolean a() {
        try {
            ((Application) (this.f308a instanceof Application ? this.f308a : this.f308a.getApplicationContext())).registerActivityLifecycleCallbacks(new dj(this.f308a, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.a(e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        ai a2 = ai.a(this.f308a);
        com.xiaomi.push.service.ba a3 = com.xiaomi.push.service.ba.a(this.f308a);
        SharedPreferences sharedPreferences = this.f308a.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j) < com.baidu.mobads.sdk.internal.bj.e) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(hl.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(hl.StorageCollectionFrequency.a(), 86400));
            a2.a(new ds(this.f308a, a4), a4, 0);
        }
        if (j.m12048a(this.f308a) && (aVar = this.f309a) != null) {
            aVar.a();
        }
        if (a3.a(hl.ActivityTSSwitch.a(), false)) {
            a();
        }
        a(a3, a2, true);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m11625a() {
        ai.a(this.f308a).a(new dq(this));
    }
}

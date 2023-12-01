package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bx.class */
public final class bx implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bx f27964a;

    /* renamed from: a  reason: collision with other field name */
    private long f985a;

    /* renamed from: a  reason: collision with other field name */
    Context f986a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f987a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f989a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f988a = new ConcurrentHashMap<>();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bx$a.class */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f27965a;

        /* renamed from: a  reason: collision with other field name */
        String f990a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f990a = str;
            this.f27965a = j;
        }

        abstract void a(bx bxVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bx.f27964a != null) {
                Context context = bx.f27964a.f986a;
                if (com.xiaomi.push.bh.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bx.f27964a.f987a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f990a, 0L) > this.f27965a || com.xiaomi.push.af.a(context)) {
                        SharedPreferences.Editor edit = bx.f27964a.f987a.edit();
                        com.xiaomi.push.p.a(edit.putLong(":ts-" + this.f990a, System.currentTimeMillis()));
                        a(bx.f27964a);
                    }
                }
            }
        }
    }

    private bx(Context context) {
        this.f986a = context.getApplicationContext();
        this.f987a = context.getSharedPreferences("sync", 0);
    }

    public static bx a(Context context) {
        if (f27964a == null) {
            synchronized (bx.class) {
                try {
                    if (f27964a == null) {
                        f27964a = new bx(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27964a;
    }

    public final String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f987a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ar
    /* renamed from: a  reason: collision with other method in class */
    public final void mo9125a() {
        if (this.f989a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f985a < 3600000) {
            return;
        }
        this.f985a = currentTimeMillis;
        this.f989a = true;
        com.xiaomi.push.ai.a(this.f986a).a(new by(this), (int) (Math.random() * 10.0d));
    }

    public final void a(a aVar) {
        if (this.f988a.putIfAbsent(aVar.f990a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f986a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public final void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f27964a.f987a.edit();
        com.xiaomi.push.p.a(edit.putString(str + ":" + str2, str3));
    }
}

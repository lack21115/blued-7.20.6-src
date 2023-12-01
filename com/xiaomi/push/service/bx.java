package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.internal.util.cm.QSConstants;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bx.class */
public final class bx implements ar {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bx f41655a;

    /* renamed from: a  reason: collision with other field name */
    private long f1032a;

    /* renamed from: a  reason: collision with other field name */
    Context f1033a;

    /* renamed from: a  reason: collision with other field name */
    private SharedPreferences f1034a;

    /* renamed from: a  reason: collision with other field name */
    private volatile boolean f1036a = false;

    /* renamed from: a  reason: collision with other field name */
    private ConcurrentHashMap<String, a> f1035a = new ConcurrentHashMap<>();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bx$a.class */
    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        long f41656a;

        /* renamed from: a  reason: collision with other field name */
        String f1037a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(String str, long j) {
            this.f1037a = str;
            this.f41656a = j;
        }

        abstract void a(bx bxVar);

        @Override // java.lang.Runnable
        public void run() {
            if (bx.f41655a != null) {
                Context context = bx.f41655a.f1033a;
                if (com.xiaomi.push.bh.d(context)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    SharedPreferences sharedPreferences = bx.f41655a.f1034a;
                    if (currentTimeMillis - sharedPreferences.getLong(":ts-" + this.f1037a, 0L) > this.f41656a || com.xiaomi.push.af.a(context)) {
                        SharedPreferences.Editor edit = bx.f41655a.f1034a.edit();
                        com.xiaomi.push.p.a(edit.putLong(":ts-" + this.f1037a, System.currentTimeMillis()));
                        a(bx.f41655a);
                    }
                }
            }
        }
    }

    private bx(Context context) {
        this.f1033a = context.getApplicationContext();
        this.f1034a = context.getSharedPreferences(QSConstants.TILE_SYNC, 0);
    }

    public static bx a(Context context) {
        if (f41655a == null) {
            synchronized (bx.class) {
                try {
                    if (f41655a == null) {
                        f41655a = new bx(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41655a;
    }

    public final String a(String str, String str2) {
        SharedPreferences sharedPreferences = this.f1034a;
        return sharedPreferences.getString(str + ":" + str2, "");
    }

    @Override // com.xiaomi.push.service.ar
    /* renamed from: a  reason: collision with other method in class */
    public final void mo12175a() {
        if (this.f1036a) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f1032a < 3600000) {
            return;
        }
        this.f1032a = currentTimeMillis;
        this.f1036a = true;
        com.xiaomi.push.ai.a(this.f1033a).a(new by(this), (int) (Math.random() * 10.0d));
    }

    public final void a(a aVar) {
        if (this.f1035a.putIfAbsent(aVar.f1037a, aVar) == null) {
            com.xiaomi.push.ai.a(this.f1033a).a(aVar, ((int) (Math.random() * 30.0d)) + 10);
        }
    }

    public final void a(String str, String str2, String str3) {
        SharedPreferences.Editor edit = f41655a.f1034a.edit();
        com.xiaomi.push.p.a(edit.putString(str + ":" + str2, str3));
    }
}

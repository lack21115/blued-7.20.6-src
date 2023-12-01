package com.bytedance.bdtracker;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.applog.IOaidObserver;
import com.bytedance.bdtracker.m3;
import com.bytedance.bdtracker.s3;
import com.bytedance.bdtracker.z2;
import com.igexin.assist.util.AssistUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/r3.class */
public final class r3 {
    public static final String i;
    public static final String j;
    public static final List<IOaidObserver> k = new ArrayList();
    public static String l;
    public final s3 b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f21299c;
    public final u3 d;
    public final Context e;
    public Map<String, String> g;
    public Long h;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantLock f21298a = new ReentrantLock();
    public final AtomicBoolean f = new AtomicBoolean(false);

    static {
        String str = r3.class.getSimpleName() + "#";
        i = str;
        j = str;
    }

    public r3(Context context) {
        s3 m3Var;
        boolean z;
        this.e = context.getApplicationContext();
        if (w2.b()) {
            m3Var = new w3(new b4());
        } else {
            if ((Build.MANUFACTURER.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("XIAOMI") || Build.BRAND.equalsIgnoreCase("REDMI")) && b4.a()) {
                m3Var = new b4();
            } else if (v3.a()) {
                m3Var = new v3();
            } else if (w2.a().toUpperCase().contains("HUAWEI") || w2.d()) {
                m3Var = new m3();
            } else if ("OnePlus".equalsIgnoreCase(Build.MANUFACTURER)) {
                m3Var = new w3(null);
            } else {
                String str = Build.BRAND;
                if (str == null ? false : str.toLowerCase(Locale.ENGLISH).contains(AssistUtils.BRAND_MZ)) {
                    m3Var = new p3();
                } else if (Build.VERSION.SDK_INT > 28) {
                    if ("samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER)) {
                        m3Var = new z3();
                    } else if (w2.a().toUpperCase().contains("NUBIA")) {
                        m3Var = new q3();
                    } else {
                        String str2 = Build.FINGERPRINT;
                        if (TextUtils.isEmpty(str2)) {
                            String a2 = w2.a("ro.build.version.incremental");
                            z = !TextUtils.isEmpty(a2) && a2.contains("VIBEUI_V2");
                        } else {
                            z = str2.contains("VIBEUI_V2");
                        }
                        if (z) {
                            m3Var = new o3();
                        } else if (w2.a().toUpperCase().contains("ASUS")) {
                            m3Var = new e3();
                        } else {
                            m3Var = new j3(context);
                            if (!m3Var.b(context)) {
                                m3Var = new i3();
                            }
                        }
                    }
                } else {
                    m3Var = null;
                    if (!w2.e()) {
                        m3Var = null;
                        if (m3.d(context)) {
                            m3Var = new m3();
                        }
                    }
                }
            }
        }
        this.b = m3Var;
        if (m3Var != null) {
            this.f21299c = m3Var.b(context);
        } else {
            this.f21299c = false;
        }
        this.d = new u3(context);
    }

    public static /* synthetic */ String a(t3 t3Var) {
        return "Oaid#initOaid fetch=" + t3Var;
    }

    public static /* synthetic */ String a(boolean z, long j2) {
        return "Oaid#getOaid locked=" + z + ", took " + (SystemClock.elapsedRealtime() - j2) + " ms";
    }

    public static void a(IOaidObserver.Oaid oaid, Object[] objArr) {
        if (oaid == null || objArr == null) {
            return;
        }
        int length = objArr.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            ((IOaidObserver) objArr[i3]).onOaidLoaded(oaid);
            i2 = i3 + 1;
        }
    }

    public static void a(IOaidObserver iOaidObserver) {
        synchronized (k) {
            k.add(iOaidObserver);
        }
        String str = l;
        if (str != null) {
            a(new IOaidObserver.Oaid(str), new Object[]{iOaidObserver});
        }
    }

    public static <K, V> void a(Map<K, V> map, K k2, V v) {
        if (k2 == null || v == null) {
            return;
        }
        map.put(k2, v);
    }

    public static void a(JSONObject jSONObject, String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        try {
            jSONObject.put(str, obj);
        } catch (JSONException e) {
            z2.a(e);
        }
    }

    public static /* synthetic */ String b(t3 t3Var) {
        return "Oaid#initOaid oaidModel=" + t3Var;
    }

    public static void b(IOaidObserver iOaidObserver) {
        synchronized (k) {
            k.remove(iOaidObserver);
        }
    }

    public static Object[] c() {
        Object[] array;
        synchronized (k) {
            array = k.size() > 0 ? k.toArray() : null;
        }
        return array;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String d() {
        StringBuilder a2 = a.a("Oaid#getOaid return apiMap=");
        a2.append(this.g);
        return a2.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0063, code lost:
        if (r0 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007b, code lost:
        if (r12 == false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007e, code lost:
        r6.f21298a.unlock();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<java.lang.String, java.lang.String> a(long r7) {
        /*
            r6 = this;
            r0 = r6
            boolean r0 = r0.f21299c
            if (r0 != 0) goto L9
            r0 = 0
            return r0
        L9:
            r0 = r6
            r0.a()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r14 = r0
            r0 = r14
            java.lang.String r1 = "Oaid#getOaid timeoutMills="
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r14
            r1 = r7
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r14
            java.lang.String r0 = r0.toString()
            com.bytedance.bdtracker.z2.a(r0)
            r0 = r6
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.g
            if (r0 != 0) goto L97
            long r0 = android.os.SystemClock.elapsedRealtime()
            r9 = r0
            r0 = 0
            r12 = r0
            r0 = 0
            r11 = r0
            r0 = r6
            java.util.concurrent.locks.ReentrantLock r0 = r0.f21298a     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6e
            r1 = r7
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6e
            boolean r0 = r0.tryLock(r1, r2)     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6e
            r13 = r0
            r0 = r13
            r11 = r0
            r0 = r13
            r12 = r0
            com.bytedance.bdtracker.-$$Lambda$kT3P1g7Vo6F-soZ3Uvo7uke9h3U r0 = new com.bytedance.bdtracker.-$$Lambda$kT3P1g7Vo6F-soZ3Uvo7uke9h3U     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6e
            r1 = r0
            r2 = r13
            r3 = r9
            r1.<init>()     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6e
            com.bytedance.bdtracker.z2.a(r0)     // Catch: java.lang.Throwable -> L69 java.lang.InterruptedException -> L6e
            r0 = r13
            if (r0 == 0) goto L97
            goto L7e
        L69:
            r14 = move-exception
            goto L88
        L6e:
            r14 = move-exception
            r0 = r12
            r11 = r0
            r0 = r14
            com.bytedance.bdtracker.z2.a(r0)     // Catch: java.lang.Throwable -> L69
            r0 = r12
            if (r0 == 0) goto L97
        L7e:
            r0 = r6
            java.util.concurrent.locks.ReentrantLock r0 = r0.f21298a
            r0.unlock()
            goto L97
        L88:
            r0 = r11
            if (r0 == 0) goto L94
            r0 = r6
            java.util.concurrent.locks.ReentrantLock r0 = r0.f21298a
            r0.unlock()
        L94:
            r0 = r14
            throw r0
        L97:
            com.bytedance.bdtracker.-$$Lambda$r3$hO8mO60XIcsXFgMEpg70dU_7t38 r0 = new com.bytedance.bdtracker.-$$Lambda$r3$hO8mO60XIcsXFgMEpg70dU_7t38
            r1 = r0
            r2 = r6
            r1.<init>()
            com.bytedance.bdtracker.z2.a(r0)
            r0 = r6
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.g
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.r3.a(long):java.util.Map");
    }

    public void a() {
        if (this.f.compareAndSet(false, true)) {
            Runnable runnable = new Runnable() { // from class: com.bytedance.bdtracker.-$$Lambda$8phpLYMTc_9Ffs86ac9Y4aHafaU
                @Override // java.lang.Runnable
                public final void run() {
                    r3.this.b();
                }
            };
            String a2 = a.a(new StringBuilder(), j, "-query");
            if (runnable == null) {
                return;
            }
            String str = a2;
            if (TextUtils.isEmpty(a2)) {
                str = "TrackerDr";
            }
            new Thread(new l3(runnable, str), str).start();
        }
    }

    public final void b() {
        String str;
        Boolean bool;
        s3.a a2;
        z2.a("Oaid#initOaid");
        try {
            this.f21298a.lock();
            z2.a("Oaid#initOaid exec");
            final t3 a3 = this.d.a();
            z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$Bno-E6N52Aw6n08T567sS_gUB9A
                @Override // com.bytedance.bdtracker.z2.a
                public final String a() {
                    return r3.a(t3.this);
                }
            });
            if (a3 != null) {
                l = a3.f21312a;
                this.g = a3.a();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Context context = this.e;
            s3 s3Var = this.b;
            if (s3Var == null || (a2 = s3Var.a(context)) == null) {
                str = null;
                bool = null;
            } else {
                String str2 = a2.f21305a;
                Boolean valueOf = Boolean.valueOf(a2.b);
                str = str2;
                bool = valueOf;
                if (a2 instanceof m3.b) {
                    this.h = Long.valueOf(((m3.b) a2).f21262c);
                    str = str2;
                    bool = valueOf;
                }
            }
            Pair pair = new Pair(str, bool);
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            t3 t3Var = null;
            if (pair.first != 0) {
                int i2 = -1;
                String str3 = null;
                if (a3 != null) {
                    str3 = a3.b;
                    i2 = a3.f.intValue() + 1;
                }
                String str4 = str3;
                if (TextUtils.isEmpty(str3)) {
                    str4 = UUID.randomUUID().toString();
                }
                if (i2 <= 0) {
                    i2 = 1;
                }
                t3Var = new t3((String) pair.first, str4, (Boolean) pair.second, Long.valueOf(elapsedRealtime2 - elapsedRealtime), Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i2), this.h);
                this.d.a(t3Var);
            }
            if (t3Var != null) {
                l = t3Var.f21312a;
                this.g = t3Var.a();
            }
            final t3 t3Var2 = t3Var;
            z2.a(new z2.a() { // from class: com.bytedance.bdtracker.-$$Lambda$QeLhJgJ8PwXHEKbZchwxjueY56s
                @Override // com.bytedance.bdtracker.z2.a
                public final String a() {
                    return r3.b(t3.this);
                }
            });
        } finally {
            this.f21298a.unlock();
            a(new IOaidObserver.Oaid(l), c());
        }
    }
}

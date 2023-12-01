package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.al;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.gx;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bv.class */
public class bv {

    /* renamed from: a  reason: collision with root package name */
    private static bv f27962a = new bv();

    /* renamed from: a  reason: collision with other field name */
    private static String f980a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f981a;

    /* renamed from: a  reason: collision with other field name */
    private du.a f982a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f983a = new ArrayList();

    /* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/service/bv$a.class */
    public static abstract class a {
        public void a(du.a aVar) {
        }

        public void a(dv.b bVar) {
        }
    }

    private bv() {
    }

    public static bv a() {
        return f27962a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m9118a() {
        String str;
        synchronized (bv.class) {
            try {
                if (f980a == null) {
                    SharedPreferences sharedPreferences = com.xiaomi.push.r.m9016a().getSharedPreferences("XMPushServiceConfig", 0);
                    String string = sharedPreferences.getString("DeviceUUID", null);
                    f980a = string;
                    if (string == null) {
                        String a2 = com.xiaomi.push.i.a(com.xiaomi.push.r.m9016a(), false);
                        f980a = a2;
                        if (a2 != null) {
                            sharedPreferences.edit().putString("DeviceUUID", f980a).commit();
                        }
                    }
                }
                str = f980a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private void b() {
        if (this.f982a == null) {
            d();
        }
    }

    private void c() {
        if (this.f981a != null) {
            return;
        }
        bw bwVar = new bw(this);
        this.f981a = bwVar;
        gx.a(bwVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            r5 = this;
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L30
            r1 = r0
            android.content.Context r2 = com.xiaomi.push.r.m9016a()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L30
            java.lang.String r3 = "XMCloudCfg"
            java.io.FileInputStream r2 = r2.openFileInput(r3)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L30
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L30
            r6 = r0
            r0 = r6
            r7 = r0
            r0 = r5
            r1 = r6
            com.xiaomi.push.b r1 = com.xiaomi.push.b.a(r1)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L6d
            com.xiaomi.push.du$a r1 = com.xiaomi.push.du.a.b(r1)     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L6d
            r0.f982a = r1     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L6d
            r0 = r6
            r7 = r0
            r0 = r6
            r0.close()     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L6d
            goto L56
        L26:
            r8 = move-exception
            goto L33
        L2a:
            r6 = move-exception
            r0 = 0
            r7 = r0
            goto L6e
        L30:
            r8 = move-exception
            r0 = 0
            r6 = r0
        L33:
            r0 = r6
            r7 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6d
            r1 = r0
            java.lang.String r2 = "load config failure: "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L6d
            r9 = r0
            r0 = r6
            r7 = r0
            r0 = r9
            r1 = r8
            java.lang.String r1 = r1.getMessage()     // Catch: java.lang.Throwable -> L6d
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> L6d
            r0 = r6
            r7 = r0
            r0 = r9
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L6d
            com.xiaomi.channel.commonutils.logger.b.m8344a(r0)     // Catch: java.lang.Throwable -> L6d
        L56:
            r0 = r6
            com.xiaomi.push.x.a(r0)
            r0 = r5
            com.xiaomi.push.du$a r0 = r0.f982a
            if (r0 != 0) goto L6c
            r0 = r5
            com.xiaomi.push.du$a r1 = new com.xiaomi.push.du$a
            r2 = r1
            r2.<init>()
            r0.f982a = r1
        L6c:
            return
        L6d:
            r6 = move-exception
        L6e:
            r0 = r7
            com.xiaomi.push.x.a(r0)
            r0 = r6
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.bv.d():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            if (this.f982a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.r.m9016a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f982a.a(a2);
                a2.m8510a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m8344a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m9121a() {
        b();
        du.a aVar = this.f982a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public du.a m9122a() {
        b();
        return this.f982a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m9123a() {
        synchronized (this) {
            this.f983a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(dv.b bVar) {
        a[] aVarArr;
        if (bVar.m8603d() && bVar.d() > m9121a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f983a.toArray(new a[this.f983a.size()]);
        }
        int length = aVarArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            aVarArr[i2].a(bVar);
            i = i2 + 1;
        }
    }

    public void a(a aVar) {
        synchronized (this) {
            this.f983a.add(aVar);
        }
    }
}

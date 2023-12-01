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
    private static bv f41653a = new bv();

    /* renamed from: a  reason: collision with other field name */
    private static String f1027a;

    /* renamed from: a  reason: collision with other field name */
    private al.b f1028a;

    /* renamed from: a  reason: collision with other field name */
    private du.a f1029a;

    /* renamed from: a  reason: collision with other field name */
    private List<a> f1030a = new ArrayList();

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
        return f41653a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public static String m12168a() {
        String str;
        synchronized (bv.class) {
            try {
                if (f1027a == null) {
                    SharedPreferences sharedPreferences = com.xiaomi.push.r.m12066a().getSharedPreferences("XMPushServiceConfig", 0);
                    String string = sharedPreferences.getString("DeviceUUID", null);
                    f1027a = string;
                    if (string == null) {
                        String a2 = com.xiaomi.push.i.a(com.xiaomi.push.r.m12066a(), false);
                        f1027a = a2;
                        if (a2 != null) {
                            sharedPreferences.edit().putString("DeviceUUID", f1027a).commit();
                        }
                    }
                }
                str = f1027a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    private void b() {
        if (this.f1029a == null) {
            d();
        }
    }

    private void c() {
        if (this.f1028a != null) {
            return;
        }
        bw bwVar = new bw(this);
        this.f1028a = bwVar;
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
            android.content.Context r2 = com.xiaomi.push.r.m12066a()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L30
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
            r0.f1029a = r1     // Catch: java.lang.Exception -> L26 java.lang.Throwable -> L6d
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
            com.xiaomi.channel.commonutils.logger.b.m11394a(r0)     // Catch: java.lang.Throwable -> L6d
        L56:
            r0 = r6
            com.xiaomi.push.x.a(r0)
            r0 = r5
            com.xiaomi.push.du$a r0 = r0.f1029a
            if (r0 != 0) goto L6c
            r0 = r5
            com.xiaomi.push.du$a r1 = new com.xiaomi.push.du$a
            r2 = r1
            r2.<init>()
            r0.f1029a = r1
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
            if (this.f1029a != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(com.xiaomi.push.r.m12066a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.c a2 = com.xiaomi.push.c.a(bufferedOutputStream);
                this.f1029a.a(a2);
                a2.m11560a();
                bufferedOutputStream.close();
            }
        } catch (Exception e) {
            com.xiaomi.channel.commonutils.logger.b.m11394a("save config failure: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public int m12171a() {
        b();
        du.a aVar = this.f1029a;
        if (aVar != null) {
            return aVar.c();
        }
        return 0;
    }

    /* renamed from: a  reason: collision with other method in class */
    public du.a m12172a() {
        b();
        return this.f1029a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a  reason: collision with other method in class */
    public void m12173a() {
        synchronized (this) {
            this.f1030a.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(dv.b bVar) {
        a[] aVarArr;
        if (bVar.m11653d() && bVar.d() > m12171a()) {
            c();
        }
        synchronized (this) {
            aVarArr = (a[]) this.f1030a.toArray(new a[this.f1030a.size()]);
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
            this.f1030a.add(aVar);
        }
    }
}

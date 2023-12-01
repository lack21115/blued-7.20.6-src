package com.tencent.tmsbeacon.qimei;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.tmsbeacon.a.c.f;
import com.tencent.tmsbeacon.base.util.d;
import com.tencent.tmsbeacon.pack.QimeiPackage;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/qimei/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static a f39610a;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private Qimei f39611c;

    private a() {
        d();
    }

    public static a a() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f39610a == null) {
                    f39610a = new a();
                }
                aVar = f39610a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return aVar;
    }

    private void d() {
        synchronized (this) {
            this.f39611c = new Qimei();
            String a2 = e.a(com.tencent.tmsbeacon.a.c.c.d().c());
            if (!TextUtils.isEmpty(a2)) {
                this.b = a2;
            }
            com.tencent.tmsbeacon.base.util.c.a("[qimei] final jceRequest qimeiJson: " + this.b, new Object[0]);
            HashMap<String, String> a3 = e.a(this.b);
            if (a3 != null) {
                this.f39611c.b(a3.get("A3"));
                this.f39611c.a(a3.get("A153"));
                this.f39611c.a(a3);
                com.tencent.tmsbeacon.base.util.c.a("[qimei] showQimei: " + this.f39611c.toString(), new Object[0]);
            }
        }
    }

    public void a(Qimei qimei) {
        synchronized (this) {
            this.f39611c = qimei;
        }
    }

    public Qimei b() {
        return this.f39611c;
    }

    public QimeiPackage c() {
        f e = f.e();
        QimeiPackage qimeiPackage = new QimeiPackage();
        qimeiPackage.androidId = e.a();
        qimeiPackage.imei = e.b();
        qimeiPackage.imsi = e.d();
        qimeiPackage.mac = e.f();
        String str = this.b;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        qimeiPackage.qimei = str2;
        qimeiPackage.model = e.h();
        qimeiPackage.brand = Build.BRAND;
        com.tencent.tmsbeacon.a.c.e l = com.tencent.tmsbeacon.a.c.e.l();
        qimeiPackage.osVersion = l.s();
        qimeiPackage.broot = d.d();
        qimeiPackage.qq = "";
        qimeiPackage.cid = l.p();
        return qimeiPackage;
    }
}

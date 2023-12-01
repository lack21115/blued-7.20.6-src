package com.tencent.beacon.e;

import android.content.Context;
import android.util.Base64;
import java.util.Date;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/e/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static volatile h f21332a;
    private d d;
    private final String b = "sid";
    private String e = "";
    private boolean f = true;
    private int g = 8081;
    private String h = "";
    private String i = "";

    /* renamed from: c  reason: collision with root package name */
    private final Context f21333c = com.tencent.beacon.a.c.c.d().c();

    private h() {
        com.tencent.beacon.a.b.a.a().a(new f(this));
    }

    public static h b() {
        if (f21332a == null) {
            synchronized (h.class) {
                try {
                    if (f21332a == null) {
                        f21332a = new h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21332a;
    }

    public String a() {
        String str;
        synchronized (this) {
            str = this.i;
        }
        return str;
    }

    public void a(Context context) {
        synchronized (this) {
            com.tencent.beacon.a.d.a a2 = com.tencent.beacon.a.d.a.a();
            String string = a2.getString("sid_value", "");
            if (a2.getLong("sid_mt", 0L) > new Date().getTime() / 1000) {
                a(string);
            }
            a(context, com.tencent.beacon.base.util.b.b());
        }
    }

    void a(Context context, String str) {
        synchronized (this) {
            this.i = str;
            byte[] a2 = com.tencent.beacon.base.net.b.c.a(context, str);
            if (a2 != null) {
                this.h = Base64.encodeToString(a2, 2);
            }
        }
    }

    public void a(d dVar) {
        this.d = dVar;
    }

    public void a(String str) {
        synchronized (this) {
            this.e = str;
        }
    }

    public void a(String str, String str2) {
        synchronized (this) {
            com.tencent.beacon.base.util.c.a("[net] -> update local sid|time[%s|%s].", str, str2);
            this.e = str;
            com.tencent.beacon.a.b.a.a().a(new g(this, str2, str));
        }
    }

    public String c() {
        String str;
        synchronized (this) {
            str = this.e;
        }
        return str;
    }

    public String d() {
        String str;
        synchronized (this) {
            str = this.h;
        }
        return str;
    }
}

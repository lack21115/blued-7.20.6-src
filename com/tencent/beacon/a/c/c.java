package com.tencent.beacon.a.c;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.module.ModuleName;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f21248a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private byte f21249c;
    private String d;
    private String f;
    private long g;
    private String e = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private String l = "";
    private boolean m = true;

    public c() {
        this.f21249c = (byte) -1;
        this.d = "";
        this.f = "";
        this.f21249c = (byte) 1;
        this.d = "beacon";
        this.f = "unknown";
    }

    public static c d() {
        if (f21248a == null) {
            synchronized (c.class) {
                try {
                    if (f21248a == null) {
                        f21248a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f21248a;
    }

    public BeaconModule a(ModuleName moduleName) {
        return BeaconModule.f21386a.get(moduleName);
    }

    public String a() {
        return this.i;
    }

    public void a(long j) {
        synchronized (this) {
            this.g = j;
        }
    }

    public void a(Context context) {
        synchronized (this) {
            if (this.b == null) {
                Context applicationContext = context.getApplicationContext();
                this.b = applicationContext;
                if (applicationContext == null) {
                    this.b = context;
                }
            }
        }
    }

    public void a(String str) {
        this.i = str;
    }

    public void a(boolean z) {
        this.m = z;
    }

    public String b() {
        String str;
        synchronized (this) {
            str = this.f;
        }
        return str;
    }

    public void b(String str) {
        this.f = str;
    }

    public Context c() {
        Context context;
        synchronized (this) {
            context = this.b;
        }
        return context;
    }

    public void c(String str) {
        this.l = str;
    }

    public void d(String str) {
        this.h = str;
    }

    public String e() {
        return this.l;
    }

    public void e(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.k = str;
    }

    public String f() {
        return this.h;
    }

    public String g() {
        return this.k;
    }

    public byte h() {
        byte b;
        synchronized (this) {
            b = this.f21249c;
        }
        return b;
    }

    public String i() {
        String str;
        synchronized (this) {
            str = this.d;
        }
        return str;
    }

    public String j() {
        return "4.2.80.6";
    }

    public long k() {
        long j;
        synchronized (this) {
            j = this.g;
        }
        return j;
    }

    public String l() {
        return this.j;
    }

    public boolean m() {
        return this.m;
    }
}

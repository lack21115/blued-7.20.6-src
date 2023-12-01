package com.tencent.tmsbeacon.a.c;

import android.content.Context;
import com.tencent.tmsbeacon.module.BeaconModule;
import com.tencent.tmsbeacon.module.ModuleName;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/c/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static volatile c f25783a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private byte f25784c;
    private String d;
    private String f;
    private long g;
    private String e = "";
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";
    private boolean l = true;

    public c() {
        this.f25784c = (byte) -1;
        this.d = "";
        this.f = "";
        this.f25784c = (byte) 1;
        this.d = "tmsbeacon";
        this.f = "unknown";
    }

    public static c d() {
        if (f25783a == null) {
            synchronized (c.class) {
                try {
                    if (f25783a == null) {
                        f25783a = new c();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25783a;
    }

    public BeaconModule a(ModuleName moduleName) {
        return BeaconModule.f25901a.get(moduleName);
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
        this.l = z;
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
        this.h = str;
    }

    public String e() {
        return this.k;
    }

    public String f() {
        return this.h;
    }

    public byte g() {
        byte b;
        synchronized (this) {
            b = this.f25784c;
        }
        return b;
    }

    public String h() {
        String str;
        synchronized (this) {
            str = this.d;
        }
        return str;
    }

    public String i() {
        return "4.1.26.5-hf";
    }

    public long j() {
        long j;
        synchronized (this) {
            j = this.g;
        }
        return j;
    }

    public String k() {
        return this.j;
    }
}

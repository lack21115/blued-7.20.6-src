package com.tencent.tmsbeacon.a.c;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/a/c/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f25788a;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f25789c = "";
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "unset";
    private String h = "";
    private String i = "";
    private String j = "";
    private String k = "";

    private f() {
    }

    public static f e() {
        if (f25788a == null) {
            synchronized (f.class) {
                try {
                    if (f25788a == null) {
                        f25788a = new f();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f25788a;
    }

    public String a() {
        return this.b;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.f25789c;
    }

    public void b(String str) {
        this.f25789c = str;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public void e(String str) {
        this.h = str;
    }

    public String f() {
        return this.h;
    }

    public void f(String str) {
        this.f = str;
    }

    public String g() {
        return this.f;
    }

    public void g(String str) {
        this.g = str;
    }

    public String h() {
        return this.g;
    }

    public void h(String str) {
        this.k = str;
    }

    public String i() {
        return this.k;
    }

    public void i(String str) {
        this.i = str;
    }

    public String j() {
        return this.i;
    }

    public void j(String str) {
        this.j = str;
    }

    public String k() {
        return this.j;
    }
}

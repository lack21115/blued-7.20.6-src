package com.zx.a.I8b7;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/z1.class */
public class z1 {

    /* renamed from: a  reason: collision with root package name */
    public final k0 f42233a;

    /* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/z1$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final z1 f42234a = new z1();
    }

    public z1() {
        k0 k0Var = new k0(t2.f42201a);
        this.f42233a = k0Var;
        k0Var.c("zx_tag");
        k0Var.b("zx.fileLog");
        k0Var.a(false);
        k0Var.d("zx");
        k0Var.a(1);
    }

    public static void a(String str) {
        try {
            a.f42234a.f42233a.f42142a.a(2, null, str, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void a(String str, Throwable th) {
        try {
            a.f42234a.f42233a.f42142a.a(5, null, str, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void a(Throwable th) {
        try {
            a.f42234a.f42233a.f42142a.a(5, null, null, th);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void b(String str) {
        try {
            a.f42234a.f42233a.f42142a.a(5, null, str, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

package com.kuaishou.weapon.p0;

import android.os.Build;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cp.class */
public class cp {

    /* renamed from: a  reason: collision with root package name */
    static cp f23791a;
    static cp b;

    /* renamed from: c  reason: collision with root package name */
    static cp f23792c;
    private long d;
    private a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/cp$a.class */
    public enum a {
        DWORD(4),
        QWORD(8);
        

        /* renamed from: c  reason: collision with root package name */
        int f23794c;

        a(int i) {
            this.f23794c = i;
        }
    }

    static {
        c();
    }

    private static void c() {
        f23791a = new cp();
        b = new cp();
        f23792c = new cp();
        b.a(a.DWORD);
        int i = Build.VERSION.SDK_INT;
        if (cq.a()) {
            f23791a.a(a.QWORD);
            f23792c.a(a.QWORD);
            switch (i) {
                case 19:
                    f23791a.a(32L);
                    b.a(28L);
                    return;
                case 20:
                default:
                    throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
                case 21:
                    f23791a.a(40L);
                    f23791a.a(a.QWORD);
                    f23792c.a(32L);
                    f23792c.a(a.QWORD);
                    b.a(56L);
                    return;
                case 22:
                    f23791a.a(52L);
                    f23792c.a(44L);
                    b.a(20L);
                    return;
                case 23:
                    f23791a.a(48L);
                    f23792c.a(40L);
                    b.a(12L);
                    return;
                case 24:
                case 25:
                    f23791a.a(48L);
                    f23792c.a(40L);
                    b.a(4L);
                    return;
                case 26:
                case 27:
                    f23791a.a(40L);
                    f23792c.a(32L);
                    b.a(4L);
                    return;
                case 28:
                case 29:
                    f23791a.a(32L);
                    f23792c.a(24L);
                    b.a(4L);
                    return;
            }
        }
        f23791a.a(a.DWORD);
        f23792c.a(a.DWORD);
        switch (i) {
            case 19:
                f23791a.a(32L);
                b.a(28L);
                return;
            case 20:
            default:
                throw new RuntimeException("API LEVEL: " + i + " is not supported now : (");
            case 21:
                f23791a.a(40L);
                f23791a.a(a.QWORD);
                f23792c.a(32L);
                f23792c.a(a.QWORD);
                b.a(56L);
                return;
            case 22:
                f23791a.a(44L);
                f23792c.a(40L);
                b.a(20L);
                return;
            case 23:
                f23791a.a(36L);
                f23792c.a(32L);
                b.a(12L);
                return;
            case 24:
            case 25:
                f23791a.a(32L);
                f23792c.a(28L);
                b.a(4L);
                return;
            case 26:
            case 27:
                f23791a.a(28L);
                f23792c.a(24L);
                b.a(4L);
                return;
            case 28:
            case 29:
                f23791a.a(24L);
                f23792c.a(20L);
                b.a(4L);
                return;
        }
    }

    public long a() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public a b() {
        return this.e;
    }
}

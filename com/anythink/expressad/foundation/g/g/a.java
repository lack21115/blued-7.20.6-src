package com.anythink.expressad.foundation.g.g;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/a.class */
public abstract class a implements Runnable {
    public static long b;

    /* renamed from: c  reason: collision with root package name */
    public EnumC0147a f7930c = EnumC0147a.READY;
    public b d;

    /* renamed from: com.anythink.expressad.foundation.g.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/a$a.class */
    public enum EnumC0147a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/a$b.class */
    public interface b {
        void a(EnumC0147a enumC0147a);
    }

    public a() {
        b++;
    }

    private void a(EnumC0147a enumC0147a) {
        this.f7930c = enumC0147a;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(enumC0147a);
        }
    }

    private void a(b bVar) {
        this.d = bVar;
    }

    private EnumC0147a d() {
        return this.f7930c;
    }

    public static long e() {
        return b;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final void f() {
        if (this.f7930c != EnumC0147a.CANCEL) {
            a(EnumC0147a.CANCEL);
        }
    }

    public final void g() {
        if (this.f7930c == EnumC0147a.PAUSE || this.f7930c == EnumC0147a.CANCEL || this.f7930c == EnumC0147a.FINISH) {
            return;
        }
        a(EnumC0147a.RUNNING);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f7930c == EnumC0147a.READY) {
                a(EnumC0147a.RUNNING);
                a();
                a(EnumC0147a.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

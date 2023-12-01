package com.anythink.expressad.foundation.g.g;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/a.class */
public abstract class a implements Runnable {
    public static long b;

    /* renamed from: c  reason: collision with root package name */
    public EnumC0076a f5090c = EnumC0076a.READY;
    public b d;

    /* renamed from: com.anythink.expressad.foundation.g.g.a$a  reason: collision with other inner class name */
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/a$a.class */
    public enum EnumC0076a {
        READY,
        RUNNING,
        PAUSE,
        CANCEL,
        FINISH
    }

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/g/a$b.class */
    public interface b {
        void a(EnumC0076a enumC0076a);
    }

    public a() {
        b++;
    }

    private void a(EnumC0076a enumC0076a) {
        this.f5090c = enumC0076a;
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(enumC0076a);
        }
    }

    private void a(b bVar) {
        this.d = bVar;
    }

    private EnumC0076a d() {
        return this.f5090c;
    }

    public static long e() {
        return b;
    }

    public abstract void a();

    public abstract void b();

    public abstract void c();

    public final void f() {
        if (this.f5090c != EnumC0076a.CANCEL) {
            a(EnumC0076a.CANCEL);
        }
    }

    public final void g() {
        if (this.f5090c == EnumC0076a.PAUSE || this.f5090c == EnumC0076a.CANCEL || this.f5090c == EnumC0076a.FINISH) {
            return;
        }
        a(EnumC0076a.RUNNING);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (this.f5090c == EnumC0076a.READY) {
                a(EnumC0076a.RUNNING);
                a();
                a(EnumC0076a.FINISH);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}

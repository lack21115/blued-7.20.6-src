package com.igexin.c.a.b.a.a;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/a.class */
public abstract class a extends com.igexin.c.a.b.f {
    protected volatile boolean f;
    protected volatile int g;
    protected String h;
    protected volatile boolean i;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* renamed from: com.igexin.c.a.b.a.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/a/a/a$a.class */
    public static final class EnumC0276a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f9612a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f9613c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private EnumC0276a(String str, int i) {
        }

        private static int[] a() {
            return (int[]) d.clone();
        }
    }

    public a(int i, com.igexin.c.a.b.d dVar) {
        super(i, null, dVar);
        this.g = EnumC0276a.f9612a;
        this.i = true;
    }

    public abstract void c_();

    @Override // com.igexin.c.a.d.f, com.igexin.c.a.d.a.f
    public final void d() {
        super.d();
        this.o = true;
    }

    @Override // com.igexin.c.a.d.f
    public final void e() {
        Thread thread = this.K;
        if (!thread.isAlive() || thread.isInterrupted()) {
            return;
        }
        thread.interrupt();
    }

    @Override // com.igexin.c.a.d.f
    public final void f() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g() {
        return this.g == EnumC0276a.f9613c;
    }
}

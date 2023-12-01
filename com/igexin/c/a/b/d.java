package com.igexin.c.a.b;

/* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/d.class */
public abstract class d {

    /* renamed from: c  reason: collision with root package name */
    protected String f9634c;
    protected d d;
    protected d e;
    protected boolean f;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: source-7994992-dex2jar.jar:com/igexin/c/a/b/d$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final int f9635a = 1;
        public static final int b = 2;

        /* renamed from: c  reason: collision with root package name */
        public static final int f9636c = 3;
        private static final /* synthetic */ int[] d = {1, 2, 3};

        private a(String str, int i) {
        }

        private static int[] a() {
            return (int[]) d.clone();
        }
    }

    private d(String str) {
        this.f9634c = str;
    }

    public d(String str, byte b) {
        this.f9634c = str;
        this.f = true;
    }

    private static int a() {
        return a.f9636c;
    }

    private static void a(d dVar, String str, String str2, d dVar2) {
        if (str2 == null) {
            throw new NullPointerException("filter name can't be NULL");
        }
        if (dVar != null) {
            d dVar3 = dVar.e;
            d dVar4 = dVar3;
            if (dVar.f9634c.equals(str)) {
                dVar2.d = dVar;
                dVar.e = dVar2;
                dVar2.e = dVar3;
                if (dVar3 != null) {
                    dVar3.d = dVar2;
                }
            } else {
                while (dVar4.e != null && !dVar4.f9634c.equals(str)) {
                    dVar4 = dVar4.e;
                }
                d dVar5 = dVar4.e;
                if (dVar5 == null) {
                    dVar4.e = dVar2;
                    dVar2.d = dVar4;
                } else {
                    dVar2.e = dVar5;
                    dVar4.e.d = dVar2;
                    dVar2.d = dVar4;
                    dVar4.e = dVar2;
                }
            }
        }
        dVar2.f9634c = str2;
    }

    private static void b(d dVar, String str, String str2, d dVar2) {
        if (str2 == null) {
            throw new NullPointerException("filter name can't be NULL");
        }
        if (dVar != null) {
            d dVar3 = dVar.d;
            d dVar4 = dVar3;
            if (dVar.f9634c.equals(str)) {
                dVar.d = dVar2;
                dVar2.e = dVar;
                dVar2.d = dVar3;
                dVar3.e = dVar2;
            } else {
                while (dVar4.d != null && !dVar4.f9634c.equals(str)) {
                    dVar4 = dVar4.d;
                }
                d dVar5 = dVar4.d;
                if (dVar5 == null) {
                    dVar4.d = dVar2;
                    dVar2.e = dVar4;
                } else {
                    dVar5.e = dVar2;
                    dVar2.d = dVar5;
                    dVar2.e = dVar4;
                    dVar4.d = dVar2;
                }
            }
        }
        dVar2.f9634c = str2;
    }

    private static int c() {
        return a.f9636c;
    }

    private String d() {
        return this.f9634c;
    }

    public final Object a(f fVar, Object obj) throws Exception {
        if (obj != null) {
            d dVar = this.d;
            Object obj2 = obj;
            if (dVar != null) {
                obj2 = dVar.a(fVar, obj);
            }
            return a(obj2);
        }
        throw new NullPointerException("Nothing to encode!");
    }

    public abstract Object a(Object obj) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(d dVar) {
        if (dVar == null) {
            return;
        }
        d dVar2 = dVar.d;
        dVar.d = this;
        this.e = dVar;
        this.d = dVar2;
    }

    public final com.igexin.c.a.d.a.e b(f fVar, Object obj) throws Exception {
        Object b = b(obj);
        d dVar = this.d;
        com.igexin.c.a.d.a.e eVar = b;
        if (dVar != null) {
            eVar = b;
            if (b != null) {
                eVar = dVar.b(fVar, b);
            }
        }
        return (com.igexin.c.a.d.a.e) eVar;
    }

    public abstract Object b(Object obj) throws Exception;

    public final void b() {
        if (this.f) {
            return;
        }
        while (true) {
            d dVar = this.d;
            if (dVar == null) {
                return;
            }
            d dVar2 = dVar.d;
            dVar.d = null;
            this.d = dVar2;
        }
    }
}

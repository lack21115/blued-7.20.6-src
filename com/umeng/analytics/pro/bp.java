package com.umeng.analytics.pro;

/* loaded from: source-8829756-dex2jar.jar:com/umeng/analytics/pro/bp.class */
public class bp extends bw {

    /* renamed from: a  reason: collision with root package name */
    public static final int f26977a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f26978c = 2;
    public static final int d = 3;
    public static final int e = 4;
    public static final int f = 5;
    public static final int g = 6;
    public static final int h = 7;
    private static final cu j = new cu("TApplicationException");
    private static final ck k = new ck("message", (byte) 11, 1);
    private static final ck l = new ck("type", (byte) 8, 2);
    private static final long m = 1;
    protected int i;

    public bp() {
        this.i = 0;
    }

    public bp(int i) {
        this.i = 0;
        this.i = i;
    }

    public bp(int i, String str) {
        super(str);
        this.i = 0;
        this.i = i;
    }

    public bp(String str) {
        super(str);
        this.i = 0;
    }

    public static bp a(cp cpVar) throws bw {
        cpVar.j();
        String str = null;
        int i = 0;
        while (true) {
            ck l2 = cpVar.l();
            if (l2.b == 0) {
                cpVar.k();
                return new bp(i, str);
            }
            short s = l2.f27009c;
            if (s != 1) {
                if (s != 2) {
                    cs.a(cpVar, l2.b);
                } else if (l2.b == 8) {
                    i = cpVar.w();
                } else {
                    cs.a(cpVar, l2.b);
                }
            } else if (l2.b == 11) {
                str = cpVar.z();
            } else {
                cs.a(cpVar, l2.b);
            }
            cpVar.m();
        }
    }

    public int a() {
        return this.i;
    }

    public void b(cp cpVar) throws bw {
        cpVar.a(j);
        if (getMessage() != null) {
            cpVar.a(k);
            cpVar.a(getMessage());
            cpVar.c();
        }
        cpVar.a(l);
        cpVar.a(this.i);
        cpVar.c();
        cpVar.d();
        cpVar.b();
    }
}

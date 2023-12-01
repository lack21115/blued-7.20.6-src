package com.tencent.mapsdk.internal;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/a4.class */
public enum a4 {
    None("", 0),
    Gradient("heat", 2),
    Aggregation("honey", 3),
    ArcLine("arcline", 4),
    GLModel("model", 5),
    Trail("trail", 6),
    Scatter("scatter", 7);
    
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f23596c;

    a4(String str, int i) {
        this.f23596c = str;
        this.b = i;
    }

    public static a4 a(String str) {
        a4[] values = values();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 7) {
                return None;
            }
            a4 a4Var = values[i2];
            if (a4Var.b(str)) {
                return a4Var;
            }
            i = i2 + 1;
        }
    }

    public static a4 b(int i) {
        a4[] values = values();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 7) {
                return None;
            }
            a4 a4Var = values[i3];
            if (a4Var.a(i)) {
                return a4Var;
            }
            i2 = i3 + 1;
        }
    }

    public String a() {
        return this.f23596c;
    }

    public boolean a(int i) {
        return this.b == i;
    }

    public boolean b(String str) {
        return this.f23596c.equals(str);
    }
}

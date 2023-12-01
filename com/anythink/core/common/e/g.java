package com.anythink.core.common.e;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/g.class */
public final class g extends aa {
    public static final int a = 1;
    public static final int b = 2;
    private String R;
    private String S;
    private int am = 1;

    public final String a() {
        return this.S;
    }

    public final void a(int i) {
        this.am = i;
    }

    public final void a(String str) {
        this.S = str;
    }

    public final String b() {
        return this.R;
    }

    public final void b(String str) {
        this.R = str;
    }

    public final int c() {
        return this.am;
    }

    @Override // com.anythink.core.common.e.i
    public final int d() {
        return this.am == 1 ? 2 : 4;
    }
}

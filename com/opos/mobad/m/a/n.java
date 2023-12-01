package com.opos.mobad.m.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/n.class */
public enum n implements com.heytap.nearx.a.a.i {
    HORIZONTAL(0),
    VERTICAL(1);
    

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<n> f26354c = com.heytap.nearx.a.a.e.a(n.class);
    private final int d;

    n(int i) {
        this.d = i;
    }

    public static n fromValue(int i) {
        if (i != 0) {
            if (i != 1) {
                return null;
            }
            return VERTICAL;
        }
        return HORIZONTAL;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.d;
    }
}

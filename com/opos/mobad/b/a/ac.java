package com.opos.mobad.b.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ac.class */
public enum ac implements com.heytap.nearx.a.a.i {
    MODE_ONE(1),
    MODE_TWO(2);
    

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<ac> f12007c = com.heytap.nearx.a.a.e.a(ac.class);
    private final int d;

    ac(int i) {
        this.d = i;
    }

    public static ac fromValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return MODE_TWO;
        }
        return MODE_ONE;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.d;
    }
}

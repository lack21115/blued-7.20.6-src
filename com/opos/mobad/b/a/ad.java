package com.opos.mobad.b.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/ad.class */
public enum ad implements com.heytap.nearx.a.a.i {
    UNKNOWN(0),
    SPLASH(1),
    HOT_SPLASH(2);
    
    public static final com.heytap.nearx.a.a.e<ad> d = com.heytap.nearx.a.a.e.a(ad.class);
    private final int e;

    ad(int i) {
        this.e = i;
    }

    public static ad fromValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return HOT_SPLASH;
            }
            return SPLASH;
        }
        return UNKNOWN;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.e;
    }
}

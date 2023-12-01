package com.opos.mobad.m.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/w.class */
public enum w implements com.heytap.nearx.a.a.i {
    UNKNOWN_STATUS(0),
    VIP(1),
    NORMAL(2);
    
    public static final com.heytap.nearx.a.a.e<w> d = com.heytap.nearx.a.a.e.a(w.class);
    private final int e;

    w(int i) {
        this.e = i;
    }

    public static w fromValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return null;
                }
                return NORMAL;
            }
            return VIP;
        }
        return UNKNOWN_STATUS;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.e;
    }
}

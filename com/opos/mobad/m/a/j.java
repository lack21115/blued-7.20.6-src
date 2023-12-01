package com.opos.mobad.m.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/j.class */
public enum j implements com.heytap.nearx.a.a.i {
    UNKNOWN_MODE(0),
    PERCENTAGE_MODE(1),
    RANKER_MODE(2),
    BIDDING_MODE(3);
    
    public static final com.heytap.nearx.a.a.e<j> e = com.heytap.nearx.a.a.e.a(j.class);
    private final int f;

    j(int i) {
        this.f = i;
    }

    public static j fromValue(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return BIDDING_MODE;
                }
                return RANKER_MODE;
            }
            return PERCENTAGE_MODE;
        }
        return UNKNOWN_MODE;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.f;
    }
}

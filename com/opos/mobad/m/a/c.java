package com.opos.mobad.m.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/m/a/c.class */
public enum c implements com.heytap.nearx.a.a.i {
    UNKNOWN(0),
    UNION(1),
    TT(2),
    GDT(3),
    BD(4),
    MIX(5),
    GG(6),
    FB(7),
    JD(8);
    
    public static final com.heytap.nearx.a.a.e<c> j = com.heytap.nearx.a.a.e.a(c.class);
    private final int k;

    c(int i) {
        this.k = i;
    }

    public static c fromValue(int i) {
        switch (i) {
            case 0:
                return UNKNOWN;
            case 1:
                return UNION;
            case 2:
                return TT;
            case 3:
                return GDT;
            case 4:
                return BD;
            case 5:
                return MIX;
            case 6:
                return GG;
            case 7:
                return FB;
            case 8:
                return JD;
            default:
                return null;
        }
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.k;
    }
}

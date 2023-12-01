package com.opos.mobad.b.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/b/a/s.class */
public enum s implements com.heytap.nearx.a.a.i {
    TYPE_16_8(1),
    TYPE_16_9(2);
    

    /* renamed from: c  reason: collision with root package name */
    public static final com.heytap.nearx.a.a.e<s> f25761c = com.heytap.nearx.a.a.e.a(s.class);
    private final int d;

    s(int i) {
        this.d = i;
    }

    public static s fromValue(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return TYPE_16_9;
        }
        return TYPE_16_8;
    }

    @Override // com.heytap.nearx.a.a.i
    public int a() {
        return this.d;
    }
}

package com.anythink.core.common.e;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/d.class */
public final class d {
    private String a;
    private String b;
    private int c;

    public d(String str, String str2, int i) {
        this.a = str;
        this.b = str2;
        this.c = i;
    }

    private String b() {
        return this.a;
    }

    private int c() {
        return this.c;
    }

    public final String a() {
        return this.b;
    }

    public final boolean a(ai aiVar) {
        if (aiVar != null) {
            int i = aiVar.a;
            return i != 2 ? i == 3 && aiVar.c() == this.c : aiVar.t().equals(this.a);
        }
        return false;
    }
}

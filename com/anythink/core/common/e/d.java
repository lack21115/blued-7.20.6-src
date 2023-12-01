package com.anythink.core.common.e;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/e/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private String f6653a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f6654c;

    public d(String str, String str2, int i) {
        this.f6653a = str;
        this.b = str2;
        this.f6654c = i;
    }

    private String b() {
        return this.f6653a;
    }

    private int c() {
        return this.f6654c;
    }

    public final String a() {
        return this.b;
    }

    public final boolean a(ai aiVar) {
        if (aiVar != null) {
            int i = aiVar.f6634a;
            return i != 2 ? i == 3 && aiVar.c() == this.f6654c : aiVar.t().equals(this.f6653a);
        }
        return false;
    }
}

package com.anythink.basead.c;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/c/e.class */
public class e {
    protected String a;
    protected String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public e(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final String a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return "code[ " + this.a + " ],desc[ " + this.b + " ]";
    }
}

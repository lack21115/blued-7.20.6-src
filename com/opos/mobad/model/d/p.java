package com.opos.mobad.model.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/p.class */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f26442a = new StringBuilder();

    public p a(String str, int i) {
        this.f26442a.append(str);
        this.f26442a.append(":");
        this.f26442a.append(i);
        this.f26442a.append(";");
        return this;
    }

    public p a(String str, String str2) {
        this.f26442a.append(str);
        this.f26442a.append(":");
        this.f26442a.append(str2);
        this.f26442a.append(";");
        return this;
    }

    public String a() {
        return this.f26442a.toString();
    }
}

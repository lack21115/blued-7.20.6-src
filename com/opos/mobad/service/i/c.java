package com.opos.mobad.service.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/i/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f27381a = new StringBuilder();

    public int a() {
        return this.f27381a.length();
    }

    public c a(String str, String str2) {
        if (this.f27381a.length() > 0) {
            this.f27381a.append(";");
        }
        this.f27381a.append(str);
        this.f27381a.append(":");
        this.f27381a.append(str2);
        return this;
    }

    public String b() {
        return this.f27381a.toString();
    }
}

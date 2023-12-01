package com.opos.mobad.service.i;

import com.opos.cmn.i.n;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/service/i/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private String f13692a;
    private StringBuilder b = new StringBuilder();

    public a(String str) {
        this.f13692a = str;
    }

    public a a(float f) {
        if (this.b.length() > 0) {
            this.b.append(this.f13692a);
        }
        this.b.append(f);
        return this;
    }

    public a a(int i) {
        if (this.b.length() > 0) {
            this.b.append(this.f13692a);
        }
        this.b.append(i);
        return this;
    }

    public a a(a aVar) {
        if (this.b.length() > 0) {
            this.b.append(this.f13692a);
        }
        this.b.append((CharSequence) aVar.b);
        return this;
    }

    public a a(String str) {
        if (this.b.length() > 0) {
            this.b.append(this.f13692a);
        }
        this.b.append(n.a(str));
        return this;
    }

    public String toString() {
        return this.b.toString();
    }
}

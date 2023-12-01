package com.anythink.expressad.foundation.g.f.c;

import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/c/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f5027a;
    private final String b;

    public c(String str, String str2) {
        this.f5027a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f5027a;
    }

    public final String b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return TextUtils.equals(this.f5027a, cVar.f5027a) && TextUtils.equals(this.b, cVar.b);
    }

    public final int hashCode() {
        return (this.f5027a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f5027a + ",value=" + this.b + "]";
    }
}

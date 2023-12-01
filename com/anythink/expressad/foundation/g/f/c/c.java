package com.anythink.expressad.foundation.g.f.c;

import android.text.TextUtils;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/c/c.class */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final String f7867a;
    private final String b;

    public c(String str, String str2) {
        this.f7867a = str;
        this.b = str2;
    }

    public final String a() {
        return this.f7867a;
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
        return TextUtils.equals(this.f7867a, cVar.f7867a) && TextUtils.equals(this.b, cVar.b);
    }

    public final int hashCode() {
        return (this.f7867a.hashCode() * 31) + this.b.hashCode();
    }

    public final String toString() {
        return "Header[name=" + this.f7867a + ",value=" + this.b + "]";
    }
}

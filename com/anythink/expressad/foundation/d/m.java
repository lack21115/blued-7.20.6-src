package com.anythink.expressad.foundation.d;

import java.io.Serializable;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/m.class */
public final class m implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f4955a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f4956c;

    private m(String str, String str2, int i) {
        this.b = str;
        this.f4955a = str2;
        this.f4956c = i;
    }

    private String a() {
        return this.f4955a;
    }

    private void a(String str) {
        this.f4955a = str;
    }

    private String b() {
        return this.b;
    }

    private void b(String str) {
        this.b = str;
    }
}

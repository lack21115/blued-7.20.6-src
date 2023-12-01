package com.anythink.expressad.foundation.d;

import java.io.Serializable;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/d/m.class */
public final class m implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    private String f7795a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f7796c;

    private m(String str, String str2, int i) {
        this.b = str;
        this.f7795a = str2;
        this.f7796c = i;
    }

    private String a() {
        return this.f7795a;
    }

    private void a(String str) {
        this.f7795a = str;
    }

    private String b() {
        return this.b;
    }

    private void b(String str) {
        this.b = str;
    }
}

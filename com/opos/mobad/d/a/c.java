package com.opos.mobad.d.a;

import android.content.Intent;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/c.class */
public interface c {

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f12265a;
        public final String b;

        /* renamed from: c  reason: collision with root package name */
        public final int f12266c;
        public final int d;
        public final Intent e;
        public final Intent f;
        public final Intent g;

        public a(String str, String str2, int i, int i2, Intent intent, Intent intent2, Intent intent3) {
            this.f12265a = str;
            this.b = str2;
            this.f12266c = i;
            this.d = i2;
            this.e = intent;
            this.f = intent2;
            this.g = intent3;
        }
    }

    void a();

    void a(int i);

    void a(int i, a aVar);
}

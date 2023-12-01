package com.opos.mobad.model.d;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/i.class */
public class i extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f26433a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f26434c = SystemClock.elapsedRealtime();
    private boolean d;

    public i(String str, String str2, boolean z) {
        this.b = str;
        this.f26433a = str2;
        this.d = z;
    }

    public void a(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f26433a, "6", g(), SystemClock.elapsedRealtime() - this.f26434c, f(), this.d);
    }

    public void a(Context context, int i) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f26433a, i, g(), SystemClock.elapsedRealtime() - this.f26434c, f(), this.d);
    }

    public void b(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f26433a, "1", g(), SystemClock.elapsedRealtime() - this.f26434c, f(), this.d);
    }
}

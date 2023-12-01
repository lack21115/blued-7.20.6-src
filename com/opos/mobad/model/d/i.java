package com.opos.mobad.model.d;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/i.class */
public class i extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f12745a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f12746c = SystemClock.elapsedRealtime();
    private boolean d;

    public i(String str, String str2, boolean z) {
        this.b = str;
        this.f12745a = str2;
        this.d = z;
    }

    public void a(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f12745a, "6", g(), SystemClock.elapsedRealtime() - this.f12746c, f(), this.d);
    }

    public void a(Context context, int i) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f12745a, i, g(), SystemClock.elapsedRealtime() - this.f12746c, f(), this.d);
    }

    public void b(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f12745a, "1", g(), SystemClock.elapsedRealtime() - this.f12746c, f(), this.d);
    }
}

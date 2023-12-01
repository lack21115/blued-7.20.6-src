package com.opos.mobad.model.d;

import android.content.Context;
import android.os.SystemClock;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/l.class */
public class l extends f {

    /* renamed from: a  reason: collision with root package name */
    private String f26440a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f26441c = SystemClock.elapsedRealtime();

    public l(String str, String str2) {
        this.b = str;
        this.f26440a = str2;
    }

    public void a(Context context, int i, String str, boolean z, String str2) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, this.f26440a, i, g(), SystemClock.elapsedRealtime() - this.f26441c, z, f(), str2);
    }

    public void a(Context context, String str, boolean z, String str2, int i) {
        com.opos.mobad.cmn.a.b.d.a(context, this.b, str, this.f26440a, g(), SystemClock.elapsedRealtime() - this.f26441c, z, f(), str2, i);
    }
}

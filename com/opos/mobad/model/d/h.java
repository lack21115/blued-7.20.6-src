package com.opos.mobad.model.d;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/h.class */
public class h extends q {

    /* renamed from: a  reason: collision with root package name */
    private String f12743a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private long f12744c = System.currentTimeMillis();

    public h(String str, String str2) {
        this.f12743a = str;
        this.b = str2;
    }

    public void a(Context context) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f12743a, this.b, 0, g(), System.currentTimeMillis() - this.f12744c);
    }

    public void a(Context context, int i) {
        com.opos.mobad.cmn.a.b.d.a(context, this.f12743a, this.b, i, g(), System.currentTimeMillis() - this.f12744c);
    }
}

package com.opos.mobad.n.g;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/g/aj.class */
public class aj {

    /* renamed from: a  reason: collision with root package name */
    public final int f13109a;
    public final int b;

    public aj(int i, int i2) {
        this.f13109a = i;
        this.b = i2;
    }

    public static aj a(Context context) {
        int a2 = com.opos.cmn.an.h.f.a.a(context, 360.0f);
        return new aj(a2, (int) (a2 * 0.6d));
    }
}

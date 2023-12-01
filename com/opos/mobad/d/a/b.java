package com.opos.mobad.d.a;

import android.text.TextUtils;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/d/a/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final String f12262a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12263c;
    public int d = 0;
    public int e;
    public d f;

    public b(String str, String str2, int i, d dVar) {
        this.f12262a = str;
        this.b = str2;
        this.f12263c = i;
        this.f = dVar;
    }

    public boolean a(String str) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.b) || !str.equals(this.b)) ? false : true;
    }
}

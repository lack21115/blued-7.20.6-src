package com.opos.exoplayer.core.f.a;

import android.text.Layout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a/d.class */
final class d extends com.opos.exoplayer.core.f.b implements Comparable<d> {
    public final int m;

    public d(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
        super(charSequence, alignment, f, i, i2, f2, i3, f3, z, i4);
        this.m = i5;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(d dVar) {
        int i = dVar.m;
        int i2 = this.m;
        if (i < i2) {
            return -1;
        }
        return i > i2 ? 1 : 0;
    }
}

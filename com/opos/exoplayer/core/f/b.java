package com.opos.exoplayer.core.f;

import android.graphics.Bitmap;
import android.text.Layout;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f25344a;
    public final Layout.Alignment b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap f25345c;
    public final float d;
    public final int e;
    public final int f;
    public final float g;
    public final int h;
    public final float i;
    public final float j;
    public final boolean k;
    public final int l;

    public b(Bitmap bitmap, float f, int i, float f2, int i2, float f3, float f4) {
        this(null, null, bitmap, f2, 0, i2, f, i, f3, f4, false, -16777216);
    }

    public b(CharSequence charSequence) {
        this(charSequence, null, Float.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE, Integer.MIN_VALUE, Float.MIN_VALUE);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3) {
        this(charSequence, alignment, f, i, i2, f2, i3, f3, false, -16777216);
    }

    public b(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4) {
        this(charSequence, alignment, null, f, i, i2, f2, i3, f3, Float.MIN_VALUE, z, i4);
    }

    private b(CharSequence charSequence, Layout.Alignment alignment, Bitmap bitmap, float f, int i, int i2, float f2, int i3, float f3, float f4, boolean z, int i4) {
        this.f25344a = charSequence;
        this.b = alignment;
        this.f25345c = bitmap;
        this.d = f;
        this.e = i;
        this.f = i2;
        this.g = f2;
        this.h = i3;
        this.i = f3;
        this.j = f4;
        this.k = z;
        this.l = i4;
    }
}

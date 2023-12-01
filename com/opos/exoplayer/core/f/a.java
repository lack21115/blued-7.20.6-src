package com.opos.exoplayer.core.f;

import android.graphics.Typeface;
import android.view.accessibility.CaptioningManager;
import com.opos.exoplayer.core.i.u;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/f/a.class */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f25325a = new a(-1, -16777216, 0, 0, -1, null);
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25326c;
    public final int d;
    public final int e;
    public final int f;
    public final Typeface g;

    public a(int i, int i2, int i3, int i4, int i5, Typeface typeface) {
        this.b = i;
        this.f25326c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = typeface;
    }

    public static a a(CaptioningManager.CaptionStyle captionStyle) {
        return u.f25510a >= 21 ? c(captionStyle) : b(captionStyle);
    }

    private static a b(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.foregroundColor, captionStyle.backgroundColor, 0, captionStyle.edgeType, captionStyle.edgeColor, captionStyle.getTypeface());
    }

    private static a c(CaptioningManager.CaptionStyle captionStyle) {
        return new a(captionStyle.hasForegroundColor() ? captionStyle.foregroundColor : f25325a.b, captionStyle.hasBackgroundColor() ? captionStyle.backgroundColor : f25325a.f25326c, captionStyle.hasWindowColor() ? captionStyle.windowColor : f25325a.d, captionStyle.hasEdgeType() ? captionStyle.edgeType : f25325a.e, captionStyle.hasEdgeColor() ? captionStyle.edgeColor : f25325a.f, captionStyle.getTypeface());
    }
}

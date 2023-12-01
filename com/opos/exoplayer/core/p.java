package com.opos.exoplayer.core;

import com.blued.das.live.LiveProtos;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/p.class */
public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final p f25554a = new p(1.0f, 1.0f);
    public final float b;

    /* renamed from: c  reason: collision with root package name */
    public final float f25555c;
    private final int d;

    public p(float f, float f2) {
        com.opos.exoplayer.core.i.a.a(f > 0.0f);
        com.opos.exoplayer.core.i.a.a(f2 > 0.0f);
        this.b = f;
        this.f25555c = f2;
        this.d = Math.round(f * 1000.0f);
    }

    public long a(long j) {
        return this.d * j;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                p pVar = (p) obj;
                z = false;
                if (this.b == pVar.b) {
                    if (this.f25555c != pVar.f25555c) {
                        return false;
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        return ((Float.floatToRawIntBits(this.b) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + Float.floatToRawIntBits(this.f25555c);
    }
}

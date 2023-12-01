package com.opos.exoplayer.core;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f25588a = new w(0, 0);
    public static final w b = new w(Long.MAX_VALUE, Long.MAX_VALUE);

    /* renamed from: c  reason: collision with root package name */
    public static final w f25589c = new w(Long.MAX_VALUE, 0);
    public static final w d = new w(0, Long.MAX_VALUE);
    public static final w e = f25588a;
    public final long f;
    public final long g;

    public w(long j, long j2) {
        com.opos.exoplayer.core.i.a.a(j >= 0);
        com.opos.exoplayer.core.i.a.a(j2 >= 0);
        this.f = j;
        this.g = j2;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                w wVar = (w) obj;
                z = false;
                if (this.f == wVar.f) {
                    if (this.g != wVar.g) {
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
        return (((int) this.f) * 31) + ((int) this.g);
    }
}

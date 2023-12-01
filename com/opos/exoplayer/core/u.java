package com.opos.exoplayer.core;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/u.class */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    public static final u f25558a = new u(0);
    public final int b;

    public u(int i) {
        this.b = i;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (this != obj) {
            if (obj != null) {
                if (getClass() != obj.getClass() || this.b != ((u) obj).b) {
                    return false;
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        return this.b;
    }
}

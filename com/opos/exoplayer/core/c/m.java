package com.opos.exoplayer.core.c;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/c/m.class */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    public static final m f25252a = new m(0, 0);
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final long f25253c;

    public m(long j, long j2) {
        this.b = j;
        this.f25253c = j2;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                m mVar = (m) obj;
                z = false;
                if (this.b == mVar.b) {
                    if (this.f25253c != mVar.f25253c) {
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
        return (((int) this.b) * 31) + ((int) this.f25253c);
    }

    public String toString() {
        return "[timeUs=" + this.b + ", position=" + this.f25253c + "]";
    }
}

package com.anythink.expressad.exoplayer.e;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f7323a = new l(0, 0);
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final long f7324c;

    public l(long j, long j2) {
        this.b = j;
        this.f7324c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.b == lVar.b && this.f7324c == lVar.f7324c;
    }

    public final int hashCode() {
        return (((int) this.b) * 31) + ((int) this.f7324c);
    }

    public final String toString() {
        return "[timeUs=" + this.b + ", position=" + this.f7324c + "]";
    }
}

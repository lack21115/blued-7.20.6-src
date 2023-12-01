package com.anythink.expressad.exoplayer.e;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/e/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final l f4484a = new l(0, 0);
    public final long b;

    /* renamed from: c  reason: collision with root package name */
    public final long f4485c;

    public l(long j, long j2) {
        this.b = j;
        this.f4485c = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return this.b == lVar.b && this.f4485c == lVar.f4485c;
    }

    public final int hashCode() {
        return (((int) this.b) * 31) + ((int) this.f4485c);
    }

    public final String toString() {
        return "[timeUs=" + this.b + ", position=" + this.f4485c + "]";
    }
}

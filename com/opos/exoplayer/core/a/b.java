package com.opos.exoplayer.core.a;

import android.media.AudioAttributes;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f25008a = new a().a();
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f25009c;
    public final int d;
    private AudioAttributes e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f25010a = 0;
        private int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f25011c = 1;

        public b a() {
            return new b(this.f25010a, this.b, this.f25011c);
        }
    }

    private b(int i, int i2, int i3) {
        this.b = i;
        this.f25009c = i2;
        this.d = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioAttributes a() {
        if (this.e == null) {
            this.e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.f25009c).setUsage(this.d).build();
        }
        return this.e;
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                b bVar = (b) obj;
                z = false;
                if (this.b == bVar.b) {
                    z = false;
                    if (this.f25009c == bVar.f25009c) {
                        if (this.d != bVar.d) {
                            return false;
                        }
                    }
                }
            }
            return z;
        }
        z = true;
        return z;
    }

    public int hashCode() {
        return ((((this.b + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.f25009c) * 31) + this.d;
    }
}

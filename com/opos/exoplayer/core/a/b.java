package com.opos.exoplayer.core.a;

import android.media.AudioAttributes;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f11320a = new a().a();
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f11321c;
    public final int d;
    private AudioAttributes e;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/a/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f11322a = 0;
        private int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f11323c = 1;

        public b a() {
            return new b(this.f11322a, this.b, this.f11323c);
        }
    }

    private b(int i, int i2, int i3) {
        this.b = i;
        this.f11321c = i2;
        this.d = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AudioAttributes a() {
        if (this.e == null) {
            this.e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.f11321c).setUsage(this.d).build();
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
                    if (this.f11321c == bVar.f11321c) {
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
        return ((((this.b + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.f11321c) * 31) + this.d;
    }
}

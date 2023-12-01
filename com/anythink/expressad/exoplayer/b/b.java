package com.anythink.expressad.exoplayer.b;

import android.media.AudioAttributes;
import com.blued.das.live.LiveProtos;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f7172a = new a().a();
    public final int b;

    /* renamed from: c  reason: collision with root package name */
    public final int f7173c;
    public final int d;
    private AudioAttributes e;

    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/b/b$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f7174a = 0;
        private int b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f7175c = 1;

        private a c(int i) {
            this.b = i;
            return this;
        }

        public final a a(int i) {
            this.f7174a = i;
            return this;
        }

        public final b a() {
            return new b(this.f7174a, this.b, this.f7175c, (byte) 0);
        }

        public final a b(int i) {
            this.f7175c = i;
            return this;
        }
    }

    private b(int i, int i2, int i3) {
        this.b = i;
        this.f7173c = i2;
        this.d = i3;
    }

    /* synthetic */ b(int i, int i2, int i3, byte b) {
        this(i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final AudioAttributes a() {
        if (this.e == null) {
            this.e = new AudioAttributes.Builder().setContentType(this.b).setFlags(this.f7173c).setUsage(this.d).build();
        }
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.b == bVar.b && this.f7173c == bVar.f7173c && this.d == bVar.d;
    }

    public final int hashCode() {
        return ((((this.b + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE) * 31) + this.f7173c) * 31) + this.d;
    }
}

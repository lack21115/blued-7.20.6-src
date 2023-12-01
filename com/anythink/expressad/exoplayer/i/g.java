package com.anythink.expressad.exoplayer.i;

import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/i/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f4705a;
    private final f[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f4706c;

    public g(f... fVarArr) {
        this.b = fVarArr;
        this.f4705a = fVarArr.length;
    }

    public final f a(int i) {
        return this.b[i];
    }

    public final f[] a() {
        return (f[]) this.b.clone();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((g) obj).b);
    }

    public final int hashCode() {
        if (this.f4706c == 0) {
            this.f4706c = Arrays.hashCode(this.b) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
        }
        return this.f4706c;
    }
}

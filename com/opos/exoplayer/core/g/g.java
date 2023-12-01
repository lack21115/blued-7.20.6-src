package com.opos.exoplayer.core.g;

import com.blued.das.live.LiveProtos;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/g/g.class */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public final int f25435a;
    private final f[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f25436c;

    public g(f... fVarArr) {
        this.b = fVarArr;
        this.f25435a = fVarArr.length;
    }

    public f a(int i) {
        return this.b[i];
    }

    public f[] a() {
        return (f[]) this.b.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.b, ((g) obj).b);
    }

    public int hashCode() {
        if (this.f25436c == 0) {
            this.f25436c = Arrays.hashCode(this.b) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
        }
        return this.f25436c;
    }
}

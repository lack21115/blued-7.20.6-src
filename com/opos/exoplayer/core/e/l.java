package com.opos.exoplayer.core.e;

import com.blued.das.live.LiveProtos;
import com.opos.exoplayer.core.Format;
import java.util.Arrays;

/* loaded from: source-8303388-dex2jar.jar:com/opos/exoplayer/core/e/l.class */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public final int f11621a;
    private final Format[] b;

    /* renamed from: c  reason: collision with root package name */
    private int f11622c;

    public l(Format... formatArr) {
        com.opos.exoplayer.core.i.a.b(formatArr.length > 0);
        this.b = formatArr;
        this.f11621a = formatArr.length;
    }

    public int a(Format format) {
        int i = 0;
        while (true) {
            int i2 = i;
            Format[] formatArr = this.b;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i = i2 + 1;
        }
    }

    public Format a(int i) {
        return this.b[i];
    }

    public boolean equals(Object obj) {
        boolean z;
        if (this != obj) {
            z = false;
            if (obj != null) {
                if (getClass() != obj.getClass()) {
                    return false;
                }
                l lVar = (l) obj;
                z = false;
                if (this.f11621a == lVar.f11621a) {
                    if (!Arrays.equals(this.b, lVar.b)) {
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
        if (this.f11622c == 0) {
            this.f11622c = Arrays.hashCode(this.b) + LiveProtos.Event.LIVE_END_PAGE_CLOSE_CLICK_VALUE;
        }
        return this.f11622c;
    }
}

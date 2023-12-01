package com.anythink.expressad.exoplayer.k;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/w.class */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final int f7680a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7681c = 2;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/exoplayer/k/w$a.class */
    public @interface a {
    }

    private w() {
    }

    private static int a(int i, int i2) {
        int i3 = 1;
        while (true) {
            int i4 = i3;
            if (i4 > 2) {
                return i;
            }
            int i5 = (i + i4) % 3;
            boolean z = false;
            if (i5 == 0 || (i5 == 1 ? (i2 & 1) != 0 : !(i5 != 2 || (i2 & 2) == 0))) {
                z = true;
            }
            if (z) {
                return i5;
            }
            i3 = i4 + 1;
        }
    }

    private static boolean b(int i, int i2) {
        if (i != 0) {
            return i != 1 ? i == 2 && (i2 & 2) != 0 : (i2 & 1) != 0;
        }
        return true;
    }
}

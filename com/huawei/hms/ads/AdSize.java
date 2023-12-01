package com.huawei.hms.ads;

import android.content.Context;
import com.huawei.openalliance.ad.utils.c;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AdSize.class */
public class AdSize {
    public static final AdSize AD_SIZE_SMART = new AdSize(-1, -2);
    protected static final int B = -5;
    protected static final int Code = -1;
    private static final int D = -1;
    protected static final int I = -4;
    private static final float L = 10.0f;
    protected static final int V = -3;
    protected static final int Z = -2;
    protected final int C;
    protected int F = 0;
    protected final int S;

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/AdSize$a.class */
    public interface a {
        public static final int Code = 0;
        public static final int V = 1;
    }

    public AdSize(int i, int i2) {
        if (Code(i) && V(i2)) {
            this.C = i;
            this.S = i2;
            return;
        }
        this.C = 0;
        this.S = 0;
    }

    static boolean Code(int i) {
        return i > 0 || i == -1 || i == -3;
    }

    private boolean I(Context context) {
        if (this.F == 1) {
            int widthPx = getWidthPx(context);
            int heightPx = getHeightPx(context);
            return heightPx != 0 && ((float) widthPx) / ((float) heightPx) > 10.0f;
        }
        return false;
    }

    static boolean V(int i) {
        return i > 0 || i == -2 || i == -4 || i == -5;
    }

    public int Code(Context context) {
        return !I(context) ? getHeightPx(context) : c.Code(context, getWidthPx(context));
    }

    public int V(Context context) {
        return !I(context) ? getWidthPx(context) : c.V(context, getWidthPx(context));
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof AdSize) {
            AdSize adSize = (AdSize) obj;
            z = false;
            if (this.C == adSize.C) {
                z = false;
                if (this.S == adSize.S) {
                    z = false;
                    if (this.F == adSize.F) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public int getHeight() {
        return this.S;
    }

    public int getHeightPx(Context context) {
        if (V(this.S)) {
            int i = this.S;
            return i == -2 ? c.S(context) : i == -5 ? c.F(context) : c.I(context, i);
        }
        return -1;
    }

    public int getWidth() {
        return this.C;
    }

    public int getWidthPx(Context context) {
        if (Code(this.C)) {
            int i = this.C;
            return i == -1 ? c.V(context) : c.I(context, i);
        }
        return -1;
    }
}

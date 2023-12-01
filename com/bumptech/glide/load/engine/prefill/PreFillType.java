package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/prefill/PreFillType.class */
public final class PreFillType {

    /* renamed from: a  reason: collision with root package name */
    static final Bitmap.Config f7250a = Bitmap.Config.RGB_565;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7251c;
    private final Bitmap.Config d;
    private final int e;

    /* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/prefill/PreFillType$Builder.class */
    public static class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f7251c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bitmap.Config c() {
        return this.d;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj instanceof PreFillType) {
            PreFillType preFillType = (PreFillType) obj;
            z = false;
            if (this.f7251c == preFillType.f7251c) {
                z = false;
                if (this.b == preFillType.b) {
                    z = false;
                    if (this.e == preFillType.e) {
                        z = false;
                        if (this.d == preFillType.d) {
                            z = true;
                        }
                    }
                }
            }
        }
        return z;
    }

    public int hashCode() {
        return (((((this.b * 31) + this.f7251c) * 31) + this.d.hashCode()) * 31) + this.e;
    }

    public String toString() {
        return "PreFillSize{width=" + this.b + ", height=" + this.f7251c + ", config=" + this.d + ", weight=" + this.e + '}';
    }
}

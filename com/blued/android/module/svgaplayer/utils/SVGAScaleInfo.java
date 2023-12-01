package com.blued.android.module.svgaplayer.utils;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/SVGAScaleInfo.class */
public final class SVGAScaleInfo {
    private float a;
    private float b;
    private float c = 1.0f;
    private float d = 1.0f;
    private float e = 1.0f;
    private boolean f;

    @Metadata
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/utils/SVGAScaleInfo$WhenMappings.class */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            iArr[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            iArr[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            iArr[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            iArr[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            iArr[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            a = iArr;
        }
    }

    private final void f() {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 1.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = false;
    }

    public final float a() {
        return this.a;
    }

    public final void a(float f, float f2, float f3, float f4, ImageView.ScaleType scaleType) {
        Intrinsics.e(scaleType, "scaleType");
        boolean z = false;
        if (f == 0.0f) {
            return;
        }
        if (f2 == 0.0f) {
            return;
        }
        if (f3 == 0.0f) {
            return;
        }
        if (f4 == 0.0f) {
            return;
        }
        f();
        float f5 = (f - f3) / 2.0f;
        float f6 = (f2 - f4) / 2.0f;
        float f7 = f3 / f4;
        float f8 = f / f2;
        float f9 = f2 / f4;
        float f10 = f / f3;
        switch (WhenMappings.a[scaleType.ordinal()]) {
            case 1:
                this.a = f5;
                this.b = f6;
                return;
            case 2:
                if (f7 > f8) {
                    this.e = f9;
                    this.f = false;
                    this.c = f9;
                    this.d = f9;
                    this.a = (f - (f3 * f9)) / 2.0f;
                    return;
                }
                this.e = f10;
                this.f = true;
                this.c = f10;
                this.d = f10;
                this.b = (f2 - (f4 * f10)) / 2.0f;
                return;
            case 3:
                if (f3 < f && f4 < f2) {
                    this.a = f5;
                    this.b = f6;
                    return;
                } else if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    this.b = (f2 - (f4 * f10)) / 2.0f;
                    return;
                } else {
                    this.e = f9;
                    this.f = false;
                    this.c = f9;
                    this.d = f9;
                    this.a = (f - (f3 * f9)) / 2.0f;
                    return;
                }
            case 4:
                if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    this.b = (f2 - (f4 * f10)) / 2.0f;
                    return;
                }
                this.e = f9;
                this.f = false;
                this.c = f9;
                this.d = f9;
                this.a = (f - (f3 * f9)) / 2.0f;
                return;
            case 5:
                if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    return;
                }
                this.e = f9;
                this.f = false;
                this.c = f9;
                this.d = f9;
                return;
            case 6:
                if (f7 > f8) {
                    this.e = f10;
                    this.f = true;
                    this.c = f10;
                    this.d = f10;
                    this.b = f2 - (f4 * f10);
                    return;
                }
                this.e = f9;
                this.f = false;
                this.c = f9;
                this.d = f9;
                this.a = f - (f3 * f9);
                return;
            case 7:
                this.e = Math.max(f10, f9);
                if (f10 > f9) {
                    z = true;
                }
                this.f = z;
                this.c = f10;
                this.d = f9;
                return;
            default:
                this.e = f10;
                this.f = true;
                this.c = f10;
                this.d = f10;
                return;
        }
    }

    public final float b() {
        return this.b;
    }

    public final float c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final boolean e() {
        return this.f;
    }
}

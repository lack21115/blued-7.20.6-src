package com.blued.android.module.yy_china.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.blued.android.core.AppInfo;
import com.blued.android.module.yy_china.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/GiftToMicItemMode.class */
public final class GiftToMicItemMode {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private Bitmap e;
    private int m;
    private final int f = 15;
    private final int g = 80;
    private final int h = 20;
    private final int i = 10;
    private final int j = AppInfo.d().getResources().getDimensionPixelOffset(R.dimen.dp_250);
    private int k = AppInfo.d().getResources().getDimensionPixelOffset(R.dimen.dp_100);
    private int l = AppInfo.d().getResources().getDimensionPixelOffset(R.dimen.dp_100);
    private int n = -1;
    private int o = -1;
    private int p = -1;
    private int q = -1;

    public GiftToMicItemMode(int i, int i2, int i3, int i4, Bitmap bitmap) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = bitmap;
    }

    public final boolean a(Canvas canvas, Paint pa, int i, int i2) {
        int i3;
        int i4;
        int i5;
        Intrinsics.e(canvas, "canvas");
        Intrinsics.e(pa, "pa");
        this.m++;
        pa.setAlpha(255);
        int i6 = this.m;
        int i7 = this.f;
        if (i6 <= i7) {
            float f = 10;
            this.p = (int) ((((this.k * 1.0f) / i7) * i6) + f);
            int i8 = (int) (f + (((this.l * 1.0f) / i7) * i6));
            this.q = i8;
            this.n = (int) ((i - i4) / 2.0f);
            this.o = (int) (((i2 - ((i5 - i8) / 2.0f)) - this.j) - i8);
        } else {
            int i9 = this.g;
            if (i6 < i7 + i9) {
                float f2 = this.k;
                int i10 = this.c;
                float f3 = (i3 - i10) / i9;
                float f4 = i6 - i7;
                int i11 = (int) (f2 - (f3 * f4));
                this.p = i11;
                int i12 = this.l;
                float f5 = i12;
                int i13 = this.d;
                int i14 = (int) (f5 - (((i12 - i13) / i9) * f4));
                this.q = i14;
                float f6 = i10 / 2.0f;
                float f7 = i / 2.0f;
                this.n = (int) ((((((this.a + f6) - f7) / i9) * f4) + f7) - (i11 / 2.0f));
                float f8 = this.b;
                float f9 = i13 / 2.0f;
                int i15 = this.j;
                this.o = (int) ((((((f8 + f9) - ((i2 - i15) - (i12 / 2.0f))) / i9) * f4) + ((i2 - i15) - (i12 / 2.0f))) - (i14 / 2.0f));
            } else {
                int i16 = this.h;
                if (i6 < i7 + i9 + i16) {
                    this.p = this.c;
                    this.q = this.d;
                    this.n = this.a;
                    this.o = this.b;
                } else {
                    int i17 = this.i;
                    if (i6 >= i7 + i9 + i16 + i17) {
                        this.e = null;
                        return true;
                    }
                    pa.setAlpha((int) ((1 - ((((i6 - i7) - i9) - i16) / i17)) * 255));
                    this.p = this.c;
                    this.q = this.d;
                    this.n = this.a;
                    this.o = this.b;
                }
            }
        }
        Bitmap bitmap = this.e;
        if (bitmap != null) {
            if ((bitmap == null || bitmap.isRecycled()) ? false : true) {
                Bitmap bitmap2 = this.e;
                Intrinsics.a(bitmap2);
                int i18 = this.n;
                int i19 = this.o;
                canvas.drawBitmap(bitmap2, (Rect) null, new Rect(i18, i19, this.p + i18, this.q + i19), pa);
                return false;
            }
        }
        this.e = null;
        return true;
    }
}

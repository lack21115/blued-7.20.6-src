package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/zb.class */
public class zb {

    /* renamed from: a  reason: collision with root package name */
    private static final int f24468a = 7;
    private static Canvas b;

    /* renamed from: c  reason: collision with root package name */
    private static int f24469c;
    private static Bitmap[] d;
    private static Bitmap e;

    static {
        Bitmap[] bitmapArr = new Bitmap[7];
        d = bitmapArr;
        bitmapArr[0] = Bitmap.createBitmap(64, 32, Bitmap.Config.ARGB_8888);
        d[1] = Bitmap.createBitmap(128, 32, Bitmap.Config.ARGB_8888);
        d[2] = Bitmap.createBitmap(128, 64, Bitmap.Config.ARGB_8888);
        d[3] = Bitmap.createBitmap(256, 32, Bitmap.Config.ARGB_8888);
        d[4] = Bitmap.createBitmap(256, 128, Bitmap.Config.ARGB_8888);
        d[5] = Bitmap.createBitmap(32, 128, Bitmap.Config.ARGB_8888);
        d[6] = Bitmap.createBitmap(32, 256, Bitmap.Config.ARGB_8888);
        b = new Canvas(d[1]);
        f24469c = 1;
        e = null;
    }

    public static Bitmap a() {
        int i = f24469c;
        return i < 7 ? d[i] : e;
    }

    public static Canvas a(float f, float f2) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= 7 || (d[i].getWidth() >= f && d[i].getHeight() >= f2)) {
                break;
            }
            i4 = i + 1;
        }
        if (i < 7) {
            f24469c = i;
            b.setBitmap(d[i]);
            d[i].eraseColor(0);
            return b;
        }
        f24469c = d.length;
        int i5 = 1;
        while (true) {
            i2 = i5;
            i3 = 1;
            if (i2 >= f) {
                break;
            }
            i5 = i2 << 1;
        }
        while (i3 < f2) {
            i3 <<= 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        e = createBitmap;
        b.setBitmap(createBitmap);
        e.eraseColor(0);
        return b;
    }

    public static void a(float f, float f2, Point point) {
        int i;
        int i2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 7) {
                int i5 = 1;
                while (true) {
                    i = i5;
                    i2 = 1;
                    if (i >= f) {
                        break;
                    }
                    i5 = i << 1;
                }
                while (i2 < f2) {
                    i2 <<= 1;
                }
                point.set(i, i2);
                return;
            } else if (d[i4].getWidth() >= f && d[i4].getHeight() >= f2) {
                point.set(d[i4].getWidth(), d[i4].getHeight());
                return;
            } else {
                i3 = i4 + 1;
            }
        }
    }

    public static void b() {
        Bitmap bitmap = e;
        if (bitmap != null) {
            bitmap.recycle();
            e = null;
        }
    }
}

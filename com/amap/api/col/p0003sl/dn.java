package com.amap.api.col.p0003sl;

import android.graphics.Bitmap;

/* renamed from: com.amap.api.col.3sl.dn  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dn.class */
public final class dn {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f4858a = false;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f4859c = false;
    private boolean d = false;
    private int e = 0;
    private int f = 20;

    public static void a(boolean z) {
        f4858a = z;
    }

    public static boolean a() {
        return f4858a;
    }

    public static void b(boolean z) {
        b = z;
    }

    public static boolean b() {
        return b;
    }

    public static void c(boolean z) {
        f4859c = z;
    }

    public static boolean c() {
        return f4859c;
    }

    public static void g() {
        iw.c(new Exception("BlackScreen"), "PureScreenCheckTool", "uploadInfo");
    }

    public final boolean a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                int i = -1;
                for (int i2 = (int) (width / 4.0f); i2 < (width * 3) / 4.0f; i2++) {
                    int i3 = (int) (height / 4.0f);
                    while (i3 < (height * 3) / 4.0f) {
                        int pixel = bitmap.getPixel(i2, i3);
                        int i4 = i;
                        if (i == -1) {
                            i4 = pixel;
                        }
                        if (pixel != i4) {
                            this.d = true;
                            return false;
                        } else if (pixel != -16777216) {
                            this.d = true;
                            return false;
                        } else {
                            i3++;
                            i = i4;
                        }
                    }
                }
            } finally {
                try {
                } catch (Throwable th) {
                }
            }
        }
        this.d = true;
        return true;
    }

    public final boolean d() {
        return this.d;
    }

    public final void e() {
        this.e++;
    }

    public final boolean f() {
        return this.e >= this.f;
    }
}

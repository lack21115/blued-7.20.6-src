package com.opos.mobad.n.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/d.class */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final short[] f12918a = {512, 512, 456, 512, 328, 456, 335, 512, 405, 328, 271, 456, 388, 335, 292, 512, 454, 405, 364, 328, 298, 271, 496, 456, 420, 388, 360, 335, 312, 292, 273, 512, 482, 454, 428, 405, 383, 364, 345, 328, 312, 298, 284, 271, 259, 496, 475, 456, 437, 420, 404, 388, 374, 360, 347, 335, 323, 312, 302, 292, 282, 273, 265, 512, 497, 482, 468, 454, 441, 428, 417, 405, 394, 383, 373, 364, 354, 345, 337, 328, 320, 312, 305, 298, 291, 284, 278, 271, 265, 259, 507, 496, 485, 475, 465, 456, 446, 437, 428, 420, 412, 404, 396, 388, 381, 374, 367, 360, 354, 347, 341, 335, 329, 323, 318, 312, 307, 302, 297, 292, 287, 282, 278, 273, 269, 265, 261, 512, 505, 497, 489, 482, 475, 468, 461, 454, 447, 441, 435, 428, 422, 417, 411, 405, 399, 394, 389, 383, 378, 373, 368, 364, 359, 354, 350, 345, 341, 337, 332, 328, 324, 320, 316, 312, 309, 305, 301, 298, 294, 291, 287, 284, 281, 278, 274, 271, 268, 265, 262, 259, 257, 507, 501, 496, 491, 485, 480, 475, 470, 465, 460, 456, 451, 446, 442, 437, 433, 428, 424, 420, 416, 412, 408, 404, 400, 396, 392, 388, 385, 381, 377, 374, 370, 367, 363, 360, 357, 354, 350, 347, 344, 341, 338, 335, 332, 329, 326, 323, 320, 318, 315, 312, 310, 307, 304, 302, 299, 297, 294, 292, 289, 287, 285, 282, 280, 278, 275, 273, 271, 269, 267, 265, 263, 261, 259};
    private static final byte[] b = {9, 11, 12, 13, 13, 14, 14, 15, 15, 15, 15, 16, 16, 16, 16, 17, 17, 17, 17, 17, 17, 17, 18, 18, 18, 18, 18, 18, 18, 18, 18, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 19, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 21, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 22, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 23, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24, 24};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.mobad.n.c.d$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/n/c/d$1.class */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f12919a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f12919a = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f12919a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f12919a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f12919a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static Bitmap a(Context context, Bitmap bitmap, int i, float f, float f2) {
        if (context == null || bitmap == null) {
            return null;
        }
        try {
            int width = (bitmap.getWidth() * i) / 100;
            int height = (bitmap.getHeight() * i) / 100;
            Bitmap b2 = b(a(bitmap, (bitmap.getWidth() - width) / 2, (bitmap.getHeight() - height) / 2, width, height), f);
            if (b2 != null) {
                return a(b2, f2);
            }
            return null;
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.a("GaussianBlur", "", th);
            return null;
        }
    }

    private static Bitmap a(Bitmap bitmap, float f) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i = (int) f;
        a(iArr, width, height, i, 1, 0, 1);
        a(iArr, width, height, i, 1, 0, 2);
        return Bitmap.createBitmap(iArr, width, height, Bitmap.Config.ARGB_8888);
    }

    private static Bitmap a(Bitmap bitmap, int i, int i2, int i3, int i4) {
        Bitmap bitmap2 = bitmap;
        if (i >= 0) {
            bitmap2 = bitmap;
            if (i2 >= 0) {
                bitmap2 = bitmap;
                if (i3 >= 1) {
                    bitmap2 = bitmap;
                    if (i4 >= 1) {
                        int i5 = i + i3;
                        bitmap2 = bitmap;
                        if (i5 <= bitmap.getWidth()) {
                            int i6 = i2 + i4;
                            if (i6 > bitmap.getHeight()) {
                                return bitmap;
                            }
                            Bitmap.Config config = Bitmap.Config.ARGB_8888;
                            Bitmap.Config config2 = bitmap.getConfig();
                            if (config2 != null) {
                                int i7 = AnonymousClass1.f12919a[config2.ordinal()];
                                config = i7 != 1 ? i7 != 2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.ALPHA_8 : Bitmap.Config.RGB_565;
                            }
                            bitmap2 = Bitmap.createBitmap(i3, i4, config);
                            bitmap2.setDensity(bitmap.getDensity());
                            Rect rect = new Rect(i, i2, i5, i6);
                            RectF rectF = new RectF(0.0f, 0.0f, i3, i4);
                            Canvas canvas = new Canvas();
                            canvas.setBitmap(bitmap2);
                            canvas.drawColor(-1);
                            canvas.drawBitmap(bitmap, rect, rectF, (Paint) null);
                            canvas.setBitmap(null);
                        }
                    }
                }
            }
        }
        return bitmap2;
    }

    private static void a(int[] iArr, int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i - 1;
        int i8 = i2 - 1;
        int i9 = (i3 * 2) + 1;
        short s = f12918a[i3];
        byte b2 = b[i3];
        int[] iArr2 = new int[i9];
        if (i6 == 1) {
            int i10 = ((i5 + 1) * i2) / i4;
            int i11 = i7;
            int i12 = (i5 * i2) / i4;
            while (i12 < i10) {
                int i13 = i * i12;
                long j = 0;
                long j2 = 0;
                long j3 = 0;
                long j4 = 0;
                long j5 = 0;
                long j6 = 0;
                int i14 = 0;
                while (i14 <= i3) {
                    iArr2[i14] = iArr[i13];
                    i14++;
                    j += ((iArr[i13] >>> 16) & 255) * i14;
                    j2 += ((iArr[i13] >>> 8) & 255) * i14;
                    j3 += (iArr[i13] & 255) * i14;
                    j4 += (iArr[i13] >>> 16) & 255;
                    j5 += (iArr[i13] >>> 8) & 255;
                    j6 += iArr[i13] & 255;
                }
                int i15 = i13;
                long j7 = 0;
                long j8 = 0;
                long j9 = 0;
                int i16 = 1;
                while (i16 <= i3) {
                    int i17 = i15;
                    if (i16 <= i11) {
                        i17 = i15 + 1;
                    }
                    iArr2[i16 + i3] = iArr[i17];
                    int i18 = (i3 + 1) - i16;
                    j += ((iArr[i17] >>> 16) & 255) * i18;
                    j2 += ((iArr[i17] >>> 8) & 255) * i18;
                    j3 += (iArr[i17] & 255) * i18;
                    j9 += (iArr[i17] >>> 16) & 255;
                    j8 += (iArr[i17] >>> 8) & 255;
                    j7 += iArr[i17] & 255;
                    i16++;
                    i15 = i17;
                }
                int i19 = i3 > i11 ? i11 : i3;
                int i20 = 0;
                int i21 = i3;
                int i22 = i13 + i19;
                int i23 = i19;
                int i24 = i11;
                while (i20 < i) {
                    long j10 = s;
                    iArr[i13] = (int) ((((j10 * j3) >>> b2) & 255) | (iArr[i13] & (-16777216)) | ((((j10 * j) >>> b2) & 255) << 16) | ((((j10 * j2) >>> b2) & 255) << 8));
                    int i25 = (i21 + i9) - i3;
                    int i26 = i25;
                    if (i25 >= i9) {
                        i26 = i25 - i9;
                    }
                    long j11 = (iArr2[i26] >>> 16) & 255;
                    long j12 = (iArr2[i26] >>> 8) & 255;
                    long j13 = iArr2[i26] & 255;
                    if (i23 < i24) {
                        i22++;
                        i23++;
                    }
                    iArr2[i26] = iArr[i22];
                    long j14 = j9 + ((iArr[i22] >>> 16) & 255);
                    long j15 = j8 + ((iArr[i22] >>> 8) & 255);
                    long j16 = j7 + (iArr[i22] & 255);
                    j = (j - j4) + j14;
                    j2 = (j2 - j5) + j15;
                    j3 = (j3 - j6) + j16;
                    int i27 = i21 + 1;
                    int i28 = i27;
                    if (i27 >= i9) {
                        i28 = 0;
                    }
                    j4 = (j4 - j11) + ((iArr2[i28] >>> 16) & 255);
                    j5 = (j5 - j12) + ((iArr2[i28] >>> 8) & 255);
                    j6 = (j6 - j13) + (iArr2[i28] & 255);
                    j9 = j14 - ((iArr2[i28] >>> 16) & 255);
                    j8 = j15 - ((iArr2[i28] >>> 8) & 255);
                    j7 = j16 - (iArr2[i28] & 255);
                    i20++;
                    i13++;
                    i21 = i28;
                }
                i12++;
                i11 = i24;
            }
        } else if (i6 == 2) {
            int i29 = (i5 * i) / i4;
            int i30 = ((i5 + 1) * i) / i4;
            int i31 = i8;
            int i32 = i29;
            while (i32 < i30) {
                long j17 = 0;
                long j18 = 0;
                long j19 = 0;
                long j20 = 0;
                long j21 = 0;
                long j22 = 0;
                int i33 = 0;
                while (i33 <= i3) {
                    iArr2[i33] = iArr[i32];
                    i33++;
                    j19 += ((iArr[i32] >>> 8) & 255) * i33;
                    j18 += (iArr[i32] & 255) * i33;
                    j20 += (iArr[i32] >>> 16) & 255;
                    j21 += (iArr[i32] >>> 8) & 255;
                    j22 += iArr[i32] & 255;
                    j17 += ((iArr[i32] >>> 16) & 255) * i33;
                }
                int i34 = i32;
                long j23 = 0;
                long j24 = 0;
                long j25 = 0;
                int i35 = 1;
                while (i35 <= i3) {
                    int i36 = i34;
                    if (i35 <= i31) {
                        i36 = i34 + i;
                    }
                    iArr2[i35 + i3] = iArr[i36];
                    int i37 = (i3 + 1) - i35;
                    j17 += ((iArr[i36] >>> 16) & 255) * i37;
                    j19 += ((iArr[i36] >>> 8) & 255) * i37;
                    j18 += (iArr[i36] & 255) * i37;
                    j25 += (iArr[i36] >>> 16) & 255;
                    j24 += (iArr[i36] >>> 8) & 255;
                    j23 += iArr[i36] & 255;
                    i35++;
                    i34 = i36;
                }
                int i38 = i3 > i31 ? i31 : i3;
                int i39 = i3;
                int i40 = i32;
                int i41 = 0;
                int i42 = i31;
                int i43 = i30;
                int i44 = (i38 * i) + i32;
                int i45 = i38;
                while (i41 < i2) {
                    long j26 = s;
                    iArr[i40] = (int) ((iArr[i40] & (-16777216)) | ((((j26 * j17) >>> b2) & 255) << 16) | ((((j26 * j19) >>> b2) & 255) << 8) | (((j26 * j18) >>> b2) & 255));
                    i40 += i;
                    int i46 = (i39 + i9) - i3;
                    int i47 = i46;
                    if (i46 >= i9) {
                        i47 = i46 - i9;
                    }
                    long j27 = (iArr2[i47] >>> 16) & 255;
                    long j28 = (iArr2[i47] >>> 8) & 255;
                    long j29 = iArr2[i47] & 255;
                    if (i45 < i42) {
                        i44 += i;
                        i45++;
                    }
                    iArr2[i47] = iArr[i44];
                    long j30 = j25 + ((iArr[i44] >>> 16) & 255);
                    long j31 = j24 + ((iArr[i44] >>> 8) & 255);
                    long j32 = j23 + (iArr[i44] & 255);
                    j17 = (j17 - j20) + j30;
                    j19 = (j19 - j21) + j31;
                    j18 = (j18 - j22) + j32;
                    int i48 = i39 + 1;
                    if (i48 >= i9) {
                        i48 = 0;
                    }
                    j20 = (j20 - j27) + ((iArr2[i48] >>> 16) & 255);
                    j21 = (j21 - j28) + ((iArr2[i48] >>> 8) & 255);
                    j22 = (j22 - j29) + (iArr2[i48] & 255);
                    j25 = j30 - ((iArr2[i48] >>> 16) & 255);
                    j24 = j31 - ((iArr2[i48] >>> 8) & 255);
                    j23 = j32 - (iArr2[i48] & 255);
                    i41++;
                    i39 = i48;
                }
                i32++;
                i30 = i43;
                i31 = i42;
            }
        }
    }

    private static Bitmap b(Bitmap bitmap, float f) {
        Bitmap bitmap2 = null;
        if (bitmap != null) {
            bitmap2 = null;
            try {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, Math.round(bitmap.getWidth() * f), Math.round(bitmap.getHeight() * f), true);
                bitmap2 = createScaledBitmap;
                if (bitmap != createScaledBitmap) {
                    com.opos.cmn.an.f.a.b("GaussianBlur", "src != dst,src.recycle()");
                    bitmap2 = createScaledBitmap;
                    bitmap.recycle();
                    return createScaledBitmap;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("GaussianBlur", "", (Throwable) e);
            }
        }
        return bitmap2;
    }
}

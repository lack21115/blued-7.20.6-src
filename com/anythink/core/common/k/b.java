package com.anythink.core.common.k;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import java.io.FileDescriptor;
import java.lang.reflect.Array;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/k/b.class */
public final class b {
    private static int a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i3 <= 0) {
            i5 = 1;
            if (i4 <= 0) {
                return 1;
            }
        }
        while (i / i5 > i3 && i2 / i5 > i4) {
            i5 *= 2;
        }
        return i5;
    }

    public static Bitmap a(Context context, Bitmap bitmap) {
        if (bitmap.isRecycled()) {
            com.anythink.core.common.j.c.a("Error", "Error, cannot access an invalid/free'd bitmap here!", com.anythink.core.common.b.n.a().r());
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() / 3, bitmap.getHeight() / 3, Bitmap.Config.ARGB_8888);
            if (Build.VERSION.SDK_INT >= 17) {
                RenderScript create = RenderScript.create(context);
                ScriptIntrinsicBlur create2 = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
                Allocation createFromBitmap = Allocation.createFromBitmap(create, bitmap);
                Allocation createFromBitmap2 = Allocation.createFromBitmap(create, createBitmap);
                create2.setRadius(25.0f);
                create2.setInput(createFromBitmap);
                create2.forEach(createFromBitmap2);
                createFromBitmap2.copyTo(createBitmap);
                new Canvas(createBitmap).drawColor(855638016);
                create.destroy();
                return createBitmap;
            }
            return a(createBitmap);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static Bitmap a(Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int i2 = width - 1;
        int i3 = height - 1;
        int[] iArr2 = new int[i];
        int[] iArr3 = new int[i];
        int[] iArr4 = new int[i];
        int[] iArr5 = new int[Math.max(width, height)];
        int[] iArr6 = new int[173056];
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= 173056) {
                break;
            }
            iArr6[i5] = i5 / 676;
            i4 = i5 + 1;
        }
        int[][] iArr7 = (int[][]) Array.newInstance(Integer.TYPE, 51, 3);
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < height; i8++) {
            int i9 = 0;
            int i10 = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            for (int i18 = -25; i18 <= 25; i18++) {
                int i19 = iArr[Math.min(i2, Math.max(i18, 0)) + i6];
                int[] iArr8 = iArr7[i18 + 25];
                iArr8[0] = (i19 & 16711680) >> 16;
                iArr8[1] = (i19 & 65280) >> 8;
                iArr8[2] = i19 & 255;
                int abs = 26 - Math.abs(i18);
                i9 += iArr8[0] * abs;
                i10 += iArr8[1] * abs;
                i11 += iArr8[2] * abs;
                if (i18 > 0) {
                    i15 += iArr8[0];
                    i16 += iArr8[1];
                    i17 += iArr8[2];
                } else {
                    i12 += iArr8[0];
                    i13 += iArr8[1];
                    i14 += iArr8[2];
                }
            }
            int i20 = i16;
            int i21 = i15;
            int i22 = i9;
            int i23 = 25;
            for (int i24 = 0; i24 < width; i24++) {
                iArr2[i6] = iArr6[i22];
                iArr3[i6] = iArr6[i10];
                iArr4[i6] = iArr6[i11];
                int[] iArr9 = iArr7[((i23 - 25) + 51) % 51];
                int i25 = iArr9[0];
                int i26 = iArr9[1];
                int i27 = iArr9[2];
                if (i8 == 0) {
                    iArr5[i24] = Math.min(i24 + 25 + 1, i2);
                }
                int i28 = iArr[iArr5[i24] + i7];
                iArr9[0] = (i28 & 16711680) >> 16;
                iArr9[1] = (i28 & 65280) >> 8;
                iArr9[2] = i28 & 255;
                int i29 = i21 + iArr9[0];
                int i30 = i20 + iArr9[1];
                int i31 = i17 + iArr9[2];
                i22 = (i22 - i12) + i29;
                i10 = (i10 - i13) + i30;
                i11 = (i11 - i14) + i31;
                i23 = (i23 + 1) % 51;
                int[] iArr10 = iArr7[i23 % 51];
                i12 = (i12 - i25) + iArr10[0];
                i13 = (i13 - i26) + iArr10[1];
                i14 = (i14 - i27) + iArr10[2];
                i21 = i29 - iArr10[0];
                i20 = i30 - iArr10[1];
                i17 = i31 - iArr10[2];
                i6++;
            }
            i7 += width;
        }
        int i32 = 0;
        while (true) {
            int i33 = i32;
            if (i33 >= width) {
                bitmap.setPixels(iArr, 0, width, 0, 0, width, height);
                return bitmap;
            }
            int i34 = width * (-25);
            int i35 = -25;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            while (i35 <= 25) {
                int max = Math.max(0, i34) + i33;
                int[] iArr11 = iArr7[i35 + 25];
                iArr11[0] = iArr2[max];
                iArr11[1] = iArr3[max];
                iArr11[2] = iArr4[max];
                int abs2 = 26 - Math.abs(i35);
                int i45 = i36 + (iArr2[max] * abs2);
                i37 += iArr3[max] * abs2;
                i38 += iArr4[max] * abs2;
                if (i35 > 0) {
                    i42 += iArr11[0];
                    i43 += iArr11[1];
                    i44 += iArr11[2];
                } else {
                    i39 += iArr11[0];
                    i40 += iArr11[1];
                    i41 += iArr11[2];
                }
                int i46 = i34;
                if (i35 < i3) {
                    i46 = i34 + width;
                }
                i35++;
                i34 = i46;
                i36 = i45;
            }
            int i47 = 25;
            int i48 = i43;
            int i49 = i42;
            int i50 = i36;
            int i51 = i33;
            int i52 = 0;
            while (true) {
                int i53 = i52;
                if (i53 < height) {
                    iArr[i51] = (iArr[i51] & View.MEASURED_STATE_MASK) | (iArr6[i50] << 16) | (iArr6[i37] << 8) | iArr6[i38];
                    int[] iArr12 = iArr7[((i47 - 25) + 51) % 51];
                    int i54 = iArr12[0];
                    int i55 = iArr12[1];
                    int i56 = iArr12[2];
                    if (i33 == 0) {
                        iArr5[i53] = Math.min(i53 + 26, i3) * width;
                    }
                    int i57 = iArr5[i53] + i33;
                    iArr12[0] = iArr2[i57];
                    iArr12[1] = iArr3[i57];
                    iArr12[2] = iArr4[i57];
                    int i58 = i49 + iArr12[0];
                    int i59 = i48 + iArr12[1];
                    int i60 = i44 + iArr12[2];
                    i50 = (i50 - i39) + i58;
                    i37 = (i37 - i40) + i59;
                    i38 = (i38 - i41) + i60;
                    i47 = (i47 + 1) % 51;
                    int[] iArr13 = iArr7[i47];
                    i39 = (i39 - i54) + iArr13[0];
                    i40 = (i40 - i55) + iArr13[1];
                    i41 = (i41 - i56) + iArr13[2];
                    i49 = i58 - iArr13[0];
                    i48 = i59 - iArr13[1];
                    i44 = i60 - iArr13[2];
                    i51 += width;
                    i52 = i53 + 1;
                }
            }
            i32 = i33 + 1;
        }
    }

    public static Bitmap a(FileDescriptor fileDescriptor, int i, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
            options.inSampleSize = a(options.outWidth, options.outHeight, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static Bitmap a(String str, int i, int i2) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = a(options.outWidth, options.outHeight, i, i2);
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }

    public static int[] a(String str) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            return new int[]{options.outWidth, options.outHeight};
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } catch (OutOfMemoryError e2) {
            return null;
        }
    }
}

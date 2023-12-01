package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.amap.api.col.3sl.dl  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/dl.class */
public final class dl {
    private static int a(byte[] bArr, int i) {
        return (bArr[i + 3] << 24) | (bArr[i + 0] & 255) | (bArr[i + 1] << 8) | (bArr[i + 2] << 16);
    }

    private static Bitmap a(InputStream inputStream) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] a2 = a(decodeStream);
        if (NinePatch.isNinePatchChunk(a2)) {
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            dw.a(decodeStream);
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = createBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(createBitmap, a2);
                return createBitmap;
            }
            Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
            declaredField.setAccessible(true);
            declaredField.set(createBitmap, a2);
            return createBitmap;
        }
        return decodeStream;
    }

    public static Drawable a(Context context, String str) throws Exception {
        Bitmap b = b(context, str);
        if (b.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), b);
        }
        Rect rect = new Rect();
        a(b.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), b, b.getNinePatchChunk(), rect, null);
    }

    private static void a(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= width) {
                break;
            } else if (-16777216 == iArr[i2]) {
                a(bArr, 12, i2);
                break;
            } else {
                i = i2 + 1;
            }
        }
        int i3 = width;
        while (true) {
            int i4 = i3 - 1;
            if (i4 < 0) {
                break;
            } else if (-16777216 == iArr[i4]) {
                a(bArr, 16, (width - i4) - 2);
                break;
            } else {
                i3 = i4;
            }
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= height) {
                break;
            } else if (-16777216 == iArr2[i6]) {
                a(bArr, 20, i6);
                break;
            } else {
                i5 = i6 + 1;
            }
        }
        int i7 = height;
        while (true) {
            int i8 = i7 - 1;
            if (i8 < 0) {
                return;
            }
            if (-16777216 == iArr2[i8]) {
                a(bArr, 24, (height - i8) - 2);
                return;
            }
            i7 = i8;
        }
    }

    private static void a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    private static void a(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    private static void a(byte[] bArr, Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    private static byte[] a(Bitmap bitmap) throws IOException {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 32) {
                break;
            }
            byteArrayOutputStream.write(0);
            i3 = i4 + 1;
        }
        int i5 = width - 2;
        int[] iArr = new int[i5];
        bitmap.getPixels(iArr, 0, width, 1, 0, i5, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[i5 - 1] == -16777216;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i = i8;
            if (i6 >= i5) {
                break;
            }
            int i9 = i7;
            int i10 = i;
            if (i7 != iArr[i6]) {
                i10 = i + 1;
                a(byteArrayOutputStream, i6);
                i9 = iArr[i6];
            }
            i6++;
            i7 = i9;
            i8 = i10;
        }
        int i11 = i;
        if (z2) {
            i11 = i + 1;
            a(byteArrayOutputStream, i5);
        }
        int i12 = i11 + 1;
        int i13 = i12;
        if (z) {
            i13 = i12 - 1;
        }
        int i14 = i13;
        if (z2) {
            i14 = i13 - 1;
        }
        int i15 = height - 2;
        int[] iArr2 = new int[i15];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i15);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[i15 - 1] == -16777216;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            i2 = i18;
            if (i16 >= i15) {
                break;
            }
            int i19 = i17;
            int i20 = i2;
            if (i17 != iArr2[i16]) {
                i20 = i2 + 1;
                a(byteArrayOutputStream, i16);
                i19 = iArr2[i16];
            }
            i16++;
            i17 = i19;
            i18 = i20;
        }
        int i21 = i2;
        if (z4) {
            i21 = i2 + 1;
            a(byteArrayOutputStream, i15);
        }
        int i22 = i21 + 1;
        int i23 = i22;
        if (z3) {
            i23 = i22 - 1;
        }
        int i24 = i23;
        if (z4) {
            i24 = i23 - 1;
        }
        int i25 = 0;
        while (true) {
            int i26 = i25;
            int i27 = i14 * i24;
            if (i26 >= i27) {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i11;
                byteArray[2] = (byte) i21;
                byteArray[3] = (byte) i27;
                a(bitmap, byteArray);
                return byteArray;
            }
            a(byteArrayOutputStream, 1);
            i25 = i26 + 1;
        }
    }

    private static Bitmap b(Context context, String str) throws Exception {
        InputStream open = dq.a(context).open(str);
        Bitmap a2 = a(open);
        open.close();
        return a2;
    }
}

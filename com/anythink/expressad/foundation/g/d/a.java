package com.anythink.expressad.foundation.g.d;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.anythink.expressad.foundation.h.m;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/d/a.class */
public final class a {
    private static int a(BitmapFactory.Options options, int i, int i2) {
        int min;
        double d = options.outWidth;
        double d2 = options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / i2));
        if (i == -1) {
            min = 128;
        } else {
            double d3 = i;
            min = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? ceil : min;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap a(android.content.Context r4, int r5) {
        /*
            r0 = r4
            android.content.res.Resources r0 = r0.getResources()     // Catch: java.lang.OutOfMemoryError -> L22 java.lang.Exception -> L26
            r1 = r5
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeResource(r0, r1)     // Catch: java.lang.OutOfMemoryError -> L22 java.lang.Exception -> L26
            r4 = r0
            goto L11
        Lc:
            java.lang.System.gc()
        Lf:
            r0 = 0
            r4 = r0
        L11:
            r0 = r4
            r6 = r0
            r0 = r4
            if (r0 != 0) goto L20
            r0 = 1
            r1 = 1
            android.graphics.Bitmap$Config r2 = android.graphics.Bitmap.Config.ALPHA_8
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r0, r1, r2)
            r6 = r0
        L20:
            r0 = r6
            return r0
        L22:
            r4 = move-exception
            goto Lc
        L26:
            r4 = move-exception
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.d.a.a(android.content.Context, int):android.graphics.Bitmap");
    }

    public static Bitmap a(String str) {
        Bitmap bitmap = null;
        if (m.a(str)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            try {
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(str, options);
                options.inJustDecodeBounds = false;
                options.inPurgeable = true;
                options.inInputShareable = true;
                options.inDither = true;
                return BitmapFactory.decodeFile(str, options);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } catch (OutOfMemoryError e2) {
                e2.printStackTrace();
                System.gc();
                b.a();
                bitmap = null;
                try {
                    options.inPreferredConfig = Bitmap.Config.RGB_565;
                    Bitmap decodeFile = BitmapFactory.decodeFile(str, options);
                    bitmap = decodeFile;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    return decodeFile;
                } catch (OutOfMemoryError e3) {
                    e3.printStackTrace();
                }
            }
        }
        return bitmap;
    }

    private static Drawable a(Resources resources, Bitmap bitmap) {
        return new BitmapDrawable(resources, bitmap);
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.io.InputStream a(android.graphics.Bitmap r5) {
        /*
            r0 = 0
            r6 = r0
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> L41 java.lang.Exception -> L45
            r7 = r0
            r0 = r7
            r6 = r0
            r0 = r5
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L6d
            r2 = 100
            r3 = r7
            boolean r0 = r0.compress(r1, r2, r3)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L6d
            r0 = r7
            r6 = r0
            java.io.ByteArrayInputStream r0 = new java.io.ByteArrayInputStream     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L6d
            r1 = r0
            r2 = r7
            byte[] r2 = r2.toByteArray()     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L6d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L39 java.lang.Throwable -> L6d
            r5 = r0
            r0 = r7
            r0.close()     // Catch: java.lang.Exception -> L2c
            goto L37
        L2c:
            r6 = move-exception
            boolean r0 = com.anythink.expressad.a.f4103a
            if (r0 == 0) goto L37
            r0 = r6
            r0.printStackTrace()
        L37:
            r0 = r5
            return r0
        L39:
            r6 = move-exception
            r0 = r7
            r5 = r0
            r0 = r6
            r7 = r0
            goto L48
        L41:
            r5 = move-exception
            goto L6e
        L45:
            r7 = move-exception
            r0 = 0
            r5 = r0
        L48:
            r0 = r5
            r6 = r0
            boolean r0 = com.anythink.expressad.a.f4103a     // Catch: java.lang.Throwable -> L6d
            if (r0 == 0) goto L56
            r0 = r5
            r6 = r0
            r0 = r7
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L6d
        L56:
            r0 = r5
            if (r0 == 0) goto L6b
            r0 = r5
            r0.close()     // Catch: java.lang.Exception -> L60
            r0 = 0
            return r0
        L60:
            r5 = move-exception
            boolean r0 = com.anythink.expressad.a.f4103a
            if (r0 == 0) goto L6b
            r0 = r5
            r0.printStackTrace()
        L6b:
            r0 = 0
            return r0
        L6d:
            r5 = move-exception
        L6e:
            r0 = r6
            if (r0 == 0) goto L84
            r0 = r6
            r0.close()     // Catch: java.lang.Exception -> L79
            goto L84
        L79:
            r6 = move-exception
            boolean r0 = com.anythink.expressad.a.f4103a
            if (r0 == 0) goto L84
            r0 = r6
            r0.printStackTrace()
        L84:
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.anythink.expressad.foundation.g.d.a.a(android.graphics.Bitmap):java.io.InputStream");
    }

    private static Bitmap b(Bitmap bitmap) {
        float f;
        float f2;
        float f3;
        float f4;
        if (bitmap == null) {
            return null;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f4 = width / 2;
            f3 = width;
            f = 0.0f;
            f2 = f3;
        } else {
            f = (width - height) / 2;
            f2 = height;
            f3 = width - f;
            width = height;
            f4 = height / 2;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            int i = (int) f2;
            Rect rect = new Rect((int) f, 0, (int) f3, i);
            Rect rect2 = new Rect(0, 0, i, i);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            canvas.drawRoundRect(rectF, f4, f4, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th) {
            return null;
        }
    }
}

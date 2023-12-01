package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.opengl.GLUtils;
import com.tencent.tencentmap.mapsdk.maps.TencentMapContext;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/dc.class */
public class dc {

    /* renamed from: a  reason: collision with root package name */
    public static final int f37392a = 1;
    public static final int b = 2;

    public static float a(float f, float f2) {
        return (int) ((f * f2) + 0.5f);
    }

    public static float a(TencentMapContext tencentMapContext, String str, int i, float f) {
        nc ncVar = new nc(tencentMapContext);
        ncVar.setTextSize(a(i, f));
        ncVar.setTypeface(Typeface.DEFAULT_BOLD);
        return ncVar.measureText(str);
    }

    private static int a(GL10 gl10) {
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    public static int a(GL10 gl10, int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        int b2 = b(gl10);
        gl10.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        gl10.glTexSubImage2D(3553, 0, 0, 0, i3, i4, 6408, 5121, intBuffer);
        return b2;
    }

    public static int a(GL10 gl10, Bitmap bitmap) {
        int b2 = b(gl10);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return b2;
    }

    private static Bitmap a(Bitmap bitmap) {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = 2;
        while (true) {
            i = i3;
            i2 = 2;
            if (i >= width) {
                break;
            }
            i3 = i << 1;
        }
        while (i2 < height) {
            i2 <<= 1;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i, i2, false);
        if (createScaledBitmap != bitmap) {
            bitmap.recycle();
        }
        return createScaledBitmap;
    }

    public static Bitmap a(TencentMapContext tencentMapContext, Bitmap bitmap, String str, int i, int i2) {
        return a(tencentMapContext, bitmap, str, i, i2, 0, 2.0f);
    }

    public static Bitmap a(TencentMapContext tencentMapContext, Bitmap bitmap, String str, int i, int i2, int i3, float f) {
        return a(tencentMapContext, bitmap, str, i, i2, i3, 2, f);
    }

    public static Bitmap a(TencentMapContext tencentMapContext, Bitmap bitmap, String str, int i, int i2, int i3, int i4, float f) {
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        nc ncVar = new nc(tencentMapContext);
        ncVar.setColor(i);
        ncVar.setTextSize(a(i2, f));
        ncVar.setTypeface(Typeface.DEFAULT_BOLD);
        float f2 = ncVar.getFontMetrics().bottom - ncVar.getFontMetrics().top;
        float max = Math.max(width, ncVar.measureText(str));
        float f3 = i3 * 2;
        float max2 = Math.max(height, f2);
        int ceil = (int) Math.ceil(max + f3);
        int ceil2 = (int) Math.ceil(max2 + f3);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, ceil, ceil2, false);
        Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.setDensity(0);
        canvas.drawBitmap(createScaledBitmap, 0.0f, 0.0f, new Paint());
        if (i4 != 1) {
            if (i4 != 2) {
                return createBitmap;
            }
            float f4 = (float) (ceil / 2);
            float f5 = ceil2;
            float f6 = (f5 - f2) / 2.0f;
            float f7 = ncVar.getFontMetrics().bottom;
            ncVar.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(str, f4, (f5 - f6) - f7, ncVar);
            return createBitmap;
        }
        float measureText = (ceil - ncVar.measureText(str.substring(0, 1))) / 2.0f;
        float length = (((ceil2 - (str.length() * f2)) / 2.0f) - ncVar.getFontMetrics().top) + 5.0f;
        for (int i5 = 0; i5 < str.length(); i5++) {
            canvas.drawText(String.valueOf(str.charAt(i5)), measureText, length, ncVar);
            length += f2;
        }
        return createBitmap;
    }

    public static Bitmap a(InputStream inputStream) {
        return BitmapFactory.decodeStream(inputStream, null, a());
    }

    public static Bitmap a(String str, float f, int i, int i2, int i3, Typeface typeface) {
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(i);
        paint.setTextSize(f);
        if (typeface != null) {
            paint.setTypeface(typeface);
        }
        Paint paint2 = new Paint(paint);
        paint2.setColor(i2);
        paint2.setStrokeWidth(paint.getStrokeWidth() + 2.0f);
        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        float f2 = fontMetrics.bottom - fontMetrics.top;
        if (i3 != 1) {
            if (i3 != 2) {
                return null;
            }
            int ceil = (int) Math.ceil(paint2.measureText(str) + 4.0f);
            int ceil2 = (int) Math.ceil(f2);
            Bitmap createBitmap = Bitmap.createBitmap(ceil, ceil2, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            float f3 = (float) (ceil / 2);
            float f4 = (float) ((ceil2 / 2) + 1);
            paint2.setTextAlign(Paint.Align.CENTER);
            paint.setTextAlign(Paint.Align.CENTER);
            canvas.drawText(str, f3, f4, paint2);
            canvas.drawText(str, f3, f4, paint);
            return createBitmap;
        }
        int ceil3 = (int) Math.ceil(((f2 + 2.0f) * str.length()) + 4.0f);
        int ceil4 = (int) Math.ceil(paint2.measureText(str.substring(0, 1)) + 4.0f);
        float f5 = 0.0f - fontMetrics.top;
        Bitmap createBitmap2 = Bitmap.createBitmap(ceil4, ceil3, Bitmap.Config.ARGB_8888);
        Canvas canvas2 = new Canvas(createBitmap2);
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            canvas2.drawText(String.valueOf(charAt), 2.0f, f5, paint2);
            canvas2.drawText(String.valueOf(charAt), 2.0f, f5, paint);
            f5 += f2;
        }
        return createBitmap2;
    }

    public static Bitmap a(byte[] bArr) {
        return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, a());
    }

    private static BitmapFactory.Options a() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return options;
    }

    public static void a(GL10 gl10, int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(4);
        allocateDirect.order(ByteOrder.nativeOrder());
        IntBuffer asIntBuffer = allocateDirect.asIntBuffer();
        asIntBuffer.put(i);
        asIntBuffer.position(0);
        gl10.glDeleteTextures(1, asIntBuffer);
    }

    private static int b(GL10 gl10) {
        int a2 = a(gl10);
        gl10.glBindTexture(3553, a2);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
        gl10.glTexParameterf(3553, 10242, 33071.0f);
        gl10.glTexParameterf(3553, 10243, 33071.0f);
        return a2;
    }

    public static Bitmap b(Bitmap bitmap) {
        int i;
        int i2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i3 = 2;
        while (true) {
            i = i3;
            i2 = 2;
            if (i >= width) {
                break;
            }
            i3 = i << 1;
        }
        while (i2 < height) {
            i2 <<= 1;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        try {
            Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
            createBitmap.setDensity(0);
            Canvas canvas = new Canvas(createBitmap);
            canvas.setDensity(0);
            createBitmap.eraseColor(0);
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
            return createBitmap;
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Bitmap b(InputStream inputStream) {
        return a(a(inputStream));
    }

    public static Bitmap b(byte[] bArr) {
        return a(a(bArr));
    }
}

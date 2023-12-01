package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.opengl.GLUtils;
import com.sensetime.stmobile.STMobileHumanActionNative;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import javax.microedition.khronos.opengles.GL10;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/bc.class */
public class bc {

    /* renamed from: a  reason: collision with root package name */
    public static final long f23632a = 20;
    private static final int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private static final int f23633c = 1;
    private static final int d = 2;
    public static int e;

    static {
        long maxMemory = Runtime.getRuntime().maxMemory();
        if (maxMemory <= STMobileHumanActionNative.ST_MOBILE_DETECT_EXTRA_FACE_POINTS) {
            e = 1;
        } else if (maxMemory >= STMobileHumanActionNative.ST_MOBILE_DETECT_EYEBALL_CONTOUR) {
            e = 2;
        } else {
            e = 0;
        }
    }

    public static double a(double d2, double d3, long j, long j2) {
        return ((d3 - d2) * (j2 / j)) + d2;
    }

    public static int a(float f) {
        int i = 1;
        while (true) {
            int i2 = i;
            int i3 = 2 << i2;
            if (i3 >= ((int) Math.ceil(f))) {
                return i3;
            }
            i = i2 + 1;
        }
    }

    public static int a(GL10 gl10, Bitmap bitmap) {
        int[] iArr = new int[1];
        gl10.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        gl10.glBindTexture(3553, i);
        gl10.glTexParameterf(3553, 10241, 9729.0f);
        gl10.glTexParameterf(3553, 10240, 9729.0f);
        GLUtils.texImage2D(3553, 0, bitmap, 0);
        return i;
    }

    public static Bitmap a(Bitmap bitmap) {
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
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        createBitmap.eraseColor(0);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public static FloatBuffer a(int i) {
        ByteBuffer allocateDirect;
        ByteBuffer.allocate(0);
        int i2 = i * 4;
        try {
            allocateDirect = ByteBuffer.allocateDirect(i2);
        } catch (OutOfMemoryError e2) {
            allocateDirect = ByteBuffer.allocateDirect(i2);
            e2.printStackTrace();
        }
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.rewind();
        return asFloatBuffer;
    }

    public static FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.rewind();
        return asFloatBuffer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r4.capacity() != r0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.FloatBuffer a(float[] r3, java.nio.FloatBuffer r4) {
        /*
            r0 = r3
            int r0 = r0.length
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L11
            r0 = r4
            r6 = r0
            r0 = r4
            int r0 = r0.capacity()
            r1 = r5
            if (r0 == r1) goto L16
        L11:
            r0 = r5
            java.nio.FloatBuffer r0 = a(r0)
            r6 = r0
        L16:
            r0 = r6
            r1 = r3
            java.nio.FloatBuffer r0 = r0.put(r1)
            r0 = r6
            java.nio.Buffer r0 = r0.rewind()
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.bc.a(float[], java.nio.FloatBuffer):java.nio.FloatBuffer");
    }

    public static ShortBuffer a(short[] sArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(sArr.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.put(sArr);
        asShortBuffer.rewind();
        return asShortBuffer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r4.capacity() != r0) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.ShortBuffer a(short[] r3, java.nio.ShortBuffer r4) {
        /*
            r0 = r3
            int r0 = r0.length
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L11
            r0 = r4
            r6 = r0
            r0 = r4
            int r0 = r0.capacity()
            r1 = r5
            if (r0 == r1) goto L16
        L11:
            r0 = r5
            java.nio.ShortBuffer r0 = b(r0)
            r6 = r0
        L16:
            r0 = r6
            r1 = r3
            java.nio.ShortBuffer r0 = r0.put(r1)
            r0 = r6
            java.nio.Buffer r0 = r0.rewind()
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.bc.a(short[], java.nio.ShortBuffer):java.nio.ShortBuffer");
    }

    public static boolean a() {
        return e == 1;
    }

    public static double b(double d2, double d3, long j, long j2) {
        double d4 = j2 / j;
        return ((d3 - d2) * d4 * d4) + d2;
    }

    public static ShortBuffer b(int i) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        asShortBuffer.rewind();
        return asShortBuffer;
    }

    public static double c(double d2, double d3, long j, long j2) {
        double d4 = j2 / j;
        double d5 = d4 * d4;
        double d6 = d5 * d5;
        return ((d3 - d2) * d6 * d6) + d2;
    }

    public static float[] c(int i) {
        return new float[]{((i >> 16) & 255) / 255.0f, ((i >> 8) & 255) / 255.0f, (i & 255) / 255.0f, ((i >> 24) & 255) / 255.0f};
    }

    public static double d(double d2, double d3, long j, long j2) {
        double d4 = j2 / j;
        return ((d3 - d2) * d4 * d4 * d4 * d4) + d2;
    }

    public static double e(double d2, double d3, long j, long j2) {
        double d4 = (j2 / j) - 1.0d;
        return ((d3 - d2) * (1.0d - (d4 * d4))) + d2;
    }

    public static double f(double d2, double d3, long j, long j2) {
        double d4 = (j2 / j) - 1.0d;
        double d5 = d4 * d4;
        double d6 = d5 * d5;
        return ((d3 - d2) * (1.0d - (d6 * d6))) + d2;
    }

    public static double g(double d2, double d3, long j, long j2) {
        double d4 = (j2 / j) - 1.0d;
        return ((d3 - d2) * (1.0d - (((d4 * d4) * d4) * d4))) + d2;
    }

    public static double h(double d2, double d3, long j, long j2) {
        double d4 = j2 / (j - 1);
        double d5 = d4 * d4;
        return ((d2 - d3) * (1.0d - (d5 * d5))) + d3;
    }
}

package com.qiniu.pili.droid.shortvideo.gl.texread;

import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/gl/texread/GlUtil.class */
public class GlUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final float[] f27722a;
    private static int b = 2;

    static {
        float[] fArr = new float[16];
        f27722a = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    public static int a(int i) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i2 = iArr[0];
        GLES20.glBindTexture(i, i2);
        GLES20.glTexParameterf(i, 10241, 9729.0f);
        GLES20.glTexParameterf(i, 10240, 9729.0f);
        GLES20.glTexParameterf(i, 10242, 33071.0f);
        GLES20.glTexParameterf(i, 10243, 33071.0f);
        a("generateTexture");
        return i2;
    }

    public static FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": GLES20 error: " + glGetError);
    }

    public static boolean a() {
        return b > 2;
    }

    public static int b(int i) {
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, iArr[0]);
        GLES20.glBufferData(GLES30.GL_PIXEL_PACK_BUFFER, i, null, GLES30.GL_DYNAMIC_READ);
        GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, 0);
        return iArr[0];
    }

    public static native void read(int i, int i2, int i3, int i4, int i5, int i6, int i7);
}

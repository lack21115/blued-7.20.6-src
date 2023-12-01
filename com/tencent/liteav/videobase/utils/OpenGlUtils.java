package com.tencent.liteav.videobase.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.opengl.EGL14;
import android.opengl.GLES11Ext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.n;
import com.tencent.liteav.videobase.base.GLConstants;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

@JNINamespace("liteav::video")
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/OpenGlUtils.class */
public class OpenGlUtils {
    private static final String TAG = "OpenGlUtils";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.liteav.videobase.utils.OpenGlUtils$1  reason: invalid class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/utils/OpenGlUtils$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f36649a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Rotation.values().length];
            f36649a = iArr;
            try {
                iArr[Rotation.ROTATION_90.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f36649a[Rotation.ROTATION_180.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f36649a[Rotation.ROTATION_270.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f36649a[Rotation.NORMAL.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    public static void attachTextureToFrameBuffer(int i, int i2) {
        GLES20.glBindFramebuffer(36160, i2);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    public static void bindFramebuffer(int i, int i2) {
        GLES20.glBindFramebuffer(i, i2);
    }

    public static void bindTexture(int i, int i2) {
        GLES20.glBindTexture(i, i2);
    }

    public static void checkGlError(String str) {
    }

    public static void convertYuvFormat(GLConstants.PixelFormatType pixelFormatType, Object obj, GLConstants.PixelFormatType pixelFormatType2, Object obj2, int i, int i2) {
        int value = pixelFormatType.getValue();
        int value2 = pixelFormatType2.getValue();
        boolean z = obj instanceof ByteBuffer;
        if ((z && (obj2 instanceof ByteBuffer)) ? nativeConvertYuvFormatBufferToBuffer(value, (ByteBuffer) obj, value2, (ByteBuffer) obj2, i, i2) : (z && (obj2 instanceof byte[])) ? nativeConvertYuvFormatBufferToArray(value, (ByteBuffer) obj, value2, (byte[]) obj2, i, i2) : ((obj instanceof byte[]) && (obj2 instanceof ByteBuffer)) ? nativeConvertYuvFormatArrayToBuffer(value, (byte[]) obj, value2, (ByteBuffer) obj2, i, i2) : nativeConvertYuvFormatArrayToArray(value, (byte[]) obj, value2, (byte[]) obj2, i, i2)) {
            return;
        }
        throw new IllegalArgumentException("Do not support " + pixelFormatType + " to " + pixelFormatType2);
    }

    public static FloatBuffer createNormalCubeVerticesBuffer() {
        return (FloatBuffer) ByteBuffer.allocateDirect(GLConstants.f36598c.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer().put(GLConstants.f36598c).position(0);
    }

    public static int createTexture(int i, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i4, 5121, null);
        return iArr[0];
    }

    public static FloatBuffer createTextureCoordsBuffer(Rotation rotation, boolean z, boolean z2) {
        float[] fArr = new float[GLConstants.d.length];
        initTextureCoordsBuffer(fArr, rotation, z, z2);
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(GLConstants.d.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }

    public static void deleteFrameBuffer(int i) {
        if (i != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
        }
    }

    public static void deleteShaderId(int i) {
        if (i != -1) {
            GLES20.glDeleteShader(i);
        }
    }

    public static void deleteTexture(int i) {
        if (i != -1) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
        }
    }

    public static void detachTextureFromFrameBuffer(int i) {
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, 0, 0);
        GLES20.glBindFramebuffer(36160, 0);
    }

    private static float flip(float f) {
        return f == 0.0f ? 1.0f : 0.0f;
    }

    public static int generateFrameBufferId() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    public static int generateTextureOES() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, iArr[0]);
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
        GLES20.glTexParameterf(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GLES11Ext.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        return iArr[0];
    }

    public static Object getCurrentContext() {
        return LiteavSystemInfo.getSystemOSVersionInt() >= 17 ? EGL14.eglGetCurrentContext() : ((EGL10) EGLContext.getEGL()).eglGetCurrentContext();
    }

    public static void glViewport(int i, int i2, int i3, int i4) {
        GLES20.glViewport(i, i2, i3, i4);
    }

    public static void initTextureCoordsBuffer(float[] fArr, Rotation rotation, boolean z, boolean z2) {
        float[] fArr2 = GLConstants.d;
        if (rotation != null) {
            int i = AnonymousClass1.f36649a[rotation.ordinal()];
            fArr2 = i != 1 ? i != 2 ? i != 3 ? GLConstants.d : GLConstants.e : GLConstants.g : GLConstants.f;
        }
        System.arraycopy((Object) fArr2, 0, (Object) fArr, 0, fArr2.length);
        if (z) {
            fArr[0] = flip(fArr[0]);
            fArr[2] = flip(fArr[2]);
            fArr[4] = flip(fArr[4]);
            fArr[6] = flip(fArr[6]);
        }
        if (z2) {
            fArr[1] = flip(fArr[1]);
            fArr[3] = flip(fArr[3]);
            fArr[5] = flip(fArr[5]);
            fArr[7] = flip(fArr[7]);
        }
    }

    public static int loadTexture(int i, Buffer buffer, int i2, int i3, int i4) {
        int[] iArr = new int[1];
        if (i4 == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
            bindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, i, i2, i3, 0, i, 5121, buffer);
        } else {
            bindTexture(3553, i4);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, i2, i3, i, 5121, buffer);
            iArr[0] = i4;
        }
        return iArr[0];
    }

    public static int loadTexture(Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            LiteavLog.d(TAG, "glGenTextures textureId: " + iArr[0]);
            bindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            bindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    public static void loadYuv420DataToTextures(ByteBuffer byteBuffer, int i, int i2, int i3, int[] iArr) {
        if (byteBuffer.isDirect()) {
            nativeLoadYuv420ByteBufferToTextures(byteBuffer, i, i2, i3, iArr);
        } else {
            nativeLoadYuv420ByteArrayToTextures(byteBuffer.array(), i, i2, i3, iArr);
        }
    }

    private static native boolean nativeConvertYuvFormatArrayToArray(int i, byte[] bArr, int i2, byte[] bArr2, int i3, int i4);

    private static native boolean nativeConvertYuvFormatArrayToBuffer(int i, byte[] bArr, int i2, ByteBuffer byteBuffer, int i3, int i4);

    private static native boolean nativeConvertYuvFormatBufferToArray(int i, ByteBuffer byteBuffer, int i2, byte[] bArr, int i3, int i4);

    private static native boolean nativeConvertYuvFormatBufferToBuffer(int i, ByteBuffer byteBuffer, int i2, ByteBuffer byteBuffer2, int i3, int i4);

    public static native void nativeCopyDataFromByteArrayToByteBuffer(byte[] bArr, ByteBuffer byteBuffer, int i);

    public static native void nativeCopyDataFromByteBufferToByteArray(ByteBuffer byteBuffer, byte[] bArr, int i);

    public static native void nativeCopyDataFromByteBufferToByteBuffer(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, int i);

    private static native void nativeLoadYuv420ByteArrayToTextures(byte[] bArr, int i, int i2, int i3, int[] iArr);

    private static native void nativeLoadYuv420ByteBufferToTextures(ByteBuffer byteBuffer, int i, int i2, int i3, int[] iArr);

    public static void readPixels(int i, int i2, int i3, int i4, Object obj) {
        if (obj instanceof Buffer) {
            Buffer buffer = (Buffer) obj;
            buffer.position(0);
            GLES20.glReadPixels(i, i2, i3, i4, 6408, 5121, buffer);
        } else if (obj instanceof byte[]) {
            GLES20.glReadPixels(i, i2, i3, i4, 6408, 5121, ByteBuffer.wrap((byte[]) obj));
        } else {
            LiteavLog.e(TAG, "read pixels failed due to unsupport object. ".concat(String.valueOf(obj)));
        }
    }

    public static Point reverseMappingPoint(GLConstants.GLScaleType gLScaleType, Rotation rotation, Point point, n nVar, n nVar2) {
        float f = (nVar2.f36340a * 1.0f) / nVar.f36340a;
        float f2 = (nVar2.b * 1.0f) / nVar.b;
        Matrix matrix = new Matrix();
        matrix.setTranslate((-nVar.f36340a) / 2.0f, (-nVar.b) / 2.0f);
        if (gLScaleType == GLConstants.GLScaleType.CENTER_CROP) {
            float min = Math.min(f, f2);
            matrix.postScale(min, min);
        } else if (gLScaleType == GLConstants.GLScaleType.FILL) {
            matrix.postScale(f, f2);
        } else if (gLScaleType == GLConstants.GLScaleType.FIT_CENTER) {
            float max = Math.max(f, f2);
            matrix.postScale(max, max);
        }
        matrix.postRotate(360 - rotation.mValue);
        if (rotation == Rotation.ROTATION_90 || rotation == Rotation.ROTATION_270) {
            matrix.postTranslate(nVar2.b / 2.0f, nVar2.f36340a / 2.0f);
        } else {
            matrix.postTranslate(nVar2.f36340a / 2.0f, nVar2.b / 2.0f);
        }
        float[] fArr = new float[2];
        matrix.mapPoints(fArr, new float[]{point.x, point.y});
        return new Point((int) fArr[0], (int) fArr[1]);
    }
}

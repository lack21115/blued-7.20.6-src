package com.qiniu.pili.droid.shortvideo.f;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Build;
import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/f/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f13982a = new Object();
    public static float[] b = {-1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f};

    /* renamed from: c  reason: collision with root package name */
    public static float[] f13983c = {0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    public static float[] d = {0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    public static float[] e = {1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f};
    public static final float[] f;
    private static int g = 2;

    static {
        float[] fArr = new float[16];
        f = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    private static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteShader(glCreateShader);
            Log.e("GLUtils", "Compilation of shader failed.");
            return 0;
        }
        return glCreateShader;
    }

    public static int a(Bitmap bitmap) {
        if (bitmap == null) {
            e.w.e("GLUtils", "loadTextureByBitmap，load bitmap error, check the file path is correct!");
            return 0;
        }
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        if (iArr[0] != 0) {
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameteri(3553, 10240, 9729);
            GLES20.glTexParameteri(3553, 10241, 9729);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        }
        if (iArr[0] == 0) {
            e.w.e("GLUtils", "loadTextureByBitmap, the texture id is 0!");
        }
        return iArr[0];
    }

    public static int a(String str, String str2) {
        int a2 = a((int) GLES20.GL_VERTEX_SHADER, str);
        int a3 = a((int) GLES20.GL_FRAGMENT_SHADER, str2);
        if (a2 == 0 || a3 == 0) {
            return -1;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glAttachShader(glCreateProgram, a3);
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, GLES20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] == 0) {
            GLES20.glDeleteProgram(glCreateProgram);
            Log.d("GLUtils", "Linking of program failed !");
            return -1;
        } else if (b(glCreateProgram)) {
            return glCreateProgram;
        } else {
            return -1;
        }
    }

    public static int a(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        a("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        a("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        a("loadImageTexture");
        return i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x011b, code lost:
        if (r0.getHeight() != r7) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap a(android.content.Context r4, android.net.Uri r5, int r6, int r7) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.pili.droid.shortvideo.f.d.a(android.content.Context, android.net.Uri, int, int):android.graphics.Bitmap");
    }

    private static Bitmap a(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float f2 = i / width;
        float f3 = i2 / height;
        android.graphics.Matrix matrix = new android.graphics.Matrix();
        matrix.postScale(f2, f3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        bitmap.recycle();
        return createBitmap;
    }

    public static com.qiniu.pili.droid.shortvideo.gl.c.g a(int i, int i2) {
        com.qiniu.pili.droid.shortvideo.gl.c.g gVar = new com.qiniu.pili.droid.shortvideo.gl.c.g();
        gVar.a(i, i2);
        gVar.b();
        return gVar;
    }

    public static boolean a() {
        return g > 2;
    }

    public static boolean a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            Log.e("GLUtils", str + ": glError 0x" + Integer.toHexString(glGetError));
            return false;
        }
        return true;
    }

    public static int[] a(int i) {
        int[] iArr = new int[i];
        GLES20.glGenTextures(i, iArr, 0);
        return iArr;
    }

    public static com.qiniu.pili.droid.shortvideo.gl.c.g b(int i, int i2) {
        com.qiniu.pili.droid.shortvideo.gl.c.g gVar = new com.qiniu.pili.droid.shortvideo.gl.c.g();
        gVar.a(i, i2);
        gVar.b();
        return gVar;
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 17) {
            try {
                EGL14.eglGetCurrentContext();
                return true;
            } catch (NoClassDefFoundError e2) {
                Log.i("GLUtils", "EGL14 isn't supported on this platform, change to use EGL10.");
                return false;
            }
        }
        return false;
    }

    private static boolean b(int i) {
        GLES20.glValidateProgram(i);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(i, GLES20.GL_VALIDATE_STATUS, iArr, 0);
        Log.d("GLUtils", "Results of validating program: " + iArr[0] + "\nLog:" + GLES20.glGetProgramInfoLog(i));
        return iArr[0] != 0;
    }

    public static int c() {
        return a(1)[0];
    }

    public static int d() {
        int[] iArr = new int[1];
        GLES30.glGenVertexArrays(1, iArr, 0);
        return iArr[0];
    }

    public static int e() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }
}

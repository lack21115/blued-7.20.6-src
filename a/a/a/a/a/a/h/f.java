package a.a.a.a.a.a.h;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.Matrix;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/a/h/f.class */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static int f1238a = 2;
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static final float[] f1239c;
    public static Object d;

    static {
        float[] fArr = new float[16];
        f1239c = fArr;
        Matrix.setIdentityM(fArr, 0);
        d = new Object();
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

    public static int a(int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GLES20.glBindRenderbuffer(36161, iArr[0]);
        GLES20.glRenderbufferStorage(36161, i, i2, i3);
        GLES20.glBindRenderbuffer(36161, 0);
        int i4 = 0;
        if (b("glRenderbufferStorage " + iArr[0])) {
            i4 = iArr[0];
        }
        return i4;
    }

    public static int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        b("glCreateShader type=" + i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        int i2 = glCreateShader;
        if (iArr[0] == 0) {
            a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f1361c;
            eVar.e("GlUtil", "Could not compile shader " + i + ":");
            a.a.a.a.a.e.e eVar2 = a.a.a.a.a.e.e.f1361c;
            eVar2.e("GlUtil", " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
            i2 = 0;
        }
        return i2;
    }

    public static int a(String str, String str2) {
        int a2;
        int a3 = a((int) GLES20.GL_VERTEX_SHADER, str);
        if (a3 == 0 || (a2 = a((int) GLES20.GL_FRAGMENT_SHADER, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        b("glCreateProgram");
        if (glCreateProgram == 0) {
            a.a.a.a.a.e.e.f1361c.e("GlUtil", "Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, a3);
        b("glAttachShader");
        GLES20.glAttachShader(glCreateProgram, a2);
        b("glAttachShader");
        GLES20.glLinkProgram(glCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(glCreateProgram, GLES20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] != 1) {
            a.a.a.a.a.e.e.f1361c.e("GlUtil", "Could not link program: ");
            a.a.a.a.a.e.e.f1361c.e("GlUtil", GLES20.glGetProgramInfoLog(glCreateProgram));
            GLES20.glDeleteProgram(glCreateProgram);
            return 0;
        }
        return glCreateProgram;
    }

    public static int a(ByteBuffer byteBuffer, int i, int i2, int i3) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i4 = iArr[0];
        b("glGenTextures");
        GLES20.glBindTexture(3553, i4);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameterf(3553, 10242, 33071.0f);
        GLES20.glTexParameterf(3553, 10243, 33071.0f);
        b("loadImageTexture");
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i3, 5121, byteBuffer);
        b("loadImageTexture");
        return i4;
    }

    public static FloatBuffer a(float[] fArr) {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        return asFloatBuffer;
    }

    public static void a(Context context) {
        ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo();
        if (deviceConfigurationInfo != null && deviceConfigurationInfo.reqGlEsVersion >= 196608) {
            try {
                f1238a = 7938;
                a.a.a.a.a.e.e.f1361c.a("GlUtil", "In case of java code optimization");
                f1238a = 3;
                b = true;
            } catch (NoClassDefFoundError e) {
                a.a.a.a.a.e.e.f1361c.d("GlUtil", "System said it is 3.0, but it is not !!!");
            }
        }
        a.a.a.a.a.e.e eVar = a.a.a.a.a.e.e.f1361c;
        eVar.c("GlUtil", "GL info, version:" + f1238a + ", supports rg ext:" + b);
    }

    public static void a(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        throw new RuntimeException(str + ": GLES20 error: " + glGetError);
    }

    public static boolean a() {
        return b;
    }

    public static int b(int i) {
        int[] iArr = new int[1];
        GLES20.glGenBuffers(1, iArr, 0);
        GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, iArr[0]);
        GLES20.glBufferData(GLES30.GL_PIXEL_PACK_BUFFER, i, null, GLES30.GL_DYNAMIC_READ);
        GLES20.glBindBuffer(GLES30.GL_PIXEL_PACK_BUFFER, 0);
        int i2 = 0;
        if (b("glBufferData " + iArr[0])) {
            i2 = iArr[0];
        }
        return i2;
    }

    public static boolean b() {
        return f1238a > 2;
    }

    public static boolean b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            a.a.a.a.a.e.e.f1361c.e("GlUtil", str + ": glError 0x" + Integer.toHexString(glGetError));
            return false;
        }
        return true;
    }

    public static int c() {
        int[] iArr = new int[1];
        GLES20.glGenFramebuffers(1, iArr, 0);
        return iArr[0];
    }

    public static int d() {
        int[] iArr = new int[1];
        GLES30.glGenVertexArrays(1, iArr, 0);
        return iArr[0];
    }

    public static int e() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }
}

package a.a.a.a.a.b.i;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* loaded from: source-8756600-dex2jar.jar:a/a/a/a/a/b/i/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f1269a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f1270c;

    public b(String str, String str2) {
        this.f1269a = a(GLES20.GL_VERTEX_SHADER, str);
        this.b = a(GLES20.GL_FRAGMENT_SHADER, str2);
        int glCreateProgram = GLES20.glCreateProgram();
        this.f1270c = glCreateProgram;
        if (glCreateProgram == 0) {
            throw new RuntimeException("Could not create program");
        }
        GLES20.glAttachShader(glCreateProgram, this.f1269a);
        GLES20.glAttachShader(this.f1270c, this.b);
        GLES20.glLinkProgram(this.f1270c);
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.f1270c, GLES20.GL_LINK_STATUS, iArr, 0);
        if (iArr[0] != 1) {
            throw new RuntimeException(GLES20.glGetProgramInfoLog(this.f1270c));
        }
        a.a.a.a.a.a.h.f.a("Creating GlShader");
    }

    public static int a(int i, String str) {
        int[] iArr = {0};
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
        if (iArr[0] == 1) {
            a.a.a.a.a.a.h.f.a("compileShader");
            return glCreateShader;
        }
        throw new RuntimeException(GLES20.glGetShaderInfoLog(glCreateShader));
    }

    public int a(String str) {
        int i = this.f1270c;
        if (i != -1) {
            int glGetAttribLocation = GLES20.glGetAttribLocation(i, str);
            if (glGetAttribLocation >= 0) {
                return glGetAttribLocation;
            }
            throw new RuntimeException("Could not locate '" + str + "' in program");
        }
        throw new RuntimeException("The program has been released");
    }

    public void a() {
        int i = this.f1270c;
        if (i == -1) {
            throw new RuntimeException("The program has been released");
        }
        GLES20.glUseProgram(i);
        a.a.a.a.a.a.h.f.a("glUseProgram");
    }

    public void a(String str, int i, FloatBuffer floatBuffer) {
        if (this.f1270c == -1) {
            throw new RuntimeException("The program has been released");
        }
        int a2 = a(str);
        GLES20.glEnableVertexAttribArray(a2);
        GLES20.glVertexAttribPointer(a2, i, 5126, false, 0, (Buffer) floatBuffer);
        a.a.a.a.a.a.h.f.a("setVertexAttribArray");
    }

    public int b(String str) {
        int i = this.f1270c;
        if (i != -1) {
            int glGetUniformLocation = GLES20.glGetUniformLocation(i, str);
            if (glGetUniformLocation >= 0) {
                return glGetUniformLocation;
            }
            throw new RuntimeException("Could not locate uniform '" + str + "' in program");
        }
        throw new RuntimeException("The program has been released");
    }

    public void b() {
        int i = this.f1269a;
        if (i != -1) {
            GLES20.glDeleteShader(i);
            this.f1269a = -1;
        }
        int i2 = this.b;
        if (i2 != -1) {
            GLES20.glDeleteShader(i2);
            this.b = -1;
        }
        int i3 = this.f1270c;
        if (i3 != -1) {
            GLES20.glDeleteProgram(i3);
            this.f1270c = -1;
        }
    }
}

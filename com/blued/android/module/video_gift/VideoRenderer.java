package com.blued.android.module.video_gift;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import android.view.Surface;
import com.blued.android.module.video_gift.GLTextureView;
import com.uc.crashsdk.export.LogType;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Locale;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/VideoRenderer.class */
public class VideoRenderer implements SurfaceTexture.OnFrameAvailableListener, GLTextureView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    private static String f16097a = "VideoRender";
    private static int r = 36197;
    private final float[] b;

    /* renamed from: c  reason: collision with root package name */
    private FloatBuffer f16098c;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private SurfaceTexture p;
    private OnSurfacePrepareListener s;
    private boolean t;
    private final String d = "uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n";
    private final String e = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";
    private double f = 0.95d;
    private String g = "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n";
    private float[] h = new float[16];
    private float[] i = new float[16];
    private boolean q = false;
    private float u = 0.0f;
    private float v = 1.0f;
    private float w = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/video_gift/VideoRenderer$OnSurfacePrepareListener.class */
    public interface OnSurfacePrepareListener {
        void a(Surface surface);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoRenderer() {
        float[] fArr = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
        this.b = fArr;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f16098c = asFloatBuffer;
        asFloatBuffer.put(this.b).position(0);
        Matrix.setIdentityM(this.i, 0);
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        int i2 = glCreateShader;
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, GLES20.GL_COMPILE_STATUS, iArr, 0);
            i2 = glCreateShader;
            if (iArr[0] == 0) {
                String str2 = f16097a;
                Log.e(str2, "Could not compile shader " + i + ":");
                Log.e(f16097a, GLES20.glGetShaderInfoLog(glCreateShader));
                GLES20.glDeleteShader(glCreateShader);
                i2 = 0;
            }
        }
        return i2;
    }

    private int a(String str, String str2) {
        int a2;
        int a3 = a(GLES20.GL_VERTEX_SHADER, str);
        if (a3 == 0 || (a2 = a(GLES20.GL_FRAGMENT_SHADER, str2)) == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a3);
            b("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
            b("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, GLES20.GL_LINK_STATUS, iArr, 0);
            if (iArr[0] != 1) {
                Log.e(f16097a, "Could not link program: ");
                Log.e(f16097a, GLES20.glGetProgramInfoLog(glCreateProgram));
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    private void a() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i = iArr[0];
        this.k = i;
        GLES20.glBindTexture(r, i);
        b("glBindTexture textureID");
        GLES20.glTexParameterf(r, 10241, 9728.0f);
        GLES20.glTexParameterf(r, 10240, 9729.0f);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.k);
        this.p = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.s.a(new Surface(this.p));
        synchronized (this) {
            this.q = false;
        }
    }

    private String b() {
        return this.t ? this.g : String.format(Locale.ENGLISH, "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvarying mediump float text_alpha_out;\nvoid main() {\n  vec4 color = texture2D(sTexture, vTextureCoord);\n  float red = %f;\n  float green = %f;\n  float blue = %f;\n  float accuracy = %f;\n  if (abs(color.r - red) <= accuracy && abs(color.g - green) <= accuracy && abs(color.b - blue) <= accuracy) {\n      gl_FragColor = vec4(color.r, color.g, color.b, 0.0);\n  } else {\n      gl_FragColor = vec4(color.r, color.g, color.b, 1.0);\n  }\n}\n", Float.valueOf(this.u), Float.valueOf(this.v), Float.valueOf(this.w), Double.valueOf(1.0d - this.f));
    }

    private void b(String str) {
        int glGetError = GLES20.glGetError();
        if (glGetError == 0) {
            return;
        }
        String str2 = f16097a;
        Log.e(str2, str + ": glError " + glGetError);
        throw new RuntimeException(str + ": glError " + glGetError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(OnSurfacePrepareListener onSurfacePrepareListener) {
        this.s = onSurfacePrepareListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        this.t = true;
        this.g = str;
    }

    @Override // com.blued.android.module.video_gift.GLTextureView.Renderer
    public void a(GL10 gl10) {
        synchronized (this) {
            if (this.q) {
                this.p.updateTexImage();
                this.p.getTransformMatrix(this.i);
                this.q = false;
            }
        }
        GLES20.glClear(LogType.UNEXP_RESTART);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glUseProgram(this.j);
        b("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(r, this.k);
        this.f16098c.position(0);
        GLES20.glVertexAttribPointer(this.n, 3, 5126, false, 20, (Buffer) this.f16098c);
        b("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.n);
        b("glEnableVertexAttribArray aPositionHandle");
        this.f16098c.position(3);
        GLES20.glVertexAttribPointer(this.o, 3, 5126, false, 20, (Buffer) this.f16098c);
        b("glVertexAttribPointer aTextureHandle");
        GLES20.glEnableVertexAttribArray(this.o);
        b("glEnableVertexAttribArray aTextureHandle");
        Matrix.setIdentityM(this.h, 0);
        GLES20.glUniformMatrix4fv(this.l, 1, false, this.h, 0);
        GLES20.glUniformMatrix4fv(this.m, 1, false, this.i, 0);
        GLES20.glDrawArrays(5, 0, 4);
        b("glDrawArrays");
        GLES20.glFinish();
    }

    @Override // com.blued.android.module.video_gift.GLTextureView.Renderer
    public void a(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
    }

    @Override // com.blued.android.module.video_gift.GLTextureView.Renderer
    public void a(GL10 gl10, EGLConfig eGLConfig) {
        int a2 = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", b());
        this.j = a2;
        if (a2 == 0) {
            return;
        }
        this.n = GLES20.glGetAttribLocation(a2, "aPosition");
        b("glGetAttribLocation aPosition");
        if (this.n == -1) {
            throw new RuntimeException("Could not get attrib location for aPosition");
        }
        this.o = GLES20.glGetAttribLocation(this.j, "aTextureCoord");
        b("glGetAttribLocation aTextureCoord");
        if (this.o == -1) {
            throw new RuntimeException("Could not get attrib location for aTextureCoord");
        }
        this.l = GLES20.glGetUniformLocation(this.j, "uMVPMatrix");
        b("glGetUniformLocation uMVPMatrix");
        if (this.l == -1) {
            throw new RuntimeException("Could not get attrib location for uMVPMatrix");
        }
        this.m = GLES20.glGetUniformLocation(this.j, "uSTMatrix");
        b("glGetUniformLocation uSTMatrix");
        if (this.m == -1) {
            throw new RuntimeException("Could not get attrib location for uSTMatrix");
        }
        a();
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this) {
            this.q = true;
        }
    }
}

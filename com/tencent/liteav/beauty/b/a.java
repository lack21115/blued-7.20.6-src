package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/a.class */
public final class a extends com.tencent.liteav.videobase.a.b implements b {
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;

    /* renamed from: a  reason: collision with root package name */
    private final FloatBuffer f36352a = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final FloatBuffer b = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* renamed from: c  reason: collision with root package name */
    private final e f36353c = new e();
    private final C0928a d = new C0928a();
    private final m e = new m();

    /* renamed from: com.tencent.liteav.beauty.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/a$a.class */
    public static final class C0928a extends com.tencent.liteav.videobase.c.c {

        /* renamed from: a  reason: collision with root package name */
        int f36355a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        int f36356c;

        public C0928a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
            this.f36355a = -1;
            this.b = -1;
            this.f36356c = -1;
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final int buildProgram() {
            return NativeLoad.nativeLoadGLProgram(1);
        }

        @Override // com.tencent.liteav.videobase.c.c, com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
        public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
            super.onInit(eVar);
            this.f36355a = GLES20.glGetUniformLocation(getProgramId(), "smoothDegree");
            this.b = GLES20.glGetUniformLocation(getProgramId(), "brightDegree");
            this.f36356c = GLES20.glGetUniformLocation(getProgramId(), "ruddyDegree");
        }
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void a(float f) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        this.f = f;
        C0928a c0928a = this.d;
        int i = c0928a.f36355a;
        if (f > 1.0f) {
            double d = f;
            if (d < 2.5d) {
                f4 = (f - 1.0f) / 1.5f;
                f6 = 3.1f;
                f5 = 1.0f;
            } else if (f < 4.0f) {
                f5 = 4.1f;
                f7 = ((f - 2.5f) / 1.5f) * 1.5f;
                f3 = f7 + f5;
                f2 = f3 / 10.0f;
            } else if (d < 5.5d) {
                f4 = (f - 4.0f) / 1.5f;
                f5 = 5.6f;
                f6 = 1.2000003f;
            } else {
                f3 = f;
                if (d <= 7.0d) {
                    f4 = (f - 5.5f) / 1.5f;
                    f5 = 6.8f;
                    f6 = 0.19999981f;
                }
                f2 = f3 / 10.0f;
            }
            f7 = f4 * f6;
            f3 = f7 + f5;
            f2 = f3 / 10.0f;
        } else {
            f2 = 0.1f;
        }
        c0928a.setFloatOnDraw(i, f2);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void b(float f) {
        this.g = f;
        C0928a c0928a = this.d;
        c0928a.setFloatOnDraw(c0928a.b, f / 3.0f);
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void c(float f) {
        this.h = f;
        C0928a c0928a = this.d;
        c0928a.setFloatOnDraw(c0928a.f36356c, (f / 10.0f) / 2.0f);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final boolean canBeSkipped() {
        return this.f <= 0.0f && this.g <= 0.0f && this.h <= 0.0f && this.i <= 0.0f;
    }

    @Override // com.tencent.liteav.beauty.b.b
    public final void d(float f) {
        float f2 = f / 1.5f;
        this.i = f2;
        this.e.a(f2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int i2;
        FloatBuffer floatBuffer3;
        com.tencent.liteav.videobase.frame.d dVar2;
        int a2;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            com.tencent.liteav.videobase.frame.d dVar3 = null;
            if (this.f > 0.0f || this.g > 0.0f || this.h > 0.0f) {
                if (this.f != 0.0f) {
                    com.tencent.liteav.videobase.frame.d a3 = this.mTexturePool.a(this.mOutputSize.f36340a, this.mOutputSize.b);
                    this.f36353c.onDraw(i, a3, floatBuffer, floatBuffer2);
                    i2 = a3.a();
                    FloatBuffer floatBuffer4 = this.f36352a;
                    floatBuffer2 = this.b;
                    dVar2 = a3;
                    floatBuffer3 = floatBuffer4;
                } else {
                    i2 = i;
                    floatBuffer3 = floatBuffer;
                    dVar2 = null;
                }
                com.tencent.liteav.videobase.frame.d a4 = this.mTexturePool.a(this.mOutputSize.f36340a, this.mOutputSize.b);
                this.d.setSecondInputTexture(i);
                if (this.i > 0.0f) {
                    this.d.onDraw(i2, a4, floatBuffer3, floatBuffer2);
                } else {
                    this.d.onDraw(i2, dVar, floatBuffer3, floatBuffer2);
                }
                a2 = a4.a();
                FloatBuffer floatBuffer5 = this.f36352a;
                floatBuffer2 = this.b;
                if (dVar2 != null) {
                    dVar2.release();
                }
                dVar3 = a4;
                floatBuffer = floatBuffer5;
            } else {
                a2 = i;
            }
            if (this.i > 0.0f || a2 == i) {
                this.e.onDraw(a2, dVar, floatBuffer, floatBuffer2);
            }
            if (dVar3 != null) {
                dVar3.release();
            }
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f36353c.initialize(eVar);
        this.d.initialize(eVar);
        this.e.initialize(eVar);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        this.d.onOutputSizeChanged(i, i2);
        this.f36353c.onOutputSizeChanged(i, i2);
        this.e.onOutputSizeChanged(i, i2);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        this.d.uninitialize();
        this.f36353c.uninitialize();
        this.e.uninitialize();
    }
}

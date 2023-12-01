package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.Rotation;
import java.nio.FloatBuffer;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/e.class */
public final class e extends com.tencent.liteav.videobase.a.b {
    private int i;
    private int j;
    private boolean k;
    private float h = 4.0f;

    /* renamed from: a  reason: collision with root package name */
    private final FloatBuffer f22685a = OpenGlUtils.createNormalCubeVerticesBuffer();
    private final FloatBuffer b = OpenGlUtils.createTextureCoordsBuffer(Rotation.NORMAL, false, false);

    /* renamed from: c  reason: collision with root package name */
    private final com.tencent.liteav.beauty.b.c f22686c = new com.tencent.liteav.beauty.b.c();
    private final c e = new c();
    private final a f = new a("precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);\n}\n");
    private final b g = new b("precision highp float;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\nvoid main()\n{\n    gl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);\n}\n");
    private final com.tencent.liteav.videobase.a.b d = new com.tencent.liteav.videobase.a.b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/e$a.class */
    public static final class a extends com.tencent.liteav.videobase.c.d {
        public a(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/e$b.class */
    public static final class b extends com.tencent.liteav.videobase.c.c {
        public b(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/e$c.class */
    public static final class c extends com.tencent.liteav.videobase.c.d {

        /* renamed from: a  reason: collision with root package name */
        private int f22687a;
        private int b;

        public c() {
            super(null, null);
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final int buildProgram() {
            return NativeLoad.nativeLoadGLProgram(2);
        }

        @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
        public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
            super.onInit(eVar);
            this.f22687a = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
            this.b = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final void onOutputSizeChanged(int i, int i2) {
            super.onOutputSizeChanged(i, i2);
            setFloatOnDraw(this.f22687a, 1.5f / this.mOutputSize.f22649a);
            setFloatOnDraw(this.b, 1.5f / this.mOutputSize.b);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onDraw(int i, com.tencent.liteav.videobase.frame.d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        int a2;
        com.tencent.liteav.videobase.frame.d dVar2;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (this.i == this.mOutputSize.f22649a && this.j == this.mOutputSize.b) {
                a2 = i;
                dVar2 = null;
            } else {
                com.tencent.liteav.videobase.frame.d a3 = this.mTexturePool.a(this.i, this.j);
                GLES20.glViewport(0, 0, this.i, this.j);
                this.d.onDraw(i, a3, floatBuffer, floatBuffer2);
                a2 = a3.a();
                dVar2 = a3;
            }
            com.tencent.liteav.videobase.frame.d a4 = this.mTexturePool.a(this.i, this.j);
            com.tencent.liteav.videobase.frame.d a5 = this.mTexturePool.a(this.i, this.j);
            this.f22686c.onDraw(a2, a4, this.f22685a, this.b);
            this.e.setSecondInputTexture(a4.a());
            this.e.onDraw(a2, a5, this.f22685a, this.b);
            if (dVar2 != null) {
                dVar2.release();
            }
            com.tencent.liteav.videobase.frame.d a6 = this.mTexturePool.a(this.i, this.j);
            this.f.setSecondInputTexture(a4.a());
            this.f.onDraw(a5.a(), a6, this.f22685a, this.b);
            a4.release();
            com.tencent.liteav.videobase.frame.d a7 = this.mTexturePool.a(this.i, this.j);
            this.f22686c.onDraw(a5.a(), a7, this.f22685a, this.b);
            a5.release();
            com.tencent.liteav.videobase.frame.d a8 = this.mTexturePool.a(this.i, this.j);
            this.f22686c.onDraw(a6.a(), a8, this.f22685a, this.b);
            a6.release();
            if (this.h != 1.0f) {
                com.tencent.liteav.videobase.frame.d a9 = this.mTexturePool.a(this.mOutputSize.f22649a, this.mOutputSize.b);
                com.tencent.liteav.videobase.frame.d a10 = this.mTexturePool.a(this.mOutputSize.f22649a, this.mOutputSize.b);
                GLES20.glViewport(0, 0, this.mOutputSize.f22649a, this.mOutputSize.b);
                this.d.onDraw(a7.a(), a9, this.f22685a, this.b);
                this.d.onDraw(a8.a(), a10, this.f22685a, this.b);
                this.g.setSecondInputTexture(a10.a());
                this.g.setInputTexture(com.tencent.liteav.videobase.a.j.THIRD_INPUT_SAMPLE2D_NAME, i);
                this.g.onDraw(a9.a(), dVar, this.f22685a, this.b);
                a9.release();
                a10.release();
            } else {
                this.g.setSecondInputTexture(a8.a());
                this.g.setInputTexture(com.tencent.liteav.videobase.a.j.THIRD_INPUT_SAMPLE2D_NAME, i);
                this.g.onDraw(a7.a(), dVar, this.f22685a, this.b);
            }
            a8.release();
            a7.release();
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f22686c.initialize(eVar);
        this.e.initialize(eVar);
        this.f.initialize(eVar);
        this.g.initialize(eVar);
        this.d.initialize(eVar);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        if (!this.k) {
            if (i < i2) {
                if (i < 540) {
                    this.h = 1.0f;
                } else {
                    this.h = 4.0f;
                }
            } else if (i2 < 540) {
                this.h = 1.0f;
            } else {
                this.h = 4.0f;
            }
        }
        if (Float.compare(this.h, 1.0f) == 0) {
            this.i = i;
            this.j = i2;
        } else {
            float f = this.h;
            this.i = (int) (i / f);
            this.j = (int) (i2 / f);
        }
        this.d.onOutputSizeChanged(this.i, this.j);
        this.e.onOutputSizeChanged(this.i, this.j);
        this.f.onOutputSizeChanged(this.i, this.j);
        this.g.onOutputSizeChanged(i, i2);
        this.f22686c.onOutputSizeChanged(this.i, this.j);
    }

    @Override // com.tencent.liteav.videobase.a.b
    public final void onUninit() {
        super.onUninit();
        this.f22686c.uninitialize();
        this.e.uninitialize();
        this.f.uninitialize();
        this.g.uninitialize();
        this.d.uninitialize();
    }
}

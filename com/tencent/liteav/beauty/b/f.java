package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/f.class */
public final class f extends com.tencent.liteav.videobase.a.h {

    /* renamed from: a  reason: collision with root package name */
    public final a f36379a;
    public final a b;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/f$a.class */
    public static final class a extends com.tencent.liteav.videobase.a.b {

        /* renamed from: a  reason: collision with root package name */
        int f36380a;
        int b;

        /* renamed from: c  reason: collision with root package name */
        float f36381c;
        float d;

        public a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n\nconst int GAUSSIAN_SAMPLES = 9;\n\nuniform float texelWidthOffset;\nuniform float texelHeightOffset;\n\nvarying vec2 textureCoordinate;\nvarying vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n gl_Position = position;\n textureCoordinate = inputTextureCoordinate.xy;\n \n // Calculate the positions for the blur\n int multiplier = 0;\n vec2 blurStep;\n   vec2 singleStepOffset = vec2(texelHeightOffset, texelWidthOffset);\n    \n for (int i = 0; i < GAUSSIAN_SAMPLES; i++)\n   {\n  multiplier = (i - ((GAUSSIAN_SAMPLES - 1) / 2));\n       // Blur in x (horizontal)\n       blurStep = float(multiplier) * singleStepOffset;\n  blurCoordinates[i] = inputTextureCoordinate.xy + blurStep;\n }\n}\n", "uniform sampler2D inputImageTexture;\n\nconst lowp int GAUSSIAN_SAMPLES = 9;\n\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 blurCoordinates[GAUSSIAN_SAMPLES];\n\nvoid main()\n{\n lowp vec3 sum = vec3(0.0);\n   lowp vec4 fragColor=texture2D(inputImageTexture,textureCoordinate);\n \n    sum += texture2D(inputImageTexture, blurCoordinates[0]).rgb * 0.05;\n    sum += texture2D(inputImageTexture, blurCoordinates[1]).rgb * 0.09;\n    sum += texture2D(inputImageTexture, blurCoordinates[2]).rgb * 0.12;\n    sum += texture2D(inputImageTexture, blurCoordinates[3]).rgb * 0.15;\n    sum += texture2D(inputImageTexture, blurCoordinates[4]).rgb * 0.18;\n    sum += texture2D(inputImageTexture, blurCoordinates[5]).rgb * 0.15;\n    sum += texture2D(inputImageTexture, blurCoordinates[6]).rgb * 0.12;\n    sum += texture2D(inputImageTexture, blurCoordinates[7]).rgb * 0.09;\n    sum += texture2D(inputImageTexture, blurCoordinates[8]).rgb * 0.05;\n\n gl_FragColor = vec4(sum,fragColor.a);\n}");
        }

        private void a() {
            runOnDraw(g.a(this));
        }

        public final void a(float f, float f2) {
            this.f36381c = f;
            this.d = f2;
            a();
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
            super.onInit(eVar);
            this.f36380a = GLES20.glGetUniformLocation(getProgramId(), "texelWidthOffset");
            this.b = GLES20.glGetUniformLocation(getProgramId(), "texelHeightOffset");
        }

        @Override // com.tencent.liteav.videobase.a.b
        public final void onOutputSizeChanged(int i, int i2) {
            super.onOutputSizeChanged(i, i2);
            a();
        }
    }

    public f() {
        this(1.0f);
    }

    public f(float f) {
        this.f36379a = new a();
        this.b = new a();
        this.f36379a.a(f, 0.0f);
        this.b.a(0.0f, f);
        addFilter(this.f36379a);
        addFilter(this.b);
    }
}

package com.tencent.liteav.videobase.d;

import android.opengl.GLES20;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/videobase/d/a.class */
public final class a extends i {

    /* renamed from: a  reason: collision with root package name */
    private static final float[] f22929a = {-0.0627451f, -0.5019608f, -0.5019608f};
    private static final float[] b = {1.1644f, 1.1644f, 1.1644f, 0.0f, -0.3918f, 2.0172f, 1.596f, -0.813f, 0.0f};

    /* renamed from: c  reason: collision with root package name */
    private int f22930c;
    private int d;

    public a() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, "precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nuniform sampler2D uvTexture;\nuniform mat3 convertMatrix;\nuniform vec3 offset;\n\nvoid main()\n{\n    highp vec3 yuvColor;\n    highp vec3 rgbColor;\n\n    // Get the YUV values\n    yuvColor.x = texture2D(inputImageTexture, textureCoordinate).r;\n    yuvColor.y = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5)).r;\n    yuvColor.z = texture2D(uvTexture, vec2(textureCoordinate.x, textureCoordinate.y * 0.5 + 0.5)).r;\n\n    // Do the color transform\n    yuvColor += offset;\n    rgbColor = convertMatrix * yuvColor;\n\n    gl_FragColor = vec4(rgbColor, 1.0);\n}");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(a aVar) {
        GLES20.glUniform3fv(aVar.d, 1, f22929a, 0);
        GLES20.glUniformMatrix3fv(aVar.f22930c, 1, false, b, 0);
    }

    @Override // com.tencent.liteav.videobase.d.i
    protected final int a() {
        return 6409;
    }

    @Override // com.tencent.liteav.videobase.d.i, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.f22930c = GLES20.glGetUniformLocation(getProgramId(), "convertMatrix");
        this.d = GLES20.glGetUniformLocation(getProgramId(), "offset");
        runOnDraw(b.a(this));
    }
}

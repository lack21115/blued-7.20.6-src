package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.opos.mobad.activity.VideoActivity;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/beauty/b/d.class */
public final class d extends com.tencent.liteav.videobase.c.c {

    /* renamed from: a  reason: collision with root package name */
    int f22683a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f22684c;
    private int d;
    private float[] e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d() {
        super("precision mediump float;\nvarying highp vec2 textureCoordinate;\nvarying highp vec2 textureCoordinate2;\nvarying highp vec2 textureCoordinate3;\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform sampler2D inputImageTexture3;\nuniform mediump vec3 screenReplaceColor; //YUV数据\nuniform float screenMirrorX;\nuniform float screenMirrorY;\n\nvoid main()\n{\n    highp vec4 _smooth = texture2D(inputImageTexture,textureCoordinate);\n    highp vec4 origin = texture2D(inputImageTexture2,textureCoordinate2);\n    \n    lowp float r = origin.r;\n    lowp float g = origin.g;\n    lowp float b = origin.b;\n    float Cr = 128.0 - 37.797 * r - 74.203 * g + 112.0 * b;\n    float Cb = 128.0 + 112.0 * r - 93.768 * g - 18.214 * b;\n    \n    highp vec2 screenPos = textureCoordinate3;\n    if(screenMirrorX != 0.0)screenPos.x = 1.0 - screenPos.x;\n    if(screenMirrorY != 0.0)screenPos.y = 1.0 - screenPos.y;\n    highp vec4 screen = texture2D(inputImageTexture3, screenPos);\n    float Y = 0.2989 * r + 0.5866 * g + 0.1145 * b;\n    Cr = 0.7132 * (r - Y);\n    Cb = 0.5647 * (b - Y);\n    float blendValue = 1.0 - smoothstep(0.4, 0.4 + 0.1, distance(vec2(Cr, Cb), vec2(screenReplaceColor.g, screenReplaceColor.b)));\n    vec3 diff = screen.rgb - _smooth.rgb;\n    _smooth.rgb = _smooth.rgb + blendValue * diff;\n    gl_FragColor = _smooth;\n}\n");
        this.b = -1;
        this.f22684c = -1;
        this.f22683a = -1;
        this.d = -1;
        this.e = new float[]{0.0f, 1.0f, 0.0f};
    }

    @Override // com.tencent.liteav.videobase.c.c, com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
    public final void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        super.onInit(eVar);
        this.b = GLES20.glGetUniformLocation(getProgramId(), VideoActivity.EXTRA_KEY_SCREEN_MODE);
        this.f22684c = GLES20.glGetUniformLocation(getProgramId(), "screenReplaceColor");
        this.f22683a = GLES20.glGetUniformLocation(getProgramId(), "screenMirrorX");
        this.d = GLES20.glGetUniformLocation(getProgramId(), "screenMirrorY");
        float[] fArr = this.e;
        float[] fArr2 = {(float) ((fArr[0] * 0.2989d) + (fArr[1] * 0.5866d) + (fArr[2] * 0.1145d)), (float) ((fArr[0] - fArr2[0]) * 0.7132d), (float) ((fArr[2] - fArr2[0]) * 0.5647d)};
        setFloatVec3OnDraw(this.f22684c, fArr2);
    }
}

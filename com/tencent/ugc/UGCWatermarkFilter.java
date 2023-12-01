package com.tencent.ugc;

import android.opengl.GLES20;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/UGCWatermarkFilter.class */
public class UGCWatermarkFilter extends com.tencent.liteav.beauty.b.n {
    private static final String WATERMARK_ALPHA_FRAG = "  varying highp vec2 textureCoordinate;\n  uniform sampler2D inputImageTexture;\n  uniform highp float alphaBlend;\n  \n  void main()\n  {\n      highp vec4 color = texture2D(inputImageTexture, textureCoordinate);\n      highp float alpha = color.a * alphaBlend;\n      gl_FragColor = vec4(color.rgb * alphaBlend,alpha);\n  }\n";
    private int mAlphaUniform;
    private float mWaterMarkAlpha;

    public UGCWatermarkFilter() {
        super(com.tencent.liteav.videobase.a.b.NO_FILTER_VERTEX_SHADER, WATERMARK_ALPHA_FRAG);
        this.mAlphaUniform = 1;
        this.mWaterMarkAlpha = 1.0f;
    }

    @Override // com.tencent.liteav.beauty.b.n, com.tencent.liteav.videobase.a.b
    public void afterDrawArrays() {
        GLES20.glUniform1f(this.mAlphaUniform, this.mWaterMarkAlpha);
        super.afterDrawArrays();
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void beforeDrawArrays(int i) {
        super.beforeDrawArrays(i);
        GLES20.glUniform1f(this.mAlphaUniform, 1.0f);
    }

    @Override // com.tencent.liteav.beauty.b.n, com.tencent.liteav.videobase.a.b
    public void onInit(com.tencent.liteav.videobase.frame.e eVar) {
        this.mAlphaUniform = GLES20.glGetUniformLocation(getProgramId(), "alphaBlend");
        this.mSrcBlendMode = 1;
    }

    public void setAlpha(float f) {
        this.mWaterMarkAlpha = f;
    }
}

package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.c.d;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUDissolveBlendFilter.class */
public class TXCGPUDissolveBlendFilter extends d {
    private static final String DISSOLVE_BLEND_FRAG = "precision mediump float;\nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\n\nuniform sampler2D inputImageTexture;\nuniform sampler2D inputImageTexture2;\nuniform float mixturePercent;\n\nvoid main()\n{\n   vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n   vec4 textureColor2 = texture2D(inputImageTexture2, textureCoordinate2);\n   \n   gl_FragColor = mix(textureColor, textureColor2, mixturePercent);\n}\n";
    private int mMixturePercentUniform;

    public TXCGPUDissolveBlendFilter() {
        super(DISSOLVE_BLEND_FRAG);
        this.mMixturePercentUniform = -1;
    }

    @Override // com.tencent.liteav.videobase.c.d, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mMixturePercentUniform = GLES20.glGetUniformLocation(getProgramId(), "mixturePercent");
        setMixLevel(0.5f);
    }

    public void setMixLevel(float f) {
        setFloatOnDraw(this.mMixturePercentUniform, f);
    }
}

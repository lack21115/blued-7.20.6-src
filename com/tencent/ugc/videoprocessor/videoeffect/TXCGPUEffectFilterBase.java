package com.tencent.ugc.videoprocessor.videoeffect;

import com.tencent.liteav.videobase.a.b;
import com.tencent.liteav.videobase.frame.e;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/TXCGPUEffectFilterBase.class */
public abstract class TXCGPUEffectFilterBase extends b {
    protected long mEffectStartTime;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/TXCGPUEffectFilterBase$VideoEffectParams.class */
    public static class VideoEffectParams {
    }

    public TXCGPUEffectFilterBase() {
        this(b.NO_FILTER_VERTEX_SHADER, "varying highp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
    }

    public TXCGPUEffectFilterBase(String str, String str2) {
        super(str, str2);
        this.mEffectStartTime = -1L;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mEffectStartTime = -1L;
    }

    public void setNextFrameTimestamp(long j) {
        if (this.mEffectStartTime == -1) {
            this.mEffectStartTime = j;
        }
    }
}

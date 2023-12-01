package com.tencent.ugc.videoprocessor.videoeffect.filter;

import android.opengl.GLES20;
import com.tencent.liteav.videobase.a.b;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUMirrorFilter.class */
public class TXCGPUMirrorFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_MIRROR_LV1 = 1000;
    private static final int DURATION_MIRROR_LV2 = 2000;
    private static final String FRAGMENT_SHADER = "varying highp vec2 textureCoordinate; \nuniform sampler2D inputImageTexture; \nuniform lowp float mode; \n \nvoid main() \n{ \n    highp vec2 position = textureCoordinate; \n     \n    if (mode <= 0.5) \n    { \n        if (position.x > 0.5) \n        { \n            position.x = 1.0 - position.x; \n        } \n    } \n    else \n    { \n        if (position.x > 0.5) \n        { \n            position.x = position.x - 0.5; \n        } \n        else \n        { \n            position.x = 0.5 - position.x; \n        } \n    } \n     \n    gl_FragColor = texture2D(inputImageTexture, position); \n} \n";
    private MirrorParam mMirrorParam;
    private int mModePos;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUMirrorFilter$MirrorParam.class */
    public static class MirrorParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float mode = 0.0f;
    }

    public TXCGPUMirrorFilter() {
        super(b.NO_FILTER_VERTEX_SHADER, FRAGMENT_SHADER);
        this.mModePos = -1;
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mModePos = GLES20.glGetUniformLocation(getProgramId(), "mode");
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mMirrorParam == null) {
            this.mMirrorParam = new MirrorParam();
        }
        long abs = Math.abs(j - this.mEffectStartTime);
        if (abs < 1000) {
            this.mMirrorParam.mode = 0.0f;
        } else if (abs < 2000) {
            this.mMirrorParam.mode = 1.0f;
        } else {
            this.mEffectStartTime = -1L;
        }
        setFloatOnDraw(this.mModePos, this.mMirrorParam.mode);
    }
}

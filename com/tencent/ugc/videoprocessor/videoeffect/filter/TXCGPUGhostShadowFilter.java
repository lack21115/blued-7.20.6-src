package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUGhostShadowFilter.class */
public class TXCGPUGhostShadowFilter extends TXCGPUEffectFilterBase {
    private static final String TAG = "TXCGPUGhostShadowFilter";
    private e mGLTexturePool;
    private TXCGPUDissolveBlendFilter mDissolveBlendFilter = null;
    private GhostShadowParam mGhostShadowParam = null;
    private TXCSavePreFrameFilter mSavePreFrameFilter = null;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUGhostShadowFilter$GhostShadowParam.class */
    public static class GhostShadowParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public int delayNumber = 5;
        public int shadowLevel = 1;
        public float mixLevel = 0.5f;
    }

    private boolean initParams(GhostShadowParam ghostShadowParam, int i, int i2) {
        if (ghostShadowParam == null) {
            return false;
        }
        TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
        if (tXCSavePreFrameFilter != null) {
            tXCSavePreFrameFilter.setSavePreFrameNumber(ghostShadowParam.delayNumber);
            return true;
        }
        return true;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (isInitialized()) {
            runPendingOnDrawTasks();
            if (initParams(this.mGhostShadowParam, this.mOutputSize.f22649a, this.mOutputSize.b)) {
                d a2 = this.mGLTexturePool.a(this.mOutputSize.f22649a, this.mOutputSize.b);
                TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
                if (tXCSavePreFrameFilter != null) {
                    tXCSavePreFrameFilter.onDrawToTexture(i, a2, floatBuffer, floatBuffer2);
                }
                TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = this.mDissolveBlendFilter;
                if (tXCGPUDissolveBlendFilter != null) {
                    tXCGPUDissolveBlendFilter.setSecondInputTexture(a2.a());
                    this.mDissolveBlendFilter.onDraw(i, dVar, floatBuffer, floatBuffer2);
                }
                a2.release();
            }
        }
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mGLTexturePool = eVar;
        if (this.mDissolveBlendFilter == null) {
            TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = new TXCGPUDissolveBlendFilter();
            this.mDissolveBlendFilter = tXCGPUDissolveBlendFilter;
            tXCGPUDissolveBlendFilter.initialize(eVar);
        }
        if (this.mSavePreFrameFilter == null) {
            TXCSavePreFrameFilter tXCSavePreFrameFilter = new TXCSavePreFrameFilter();
            this.mSavePreFrameFilter = tXCSavePreFrameFilter;
            tXCSavePreFrameFilter.initFilter(eVar);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = this.mDissolveBlendFilter;
        if (tXCGPUDissolveBlendFilter != null) {
            tXCGPUDissolveBlendFilter.onOutputSizeChanged(i, i2);
        }
        TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
        if (tXCSavePreFrameFilter != null) {
            tXCSavePreFrameFilter.onOutputSizeChanged(i, i2);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        TXCGPUDissolveBlendFilter tXCGPUDissolveBlendFilter = this.mDissolveBlendFilter;
        if (tXCGPUDissolveBlendFilter != null) {
            tXCGPUDissolveBlendFilter.uninitialize();
            this.mDissolveBlendFilter = null;
        }
        TXCSavePreFrameFilter tXCSavePreFrameFilter = this.mSavePreFrameFilter;
        if (tXCSavePreFrameFilter != null) {
            tXCSavePreFrameFilter.destroy();
            this.mSavePreFrameFilter = null;
        }
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mGhostShadowParam == null) {
            this.mGhostShadowParam = new GhostShadowParam();
        }
        this.mGhostShadowParam.delayNumber = 5;
        this.mGhostShadowParam.shadowLevel = 1;
        this.mGhostShadowParam.mixLevel = 0.5f;
    }
}

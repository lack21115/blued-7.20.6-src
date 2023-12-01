package com.tencent.ugc.videoprocessor.videoeffect.filter;

import com.tencent.liteav.videobase.frame.d;
import com.tencent.liteav.videobase.frame.e;
import com.tencent.ugc.UGCWatermarkAlphaTextureFilter;
import com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase;
import java.nio.FloatBuffer;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUSpiritOutFilter.class */
public class TXCGPUSpiritOutFilter extends TXCGPUEffectFilterBase {
    private static final int DURATION_SPIRITOUT_LV1 = 230;
    private static final int DURATION_SPIRITOUT_LV10 = 560;
    private static final int DURATION_SPIRITOUT_LV2 = 274;
    private static final int DURATION_SPIRITOUT_LV3 = 318;
    private static final int DURATION_SPIRITOUT_LV4 = 362;
    private static final int DURATION_SPIRITOUT_LV5 = 406;
    private static final int DURATION_SPIRITOUT_LV6 = 450;
    private static final int DURATION_SPIRITOUT_LV7 = 494;
    private static final int DURATION_SPIRITOUT_LV8 = 538;
    private static final int DURATION_SPIRITOUT_LV9 = 582;
    private static final int DURATION_SPIRITOUT_LVMAX = 1120;
    private static final int DURATION_SPIRITOUT_LVMIN = 120;
    private static final String TAG = "TXCGPUSpiritOutFilter";
    private e mTexturePool;
    protected TXCZoomInOutFilter mZoomInOutFilter = null;
    private UGCWatermarkAlphaTextureFilter mTextureWaterMarkFilter = null;
    private SpiritOutEffectParam mSpritParams = null;
    private int mTextureWidth = -1;
    private int mTextureHeight = -1;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/ugc/videoprocessor/videoeffect/filter/TXCGPUSpiritOutFilter$SpiritOutEffectParam.class */
    public static class SpiritOutEffectParam extends TXCGPUEffectFilterBase.VideoEffectParams {
        public float zoomCenterX = 0.5f;
        public float zoomCenterY = 0.5f;
        public int fringeNumber = 1;
        public int zoomOutLevel = 1;
        public float alpahLevel = 0.5f;
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onDraw(int i, d dVar, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        TXCZoomInOutFilter tXCZoomInOutFilter;
        if (isInitialized()) {
            runPendingOnDrawTasks();
            SpiritOutEffectParam spiritOutEffectParam = this.mSpritParams;
            if (spiritOutEffectParam == null || (tXCZoomInOutFilter = this.mZoomInOutFilter) == null || this.mTextureWaterMarkFilter == null) {
                return;
            }
            tXCZoomInOutFilter.setZoomLevel(0.96f, spiritOutEffectParam.zoomOutLevel);
            this.mZoomInOutFilter.setAlphaLevel(this.mSpritParams.alpahLevel);
            d a2 = this.mTexturePool.a(this.mTextureWidth, this.mTextureHeight);
            this.mZoomInOutFilter.onDraw(i, a2, floatBuffer, floatBuffer2);
            this.mTextureWaterMarkFilter.setTextureWatermark(a2.a(), this.mTextureWidth, this.mTextureHeight, 0.0f, 0.0f, 1.0f);
            this.mTextureWaterMarkFilter.setAlpha(this.mSpritParams.alpahLevel);
            this.mTextureWaterMarkFilter.onDraw(i, dVar, floatBuffer, floatBuffer2);
            a2.release();
        }
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase, com.tencent.liteav.videobase.a.b
    public void onInit(e eVar) {
        super.onInit(eVar);
        this.mTexturePool = eVar;
        if (this.mZoomInOutFilter == null) {
            TXCZoomInOutFilter tXCZoomInOutFilter = new TXCZoomInOutFilter();
            this.mZoomInOutFilter = tXCZoomInOutFilter;
            tXCZoomInOutFilter.initialize(eVar);
        }
        if (this.mTextureWaterMarkFilter == null) {
            UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = new UGCWatermarkAlphaTextureFilter();
            this.mTextureWaterMarkFilter = uGCWatermarkAlphaTextureFilter;
            uGCWatermarkAlphaTextureFilter.initialize(eVar);
            this.mTextureWaterMarkFilter.setAlpha(0.5f);
            this.mTextureWaterMarkFilter.enableWatermark(true);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onOutputSizeChanged(int i, int i2) {
        super.onOutputSizeChanged(i, i2);
        this.mTextureWidth = i;
        this.mTextureHeight = i2;
        TXCZoomInOutFilter tXCZoomInOutFilter = this.mZoomInOutFilter;
        if (tXCZoomInOutFilter != null) {
            tXCZoomInOutFilter.onOutputSizeChanged(i, i2);
        }
        UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = this.mTextureWaterMarkFilter;
        if (uGCWatermarkAlphaTextureFilter != null) {
            uGCWatermarkAlphaTextureFilter.onOutputSizeChanged(i, i2);
        }
    }

    @Override // com.tencent.liteav.videobase.a.b
    public void onUninit() {
        super.onUninit();
        TXCZoomInOutFilter tXCZoomInOutFilter = this.mZoomInOutFilter;
        if (tXCZoomInOutFilter != null) {
            tXCZoomInOutFilter.uninitialize();
            this.mZoomInOutFilter = null;
        }
        UGCWatermarkAlphaTextureFilter uGCWatermarkAlphaTextureFilter = this.mTextureWaterMarkFilter;
        if (uGCWatermarkAlphaTextureFilter != null) {
            uGCWatermarkAlphaTextureFilter.uninitialize();
            this.mTextureWaterMarkFilter = null;
        }
    }

    @Override // com.tencent.ugc.videoprocessor.videoeffect.TXCGPUEffectFilterBase
    public void setNextFrameTimestamp(long j) {
        super.setNextFrameTimestamp(j);
        if (this.mSpritParams == null) {
            SpiritOutEffectParam spiritOutEffectParam = new SpiritOutEffectParam();
            this.mSpritParams = spiritOutEffectParam;
            spiritOutEffectParam.fringeNumber = 1;
            this.mSpritParams.alpahLevel = 0.3f;
        }
        long abs = Math.abs(j - this.mEffectStartTime);
        if (abs < 120) {
            this.mSpritParams.zoomOutLevel = 0;
        } else if (abs < 230) {
            this.mSpritParams.zoomOutLevel = 1;
        } else if (abs < 274) {
            this.mSpritParams.zoomOutLevel = 2;
        } else if (abs < 318) {
            this.mSpritParams.zoomOutLevel = 3;
        } else if (abs < 362) {
            this.mSpritParams.zoomOutLevel = 4;
        } else if (abs < 406) {
            this.mSpritParams.zoomOutLevel = 5;
        } else if (abs < 450) {
            this.mSpritParams.zoomOutLevel = 6;
        } else if (abs < 494) {
            this.mSpritParams.zoomOutLevel = 7;
        } else if (abs < 538) {
            this.mSpritParams.zoomOutLevel = 8;
        } else if (abs < 582) {
            this.mSpritParams.zoomOutLevel = 9;
        } else if (abs < 1120) {
            this.mSpritParams.zoomOutLevel = 0;
        } else {
            this.mEffectStartTime = -1L;
        }
    }
}
